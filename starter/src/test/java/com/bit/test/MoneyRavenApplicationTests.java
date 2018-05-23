package com.bit.test;

import com.bit.test.config.TestConfiguration;
import com.bit.test.model.ProphetProperties;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.DatabaseMetaData;

import static org.mockito.Mockito.mock;

@RunWith(JUnitPlatform.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TestConfiguration.class)
public class MoneyRavenApplicationTests {

    @Autowired
    ProphetProperties prophetProperties;

    @Test
    void contextLoads() {
        assert prophetProperties.getThoseWhoReturnDebts().contains("Lanister");
    }
}
