package com.clean.example.dataproviders;

import com.clean.example.entity.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class IntegrationTest {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MemberService memberDataProvider;

    @BeforeEach
    void cleanUp() {
        this.memberRepository.deleteAll();
    }
    @Test
    void getAllMember(){
        givenAMember("memberId1","name1");
        givenAMember("memberId2","name2");
        List<String> allMemberName = this.memberDataProvider.getAllMemberName();
        assertThat(allMemberName).containsOnly("name1","name2");
    }

    @Test
    void findMember(){
        givenAMember("memberId1","name1");
        Optional<Member> foundMember = this.memberDataProvider.getMemberByMemberId("memberId1");
        assertThat(foundMember.get().getName()).isEqualTo("name1");
    }

    @Test
    void duplicatedMemberId() throws Exception{
        givenAMember("memberId1","name1");
        givenAMember("memberId1","name2");
    }

    private void givenAMember (String memberId, String name){
        this.memberDataProvider.create(memberId,name);
    }
}
