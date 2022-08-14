package com.chirs.mybook.domain.subscription_product;

import com.chirs.mybook.domain.product.Product;
import com.chirs.mybook.domain.subscription.Subscription;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import org.hibernate.annotations.CreationTimestamp;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "subscription_product")
@ToString
public class SubscriptionProduct {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "subscription_product_id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "subscription_id")
  private Subscription subscription;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id")
  private Product product;

  @ColumnDefault("0")
  @Column(name = "amount", nullable = false)
  private long amount;

  @CreationTimestamp
  @Column(name = "create_at", nullable = false)
  private LocalDateTime createAt;

  @Builder
  public SubscriptionProduct(Subscription subscription, Product product, long amount) {
    this.subscription = subscription;
    this.product = product;
    this.amount = amount;
  }
}
