package com.clean.example.dataproviders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberData, Integer>{
    Optional<MemberData> findByMemberId(String memberId);

}
