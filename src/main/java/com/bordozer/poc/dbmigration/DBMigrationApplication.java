package com.bordozer.poc.dbmigration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

import com.bordozer.commons.config.Java8DateTimeConfiguration;

@SuppressWarnings("PMD.UseUtilityClass")
@SpringBootApplication
@Import(Java8DateTimeConfiguration.class)
public class DBMigrationApplication extends SpringBootServletInitializer {

    public static void main(final String[] args) {
        SpringApplication.run(DBMigrationApplication.class, args);
    }
}

