package com.chirs.mybook.domain.transaction_propagation.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum PropagationType {
  NONE("사용X"),
  REQUIRED("현재 트랜잭션을 지원하고, 없으면 새 트랜잭션을 만듭니다.기본 설정입니다."),
  SUPPORTS("현재 트랜잭션을 지원하고, 트랜잭션이 없으면 비 트랜잭션으로 실행합니다."),
  MANDATORY("현재 트랜잭션을 지원하고, 예외가 없는 경우 예외를 발생시킵니다."),
  REQUIRES_NEW("새 트랜잭션을 만들고 현재 트랜잭션이 있으면 일시 중단합니다."),
  NOT_SUPPORTED("비 트랜잭션으로 실행, 현재 트랜잭션이 있으면 일시 중단합니다."),
  NEVER("비 트랜잭션으로 실행, 트랜잭션이 있으면 예외를 발생시킵니다. "),
  NESTED("현재 트랜잭션이 있는 경우 중첩된 트랜잭션 내에서 실행, 그렇지 않으면 REQUIRED 처럼 동작합니다.");

  private String comment;


}
