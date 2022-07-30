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



    @Override
    public void deposit (String memberId, int amount){
        MemberEntity memberEntity = this.memberRepository.findByMemberId(memberId);
        int curBalance = memberEntity.getBalance();
        memberEntity.setBalance(curBalance+amount);

    }

    @Override
    public void withdraw (String memberId, int amount){
        deposit(memberId, -amount);
    }



}
