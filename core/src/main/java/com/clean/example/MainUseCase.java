package com.clean.example;

public class MainUseCase {


    public String s(String id){
        return "aa";
    }
    private final GetMemberDetails getMemberDetails;

    public MainUseCase (GetMemberDetails getMemberDetails){
        this.getMemberDetails = getMemberDetails;
    }

    public void CreateMember(String memberId, String name){
        getMemberDetails.create(memberId, name);
    }
    public Member GetMemberDetails(String id){
        return getMemberDetails.getDetails(id);
    }

}
