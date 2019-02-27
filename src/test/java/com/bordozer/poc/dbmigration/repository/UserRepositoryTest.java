package com.bordozer.poc.dbmigration.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.bordozer.poc.dbmigration.common.AbstractDbUnitTest;
import com.bordozer.poc.dbmigration.domain.User;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestExecutionListeners(
        {
                DependencyInjectionTestExecutionListener.class,
                DbUnitTestExecutionListener.class
        })
class UserRepositoryTest extends AbstractDbUnitTest {

    @Autowired
    private UserRepository userRepository;

    @Value(value = "${application.properties.schema}")
    private String schema;

    @DatabaseSetup("/tests/UserRepositoryTest/initDB.xml")
    @Test
    void shouldInsertLogRecordOfFeedActivity() {
        // given

        // when
        final List<User> users = userRepository.getAllUsers(schema);

        // then
        assertThat(users)
                .isNotNull()
                .hasSize(3)
                .first()
                .satisfies(user -> {
                    assertThat(user).isNotNull();
                    assertThat(user.getUserId()).isEqualTo(2047L);
                    assertThat(user.getUsername()).isEqualTo("Jupiter");
                    assertThat(user.getAge()).isEqualTo(27);
                    assertThat(user.getBirthday()).isEqualTo(LocalDateTime.of(1991, 10, 24, 0, 0));
                });
    }
}
