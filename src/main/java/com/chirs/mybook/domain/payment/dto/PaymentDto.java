package com.chirs.mybook.domain.payment.dto;

import com.chirs.mybook.domain.payment.Payment;
import com.chirs.mybook.domain.payment.enums.PaymentStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class PaymentDto {

  private Long paymentId;
  private Long subscriptionId;
  private Long paymentCardId;
  private PaymentStatus paymentStatus;
  private String approveNo;
  private long amount;
  private String resultMessage;

  public PaymentDto(Payment payment) {
    this.paymentId = payment.getId();
    if (payment.getSubscription() != null){
      this.subscriptionId = payment.getSubscription().getId();
    }
    this.paymentCardId = payment.getPaymentCard().getId();
    this.paymentStatus = payment.getPaymentStatus();
    this.approveNo = payment.getApproveNo();
    this.amount = payment.getAmount();
    this.resultMessage = payment.getResultMessage();
  }

  @Builder
  public PaymentDto(Long subscriptionId, Long paymentCardId, PaymentStatus paymentStatus, String approveNo, long amount,
      String resultMessage) {
    this.subscriptionId = subscriptionId;
    this.paymentCardId = paymentCardId;
    this.paymentStatus = paymentStatus;
    this.approveNo = approveNo;
    this.amount = amount;
    this.resultMessage = resultMessage;
  }
}
