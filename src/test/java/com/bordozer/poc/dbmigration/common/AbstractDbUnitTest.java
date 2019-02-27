package com.bordozer.poc.dbmigration.common;

import org.springframework.context.annotation.Import;

import com.github.springtestdbunit.annotation.DbUnitConfiguration;

@Import(H2TestConfiguration.class)
@DbUnitConfiguration(databaseConnection = "h2DataSource")
public class AbstractDbUnitTest {

    protected AbstractDbUnitTest() {
        // parent DAO test cannot be created
    }
}
