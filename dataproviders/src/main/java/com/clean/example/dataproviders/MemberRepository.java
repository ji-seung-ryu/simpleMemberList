package com.clean.example.dataproviders;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberData, Integer>{
    Optional<MemberData> findByMemberId(String memberId);

}
