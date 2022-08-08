package com.clean.example.controller;

import net.bytebuddy.dynamic.DynamicType;
import org.junit.jupiter.api.Test;
import com.clean.example.entity.Member;
import com.clean.example.usecase.MainUseCase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

public class ControllerTest {

    private static final String MEMBERID = "q8514199";
    private static final String NAME = "jiseung";
    MainUseCase mainUseCase = mock(MainUseCase.class);

    @Test
    public void returnTheMember(){
        givenAMemberExists();
        Optional<Member> OptionalMember = mainUseCase.GetMemberByMemberId(MEMBERID);

        Member member = OptionalMember.get();

        assertThat(member).isNotNull();
        assertThat(member.getName()).isEqualTo(NAME);
    }

    private void givenAMemberExists(){
        Member member = new Member();
        member.setName(NAME);
        member.setMemberId(MEMBERID);

        Optional<Member> OptionalMember = Optional.of(member);
        when(mainUseCase.GetMemberByMemberId(MEMBERID)).thenReturn(OptionalMember);

    }

}
