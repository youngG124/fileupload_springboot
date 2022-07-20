package com.example.dataUpload.repository;

import com.example.dataUpload.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author KimShinyeong
 */
public interface MemberRepository extends JpaRepository<Member, Long> {
}
