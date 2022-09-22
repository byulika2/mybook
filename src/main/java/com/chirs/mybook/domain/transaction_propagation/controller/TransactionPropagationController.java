package com.chirs.mybook.domain.transaction_propagation.controller;

import com.chirs.mybook.domain.transaction_propagation.service.AService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaction_propagation")
@RequiredArgsConstructor
public class TransactionPropagationController {

  private final AService aService;

  @PostMapping("/required-a-to-b")
  public void propagationRequiredAtoB() {
    aService.requiredAtoB();
  }

  @PostMapping("/required-b")
  public void requiredB() {
    aService.requiredB();
  }

  @PostMapping("/supports-a-to-b")
  public void supportsAtoB() {
    aService.supportsAtoB();
  }

  @PostMapping("/supports-b")
  public void supportsB() {
    aService.supportsB();
  }

  @PostMapping("/mandatory-a-to-b")
  public void mandatoryAtoB() {
    aService.mandatoryAtoB();
  }

  @PostMapping("/mandatory-b")
  public void mandatoryB() {
    aService.mandatoryB();
  }

  @PostMapping("/requires-new")
  public void requiresNew() {
    aService.requiresNew();
  }

  @PostMapping("/not-supported")
  public void notSupported() {
    aService.notSupported();
  }

  @PostMapping("/never")
  public void never() {
    aService.never();
  }

  @PostMapping("/nested")
  public void nested() {
    aService.nested();
  }
}

