package com.clean.example.dataproviders;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void save(){
        MemberData m = new MemberData();
        m.setName("ji");
        m.setMemberId("asdsa");
        this.memberRepository.save(m);
        assert(this.memberRepository.findByMemberId("asdsa").get().getName() == "ji");
    }
}
