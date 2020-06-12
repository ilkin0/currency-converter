package com.ilkin.currencyconverter.controller;

import com.ilkin.currencyconverter.TestConfiguration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class WebControllerTests extends TestConfiguration {

    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    public static void init(){
        System.out.println("init test for Web Controller");
    }

    @Test
    public void getIndex() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("web/index"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/web/index.jsp"));
    }


}
