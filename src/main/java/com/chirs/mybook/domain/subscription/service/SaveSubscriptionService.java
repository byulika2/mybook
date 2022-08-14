package com.chirs.mybook.domain.subscription.service;

import com.chirs.mybook.domain.member.Member;
import com.chirs.mybook.domain.member.service.DetailMemberService;
import com.chirs.mybook.domain.payment.Payment;
import com.chirs.mybook.domain.payment.dto.PaymentDto;
import com.chirs.mybook.domain.payment.dto.request.SavePaymentRequest;
import com.chirs.mybook.domain.payment.enums.PaymentStatus;
import com.chirs.mybook.domain.payment.repository.PaymentRepository;
import com.chirs.mybook.domain.payment.service.SavePaymentService;
import com.chirs.mybook.domain.product.Product;
import com.chirs.mybook.domain.product.repository.ProductRepository;
import com.chirs.mybook.domain.subscription.Subscription;
import com.chirs.mybook.domain.subscription.dto.SaveSubscriptionRequest;
import com.chirs.mybook.domain.subscription.repository.SubscriptionRepository;
import com.chirs.mybook.domain.subscription_product.SubscriptionProduct;
import com.chirs.mybook.domain.subscription_product.repository.SubscriptionProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveSubscriptionService {

  private final DetailMemberService detailMemberService;
  private final SavePaymentService savePaymentService;
  private final ProductRepository productRepository;
  private final SubscriptionRepository subscriptionRepository;
  private final SubscriptionProductRepository subscriptionProductRepository;
  private final PaymentRepository paymentRepository;


  public void saveSubscription(SaveSubscriptionRequest request) {

    Product product = productRepository.findById(request.getProductId())
        .orElseThrow(() -> new RuntimeException("상품을 찾을 수 없습니다."));
    Member loginMember = detailMemberService.getLoginMember();

    PaymentDto paymentDto = savePaymentService.savePayment(SavePaymentRequest.builder()
        .amount(product.getPrice(request.getSubscriptionType()))
        .paymentStatus(request.getPaymentStatus())
        .build());

    if (paymentDto.getPaymentStatus() == PaymentStatus.실패) {
      throw new RuntimeException(paymentDto.getResultMessage());
    }

    Subscription subscription = subscriptionRepository.save(Subscription.builder()
        .member(loginMember)
        .subscriptionType(request.getSubscriptionType())
        .build());

    Payment payment = paymentRepository.findById(paymentDto.getPaymentId())
        .orElseThrow(() -> new RuntimeException("결제정보 없음"));
    payment.setSubscription(subscription);
    paymentRepository.save(payment);

    subscriptionProductRepository.save(SubscriptionProduct.builder()
        .subscription(subscription)
        .product(product)
        .amount(product.getPrice(request.getSubscriptionType()))
        .build());

  }
}
