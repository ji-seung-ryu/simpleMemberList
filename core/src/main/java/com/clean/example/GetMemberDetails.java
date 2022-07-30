package com.clean.example;

public interface GetMemberDetails {
    Member getDetails(String memberId);
    void create(String memberId, String name);
    void deposit (String memberId, int amount);
    void withdraw (String memberId, int amount);
}
