package com.bit.test;

import com.bit.test.config.TestConfiguration;
import com.bit.test.model.ProphetProperties;
import com.bit.test.web.IronBankController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManagerFactory;
import java.sql.DatabaseMetaData;

import static org.mockito.Mockito.mock;

@RunWith(JUnitPlatform.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TestConfiguration.class)
public class MoneyRavenApplicationTests {

    @Autowired
    ProphetProperties prophetProperties;

    @Mock
    IronBankController ironBankController;
    @Mock
    EntityManagerFactory entityManagerFactory;

    @Test
    void contextLoads() {
        assert prophetProperties.getThoseWhoReturnDebts().contains("Lanister");
    }
}
