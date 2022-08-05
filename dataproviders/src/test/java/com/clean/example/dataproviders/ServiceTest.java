package com.clean.example.dataproviders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.clean.example.entity.Member;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {
    @Mock
    MemberRepository memberRepository;

    @InjectMocks
    MemberService memberService;

    @Test
    void returnsEmptyListWhenThereAreNoMember (){
        givenThereAreNoMember();
        List<String> AllMemberName = memberService.getAllMemberName();
        assertThat(AllMemberName).isEmpty();
    }

    private void givenThereAreNoMember(){
        when(memberRepository.findAll()).thenReturn(new ArrayList<>());
    }

}
