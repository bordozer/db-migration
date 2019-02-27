package com.bordozer.poc.dbmigration.common;

import javax.sql.DataSource;

import org.dbunit.database.IDatabaseConnection;
import org.dbunit.ext.h2.H2DataTypeFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.springtestdbunit.bean.DatabaseConfigBean;
import com.github.springtestdbunit.bean.DatabaseDataSourceConnectionFactoryBean;

import lombok.SneakyThrows;

@Configuration
public class H2TestConfiguration {

    @Bean
    public DatabaseConfigBean databaseConfigBean() {
        final DatabaseConfigBean config = new DatabaseConfigBean();
        config.setDatatypeFactory(new H2DataTypeFactory());
        config.setCaseSensitiveTableNames(false);
        config.setQualifiedTableNames(Boolean.TRUE);
        return config;
    }

    @Bean
    public DatabaseDataSourceConnectionFactoryBean testConnection(final DataSource dataSource, final DatabaseConfigBean databaseConfigBean) {
        final DatabaseDataSourceConnectionFactoryBean databaseDataSourceConnectionFactoryBean = new DatabaseDataSourceConnectionFactoryBean();
        databaseDataSourceConnectionFactoryBean.setDataSource(dataSource);
        databaseDataSourceConnectionFactoryBean.setDatabaseConfig(databaseConfigBean);
        return databaseDataSourceConnectionFactoryBean;
    }

    @SneakyThrows
    @Bean
    IDatabaseConnection h2DataSource(final DatabaseDataSourceConnectionFactoryBean databaseDataSourceConnectionFactoryBean) {
        return databaseDataSourceConnectionFactoryBean.getObject();
    }
}
