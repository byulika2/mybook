package com.chirs.mybook.domain.transaction_propagation.dto;

import com.chirs.mybook.domain.transaction_propagation.TransactionPropagation;
import com.chirs.mybook.domain.transaction_propagation.enums.PropagationType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class TransactionPropagationDto {

  private Long transactionPropagationId;

  private String abType;

  private PropagationType propagationType;
  private String comment;

  @Builder
  public TransactionPropagationDto(String abType, PropagationType propagationType) {
    this.abType = abType;
    this.propagationType = propagationType;
    this.comment = propagationType.getComment();
  }

  public TransactionPropagationDto(TransactionPropagation transactionPropagation) {
    this.transactionPropagationId = transactionPropagation.getId();
    this.abType = transactionPropagation.getAbType();
    this.propagationType = transactionPropagation.getPropagationType();
    this.comment = propagationType.getComment();
  }
}
