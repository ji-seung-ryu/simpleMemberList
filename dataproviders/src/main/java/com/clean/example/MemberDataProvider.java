package com.clean.example;

import com.clean.example.GetMemberDetails;
import com.clean.example.Member;

public class MemberDataProvider implements GetMemberDetails{

    private final MemberRepository memberRepository;

    public MemberDataProvider(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    @Override
    public Member getDetails(String memberId){

        MemberEntity memberEntity = this.memberRepository.findByMemberId(memberId);
        return new Member (memberId, memberEntity.getName());

    }

    @Override
    public void create(String memberId, String name){
        MemberEntity memberEntity = new MemberEntity(memberId, name);
        this.memberRepository.save(memberEntity);
    }


}
