package com.chirs.mybook.common.pg;

import com.chirs.mybook.common.pg.dto.BillingDto;
import com.chirs.mybook.common.pg.dto.TossPaymentsResponse;
import com.chirs.mybook.domain.payment.Payment;
import com.chirs.mybook.domain.payment.dto.PaymentDto;
import com.chirs.mybook.domain.payment.enums.PaymentStatus;
import com.chirs.mybook.domain.payment.repository.PaymentRepository;
import com.chirs.mybook.domain.payment_card.PaymentCard;
import com.chirs.mybook.domain.payment_card.repository.PaymentCardRepository;
import java.util.Random;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class TossPayments {

  private final PaymentCardRepository paymentCardRepository;
  private final PaymentRepository paymentRepository;


  @Transactional
  public TossPaymentsResponse billing(BillingDto billingDto){

    PaymentCard paymentCard = paymentCardRepository.findById(billingDto.getPaymentCardId())
        .orElseThrow(() -> new RuntimeException("결제수단 없음."));

    String approveNo = "";
    String resultMessage = "결제 완료";
    try{
      if (billingDto.getPaymentStatus() == PaymentStatus.실패){
        throw new Exception("결제 실패!!");
      }
      approveNo = String.valueOf(UUID.randomUUID());

    }catch (Exception e){
      resultMessage = "결제 실패";
    }

    return TossPaymentsResponse.builder()
        .approveNo(approveNo)
        .billingKey(paymentCard.getBillingKey())
        .amount(billingDto.getAmount())
        .paymentStatus(billingDto.getPaymentStatus())
        .resultMessage(resultMessage)
        .build();
  }
}
