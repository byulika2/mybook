package com.chirs.mybook.domain.payment.dto.request;

import com.chirs.mybook.domain.payment.enums.PaymentStatus;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SavePaymentRequest {

  private Long amount;

  private PaymentStatus paymentStatus;
}
