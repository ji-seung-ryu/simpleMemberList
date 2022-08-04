package com.clean.example.dataproviders;

import com.clean.example.usecase.GetMemberDetails;
import com.clean.example.entity.Member;

import java.util.ArrayList;
import java.util.List;


import java.util.logging.Logger;
import java.util.Optional;

public class MemberDataProvider implements GetMemberDetails {

    private final MemberRepository memberRepository;
    private final static Logger LOG = Logger.getGlobal();

    public MemberDataProvider(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Optional<Member> getMemberByMemberId(String memberId) {

        Optional<MemberData> memberData = this.memberRepository.findByMemberId(memberId);
        if (memberData.isPresent()) {
            return convertOptionalMemberDataToOptionalMember(memberData);
        } else {
            return Optional.empty();
        }

    }

    @Override
    public void create(String memberId, String name) {
        try {
            if (isDuplicated(memberId)) throw new MemberDuplicateException();
            MemberData memberData = new MemberData(memberId, name);
            this.memberRepository.save(memberData);
        } catch (MemberDuplicateException e) {
            LOG.warning("create duplicated member");
        }
    }


    @Override
    public void deposit(String memberId, int amount) {


    }

    @Override
    public void withdraw(String memberId, int amount) {
    }

    @Override
    public List<String> getAllMemberName() {
        List<MemberData> AllMemberData = this.memberRepository.findAll();
        return extractNamesFromData(AllMemberData);
    }

    private boolean isDuplicated(String memberId) {
        Optional<MemberData> memberData = this.memberRepository.findByMemberId(memberId);
        return memberData.isPresent();
    }

    private Optional<Member> convertOptionalMemberDataToOptionalMember(Optional<MemberData> memberData) {
        Member convertedMember = convertMemberDataToMember(memberData.get());
        return Optional.of(convertedMember);
    }

    private Member convertMemberDataToMember(MemberData memberData) {
        Member member = new Member();
        member.setMemberId(memberData.getMemberId());
        member.setName(memberData.getName());
        return member;
    }

    private List<String> extractNamesFromData (List<MemberData> AllMemberData){
        List<String> AllMemberName = new ArrayList<>();
        for (MemberData m : AllMemberData) AllMemberName.add(m.getName());
        return AllMemberName;
    }
}