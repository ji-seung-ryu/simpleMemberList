package com.clean.example;

public class Member {
    private String memberId, name;

    public String getMemberId(){
        return this.memberId;
    }
    public String getName (){
        return this.name;
    }

    public Member (String memberId, String name){
        this.memberId = memberId;
        this.name = name;

    }
}
