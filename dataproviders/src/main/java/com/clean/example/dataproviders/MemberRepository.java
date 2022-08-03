package com.clean.example.dataproviders;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Integer>{
    Optional<MemberEntity> findByMemberId(String memberId);

}
