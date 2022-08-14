package com.chirs.mybook.domain.member.service;

import com.chirs.mybook.domain.member.Member;
import com.chirs.mybook.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DetailMemberService {

  private final MemberRepository memberRepository;
  private final long memberId = 1;


  @Transactional(readOnly = true)
  public Member getLoginMember() {
    return memberRepository.findById(memberId)
        .orElse(null);
  }

}
