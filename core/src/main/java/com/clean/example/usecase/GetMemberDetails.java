package com.clean.example.usecase;

import com.clean.example.entity.Member;

import java.util.List;
public interface GetMemberDetails {

    Member getDetails(String memberId) throws Exception;
    void create(String memberId, String name)throws Exception ;
    void deposit (String memberId, int amount);
    void withdraw (String memberId, int amount);

    List<String> getAllMemberName();
}
