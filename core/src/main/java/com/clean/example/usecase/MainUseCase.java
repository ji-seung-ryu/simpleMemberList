package com.clean.example.usecase;

import com.clean.example.entity.Member;
import com.clean.example.usecase.GetMemberDetails;

import java.util.List;
public class MainUseCase {

    private final GetMemberDetails getMemberDetails;

    public MainUseCase (GetMemberDetails getMemberDetails){
        this.getMemberDetails = getMemberDetails;
    }

    public void CreateMember(String memberId, String name){

        try{
            getMemberDetails.create(memberId, name);
        } catch (Exception e){
            System.out.println(e.getMessage());

        }
    }
    public Member GetMemberDetails(String id){
        return getMemberDetails.getDetails(id);
    }
    public List<String> GetAllMemberName() {return getMemberDetails.getAllMemberName(); }


}
