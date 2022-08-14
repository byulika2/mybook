package com.chirs.mybook.domain.member.dto;

import com.chirs.mybook.domain.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class MemberDto {

  private Long memberId;

  private String name;

  public MemberDto(Member member) {
    this.memberId = member.getId();
    this.name = member.getName();
  }
}
