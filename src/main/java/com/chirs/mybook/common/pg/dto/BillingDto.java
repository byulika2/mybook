package com.chirs.mybook.common.pg.dto;

import com.chirs.mybook.domain.payment.enums.PaymentStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class BillingDto {

  private Long paymentCardId;

  private long amount;

  private PaymentStatus paymentStatus;
}
