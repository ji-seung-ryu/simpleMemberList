package com.clean.example;

import java.util.List;
public interface GetMemberDetails {
    Member getDetails(String memberId);
    void create(String memberId, String name);
    void deposit (String memberId, int amount);
    void withdraw (String memberId, int amount);

    List<String> getAllMemberName();
}
