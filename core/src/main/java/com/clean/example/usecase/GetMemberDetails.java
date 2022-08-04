package com.clean.example.usecase;

import com.clean.example.entity.Member;

import java.util.List;
import java.util.Optional;

public interface GetMemberDetails {

    Optional<Member> getMemberByMemberId(String memberId);
    void create(String memberId, String name) ;
    void deposit (String memberId, int amount);
    void withdraw (String memberId, int amount);

    List<String> getAllMemberName();
}
