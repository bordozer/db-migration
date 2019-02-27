package com.bordozer.poc.dbmigration.web.controller;

import static com.bordozer.commons.testing.endpoint.EndpointTestBuilder.testEndpoint;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bordozer.commons.testing.endpoint.AbstractEndpointTest;
import com.bordozer.commons.utils.FileUtils;
import com.bordozer.poc.dbmigration.service.UserService;
import com.bordozer.poc.dbmigration.web.dto.UserDto;

@WebMvcTest(UserController.class)
class UserControllerTest extends AbstractEndpointTest {

    private static final String URL = "/users/";

    @MockBean
    private UserService userService;

    @Test
    void shouldReturn200AndOkIfLoggedSuccessfully() {
        // given
        final UserDto userDto = UserDto.builder()
                .userId(34556L)
                .userName("Lets Rock")
                .userAge(45)
                .birthday(LocalDate.of(1974, 5, 23))
                .build();
        when(userService.getAllUsers()).thenReturn(Lists.newArrayList(userDto));

        // when
        getTo(testEndpoint(URL)
                .whenRequest()
                .thenResponseSuccessWithJsonBody(FileUtils.readSystemResource("tests/UserController/users-expected-response.json"))
        );
    }
}
