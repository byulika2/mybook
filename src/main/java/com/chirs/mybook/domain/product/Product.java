package com.chirs.mybook.domain.product;

import com.chirs.mybook.domain.subscription.enums.SubscriptionType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.util.ObjectUtils;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "product")
@ToString
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "product_id")
  private Long id;

  private String name;

  @ColumnDefault("0")
  @Column(name = "month_price", nullable = false)
  private long monthPrice;

  @ColumnDefault("0")
  @Column(name = "year_price", nullable = false)
  private long yearPrice;

  @Transient
  public long getPrice(SubscriptionType subscriptionType) {
    return ObjectUtils.nullSafeEquals(SubscriptionType.월간, subscriptionType) ? monthPrice : yearPrice;
  }
}
