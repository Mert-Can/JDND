package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TokenAuthenticationServiceTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldNotAllowAccessToUnauthenticatedUsers() throws Exception {
        mvc.perform(get("/api/item")).andExpect(status().isForbidden());
    }

    @Test
    public void shouldGenerateAuthToken() throws Exception {
//        JWTAuthenticationFilter test2 = successfulAuthentication

//        mvc.perform(get("/api/user/create?username='asd'&password='bad'").contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isForbidden());



//        assertNotNull(token);
       mvc.perform(MockMvcRequestBuilders.get("/api/item").header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0MiIsImV4cCI6MTU2NTM1NTc5MH0.zhGQ0QMkrD4C7BADfwl3MrHXIx6G8EtPj_QFeQU4Ojg2IOec29XvGLg6wpZTe4SQ6zRSUHOs5hbrLzkRuNdZbg")).andExpect(status().isOk());
    }

}
