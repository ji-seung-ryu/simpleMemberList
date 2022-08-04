package com.clean.example.dataproviders;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface MemberRepository extends JpaRepository<MemberEntity, Integer>{
    List<MemberEntity> findByMemberId(String memberId);

}
