package com.chirs.mybook.domain.member.repository;

import com.chirs.mybook.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
