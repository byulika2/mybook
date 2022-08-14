package com.chirs.mybook.domain.subscription.repository;

import com.chirs.mybook.domain.subscription.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

}
