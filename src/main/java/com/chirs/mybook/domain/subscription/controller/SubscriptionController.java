package com.chirs.mybook.domain.subscription.controller;

import com.chirs.mybook.domain.subscription.dto.SaveSubscriptionRequest;
import com.chirs.mybook.domain.subscription.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/subscription")
public class SubscriptionController {

  private final SubscriptionService subscriptionService;


  @PostMapping("")
  public void saveSubscription(@RequestBody SaveSubscriptionRequest request){
    subscriptionService.saveSubscription(request);
  }
}
