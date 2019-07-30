package com.example.demo;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ControllerTest1 {

    private String input;
    private String output;

    public ControllerTest1(String input) {

        super();
        this.input = input;
    }

    @Parameterized.Parameters
    public static Collection initData() {
        String username[][] =  {{"Mert","actual"},{"Mert"},{"John"}};
        return Arrays.asList(username);
    }

}
