package com.clean.example.dataproviders;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class MemberData {
    public MemberData(){

    }

    public MemberData(String memberId, String name) {
        this.name = name;
        this.memberId = memberId;
        this.balance = 0;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String memberId;
    @Column(length = 200)
    private String name;

    @Column
    private int balance;

    public String getMemberId (){
        return this.memberId;
    }
    public String getName(){
        return this.name;
    }
    public int getBalance() {return this.balance;}
    public void setBalance(int balance) {
        this.balance = balance;
    }
    public void setName (String name){this.name = name;}
    public void setMemberId (String memberId){this.memberId = memberId;}



}
