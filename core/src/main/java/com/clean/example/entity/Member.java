package com.clean.example.entity;

public class Member {
    private String memberId, name;

    public void setMemberId(String memberId){
        this.memberId = memberId;
    }
    public void setName (String name){
        this.name = name;
    }
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
    public Member(){

    }
}
