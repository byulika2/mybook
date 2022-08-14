package com.chirs.mybook.domain.payment.service;

import com.chirs.mybook.common.pg.TossPayments;
import com.chirs.mybook.common.pg.dto.BillingDto;
import com.chirs.mybook.common.pg.dto.TossPaymentsResponse;
import com.chirs.mybook.domain.member.Member;
import com.chirs.mybook.domain.member.service.DetailMemberService;
import com.chirs.mybook.domain.payment.Payment;
import com.chirs.mybook.domain.payment.dto.PaymentDto;
import com.chirs.mybook.domain.payment.dto.request.SavePaymentRequest;
import com.chirs.mybook.domain.payment.enums.PaymentStatus;
import com.chirs.mybook.domain.payment.repository.PaymentRepository;
import com.chirs.mybook.domain.payment_card.PaymentCard;
import com.chirs.mybook.domain.payment_card.repository.PaymentCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class SavePaymentService {

  private final DetailMemberService detailMemberService;
  private final TossPayments tossPayments;
  private final PaymentCardRepository paymentCardRepository;
  private final PaymentRepository paymentRepository;

  public PaymentDto savePayment(SavePaymentRequest request) {
    Member member = detailMemberService.getLoginMember();
    PaymentCard paymentCard = paymentCardRepository.findByMember_Id(member.getId())
        .orElseThrow(() -> new RuntimeException("결제수단 없음"));

    TossPaymentsResponse response = tossPayments.billing(BillingDto.builder()
        .paymentCardId(paymentCard.getId())
        .amount(request.getAmount())
        .paymentStatus(request.getPaymentStatus())
        .build());

    Payment payment = paymentRepository.save(Payment.builder()
        .paymentCard(paymentCard)
        .paymentStatus(response.getPaymentStatus())
        .approveNo(response.getApproveNo())
        .amount(response.getAmount())
        .resultMessage(response.getResultMessage())
        .build());

    if (response.getPaymentStatus() == PaymentStatus.성공) {
      payment.success();
    } else {
      payment.fail(response.getResultMessage());
    }

    return new PaymentDto(payment);
  }
}
