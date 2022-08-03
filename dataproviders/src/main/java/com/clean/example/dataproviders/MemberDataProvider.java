package com.clean.example.dataproviders;

import com.clean.example.usecase.GetMemberDetails;
import com.clean.example.entity.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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
    public void deposit (String memberId, int amount) throws NoSuchElementException {
        MemberEntity memberEntity = this.memberRepository.findByMemberId(memberId).orElseThrow();
        int curBalance = memberEntity.getBalance();
        memberEntity.setBalance(curBalance+amount);

    }

    @Override
    public void withdraw (String memberId, int amount){
        deposit(memberId, -amount);
    }

    @Override
    public List<String> getAllMemberName(){
        List<MemberEntity> AllMember = this.memberRepository.findAll();
        List<String> AllMemberName = new ArrayList<>();
        for (MemberEntity m : AllMember) AllMemberName.add(m.getName());
        return AllMemberName;
    }



}
