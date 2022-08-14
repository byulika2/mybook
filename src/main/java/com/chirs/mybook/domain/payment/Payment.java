package com.chirs.mybook.domain.payment;

import com.chirs.mybook.domain.payment.enums.PaymentStatus;
import com.chirs.mybook.domain.payment_card.PaymentCard;
import com.chirs.mybook.domain.subscription.Subscription;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "payment")
@ToString
public class Payment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "payment_id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "subscription_id")
  private Subscription subscription;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "payment_card_id")
  private PaymentCard paymentCard;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "payment_status")
  private PaymentStatus paymentStatus;

  @Column(name = "approve_no", nullable = false)
  private String approveNo;

  @ColumnDefault("0")
  @Column(name = "amount", nullable = false)
  private long amount;

  @Column(name = "result_message", columnDefinition = "TEXT")
  private String resultMessage;

  @Builder
  public Payment(Subscription subscription, PaymentCard paymentCard, PaymentStatus paymentStatus, String approveNo,
      long amount, String resultMessage) {
    this.subscription = subscription;
    this.paymentCard = paymentCard;
    this.paymentStatus = paymentStatus;
    this.approveNo = approveNo;
    this.amount = amount;
    this.resultMessage = resultMessage;
  }

  public void success() {
    this.approveNo = String.valueOf(Math.random());
    this.resultMessage = "결제성공";
    this.paymentStatus = PaymentStatus.성공;
  }

  public void fail(String resultMessage) {
    this.resultMessage = resultMessage;
    this.paymentStatus = PaymentStatus.실패;
  }

  public void setSubscription(Subscription subscription) {
    this.subscription = subscription;
  }
}
