package com.bit.test.config;

import com.bit.test.dao.repository.MoneyRepository;
import com.bit.test.service.TransferMoneyService;
import com.bit.test.web.IronBankController;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
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

        DatabaseMetaData databaseMetaData = mock(DatabaseMetaData.class);
        when(connection.getMetaData()).thenReturn(databaseMetaData);

        return defaultDataSource;
    }

//    @Primary
//    @Bean
//    public EntityManagerFactory entityManagerFactory() {
//        return mock(EntityManagerFactory.class);
//    }
//
//    @Primary
//    @Bean("transferMoneyServiceImpl")
//    public TransferMoneyService transferMoneyService() {
//        return mock(TransferMoneyService.class);
//    }
//
//    @Primary
//    @Bean
//    public MoneyRepository moneyRepository() {
//        return mock(MoneyRepository.class);
//    }
//
//    @Primary
//    @Bean
//    public IronBankController ironBankController() {
//        return mock(IronBankController.class);
//    }
}
