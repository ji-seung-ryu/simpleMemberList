package com.clean.example;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Integer>{
    MemberEntity findByMemberId(String memberId);

}
