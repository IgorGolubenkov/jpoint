package com.bit.test.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@org.springframework.boot.test.context.TestConfiguration
@EnableTransactionManagement
public class TestConfiguration {

    @Primary
    @Bean("hikariDataSource")
    public HikariDataSource dataSource() throws SQLException {
        //Arrange
        HikariDataSource defaultDataSource = mock(HikariDataSource.class);
        Connection connection = mock(Connection.class);
        when(defaultDataSource.getConnection()).thenReturn(connection);
        return defaultDataSource;
    }

    @Bean
    public DatabaseMetaData databaseMetaData() {
        return mock(DatabaseMetaData.class);
    }
}
