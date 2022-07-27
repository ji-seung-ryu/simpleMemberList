package com.clean.example;

public interface GetMemberDetails {
    Member getDetails(String memberId);
    void create(String memberId, String name);
}
