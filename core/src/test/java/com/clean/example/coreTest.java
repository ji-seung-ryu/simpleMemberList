package com.clean.example;

import org.junit.jupiter.api.Test;
public class coreTest {
    @Test
    public void justTest(){
        Member m = new Member("sfa","dsfd");
        assert (m.getName() == "dsfd");
    }
}
