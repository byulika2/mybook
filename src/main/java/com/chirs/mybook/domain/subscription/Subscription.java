package com.chirs.mybook.domain.subscription;

import com.chirs.mybook.domain.member.Member;
import com.chirs.mybook.domain.subscription.enums.SubscriptionType;
import com.chirs.mybook.domain.subscription_product.SubscriptionProduct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "subscription")
@ToString
public class Subscription {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "subscription_id")
  private Long id;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "subscription_type", nullable = false)
  private SubscriptionType subscriptionType;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member_id")
  private Member member;

  @OneToMany(mappedBy = "subscription", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<SubscriptionProduct> subscriptionProductList = new ArrayList<>();

  @CreationTimestamp
  @Column(name = "create_at", nullable = false)
  private LocalDateTime createAt;

  @Builder
  public Subscription(Member member, SubscriptionType subscriptionType) {
    this.member = member;
    this.subscriptionType = subscriptionType;
  }
}
