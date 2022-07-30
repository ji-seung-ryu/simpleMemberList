package com.clean.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

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
