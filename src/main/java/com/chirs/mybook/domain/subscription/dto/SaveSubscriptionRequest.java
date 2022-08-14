package com.chirs.mybook.domain.subscription.dto;

import com.chirs.mybook.domain.payment.enums.PaymentStatus;
import com.chirs.mybook.domain.subscription.enums.SubscriptionType;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SaveSubscriptionRequest {

  @ApiModelProperty(value = "상품 ID", required = true)
  private Long productId;

  @ApiModelProperty(value = "구독방식", required = true)
  private SubscriptionType subscriptionType = SubscriptionType.월간;

  @ApiModelProperty(value = "테스트용 결제결과", required = true)
  private PaymentStatus paymentStatus = PaymentStatus.성공;
}
