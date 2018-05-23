package com.bit.test;

import com.bit.test.service.ProphetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(JUnitPlatform.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class IronBankControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ProphetService prophetService;

    @BeforeEach
    void before() {
        when(prophetService.willSurvice(anyString()))
                .thenReturn(true);
    }

    @Test
    void shouldCredit() throws Exception {
        mockMvc.perform(
                get("/credit?name=Rob&amount=10"))
                .andExpect(status().isOk());

        mockMvc.perform(
                get("/state"))
                .andExpect(status().isOk())
                .andExpect(content().string("100490"))
                .andReturn();
    }
}
