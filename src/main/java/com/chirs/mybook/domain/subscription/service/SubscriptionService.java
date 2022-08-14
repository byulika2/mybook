package com.chirs.mybook.domain.subscription.service;

import com.chirs.mybook.domain.subscription.dto.SaveSubscriptionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

  private final SaveSubscriptionService saveSubscriptionService;

  public void saveSubscription(SaveSubscriptionRequest request){
    saveSubscriptionService.saveSubscription(request);
  }
}
