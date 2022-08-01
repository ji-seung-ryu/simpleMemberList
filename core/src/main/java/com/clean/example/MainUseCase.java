package com.clean.example;

import java.util.List;
public class MainUseCase {

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
    public List<String> GetAllMemberName() {return getMemberDetails.getAllMemberName(); }


}
