package com.example.demo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class ItemControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void contextLoads() {
    }

    @Test
    public void AuthorisationTest() throws Exception {

        mvc.perform(
                get("/api/item")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());
    }

    @Test
    public void UsernameTest() throws Exception {

        mvc.perform(get("/api/order/submit/mert")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());
    }

    @Test
    public void Cart_access_item_test_Is_Not_yet_created () throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/api/cart").header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0MiIsImV4cCI6MTU2NTM1NTc5MH0.zhGQ0QMkrD4C7BADfwl3MrHXIx6G8EtPj_QFeQU4Ojg2IOec29XvGLg6wpZTe4SQ6zRSUHOs5hbrLzkRuNdZbg")).andExpect(status().isNotFound());

    }
    @Test
    public void Item_access_item_test_Is_Not_yet_created () throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/api/item/1").header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0MiIsImV4cCI6MTU2NTM1NTc5MH0.zhGQ0QMkrD4C7BADfwl3MrHXIx6G8EtPj_QFeQU4Ojg2IOec29XvGLg6wpZTe4SQ6zRSUHOs5hbrLzkRuNdZbg")).andExpect(status().isOk());

    }

    @Test
    public void user_access_granted() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/api/user/create?username='user'&password='pass'").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON).header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNTY1NDM0NDY1fQ.FlX1amHpqicfQZ7G0_keK5v9o4iUSXutkbmnFOyjfwpHiwyMinsFKMXcRecgyMztGCd-HsnKcSrNa3XAAbIlxA")).andExpect(status().isNotFound());
    }

}
