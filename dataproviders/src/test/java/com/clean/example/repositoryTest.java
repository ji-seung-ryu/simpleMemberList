package com.clean.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class repositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void TestJpa(){
        MemberEntity m = new MemberEntity("asd","sada");

        this.memberRepository.save(m);

    }
}
