package com.chirs.mybook.domain.transaction_propagation.service;

import com.chirs.mybook.domain.transaction_propagation.TransactionPropagation;
import com.chirs.mybook.domain.transaction_propagation.enums.PropagationType;
import com.chirs.mybook.domain.transaction_propagation.repository.TransactionPropagationRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Slf4j
@Service
@RequiredArgsConstructor
public class AService {

  private final BService bService;

  private final TransactionPropagationRepository transactionPropagationRepository;

  @Transactional
  public void requiredAtoB() {
    log.info("AService Transaction name [{}] active is [{}]",
        TransactionSynchronizationManager.getCurrentTransactionName(),
        TransactionSynchronizationManager.isActualTransactionActive());
    bService.noneTransactional();
  }

  public void requiredB() {
    log.info("AService Transaction name [{}] active is [{}]",
        TransactionSynchronizationManager.getCurrentTransactionName(),
        TransactionSynchronizationManager.isActualTransactionActive());
    bService.required();
  }

  @Transactional
  public void supportsAtoB() {
    log.info("AService Transaction name [{}] active is [{}]",
        TransactionSynchronizationManager.getCurrentTransactionName(),
        TransactionSynchronizationManager.isActualTransactionActive());
    bService.supports();
  }

  public void supportsB() {
    log.info("AService Transaction name [{}] active is [{}]",
        TransactionSynchronizationManager.getCurrentTransactionName(),
        TransactionSynchronizationManager.isActualTransactionActive());
    bService.supports();
  }

  @Transactional
  public void mandatoryAtoB() {
    log.info("AService Transaction name [{}] active is [{}]",
        TransactionSynchronizationManager.getCurrentTransactionName(),
        TransactionSynchronizationManager.isActualTransactionActive());
    bService.mandatory();
  }


  public void mandatoryB() {
    log.info("AService Transaction name [{}] active is [{}]",
        TransactionSynchronizationManager.getCurrentTransactionName(),
        TransactionSynchronizationManager.isActualTransactionActive());
    bService.mandatory();
  }


  @Transactional
  public void requiresNew() {
    log.info("AService Transaction name [{}] active is [{}]",
        TransactionSynchronizationManager.getCurrentTransactionName(),
        TransactionSynchronizationManager.isActualTransactionActive());
    bService.requiresNew();
  }

  @Transactional
  public void notSupported() {
    log.info("AService Transaction name [{}] active is [{}]",
        TransactionSynchronizationManager.getCurrentTransactionName(),
        TransactionSynchronizationManager.isActualTransactionActive());
    bService.notSupported();
  }

  @Transactional
  public void never() {
    log.info("AService Transaction name [{}] active is [{}]",
        TransactionSynchronizationManager.getCurrentTransactionName(),
        TransactionSynchronizationManager.isActualTransactionActive());
    bService.never();
  }

  @Transactional
  public void nested() {
    log.info("AService Transaction name [{}] active is [{}]",
        TransactionSynchronizationManager.getCurrentTransactionName(),
        TransactionSynchronizationManager.isActualTransactionActive());
    transactionPropagationRepository.save(TransactionPropagation.builder()
        .abType("A")
        .propagationType(PropagationType.REQUIRED)
        .build());
    bService.nested();

    List<TransactionPropagation> transactionPropagationList = transactionPropagationRepository.findAll();
    Optional<TransactionPropagation> propagationNestedOpt = transactionPropagationList.stream()
        .filter(transactionPropagation -> transactionPropagation.getPropagationType().equals(PropagationType.NESTED))
        .findFirst();
    log.info("Propagation Nested is {}", propagationNestedOpt.isPresent());
  }

}
