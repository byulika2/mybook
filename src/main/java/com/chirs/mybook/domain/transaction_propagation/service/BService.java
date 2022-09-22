package com.chirs.mybook.domain.transaction_propagation.service;

import com.chirs.mybook.domain.transaction_propagation.TransactionPropagation;
import com.chirs.mybook.domain.transaction_propagation.dto.TransactionPropagationDto;
import com.chirs.mybook.domain.transaction_propagation.enums.PropagationType;
import com.chirs.mybook.domain.transaction_propagation.repository.TransactionPropagationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Slf4j
@Service
@RequiredArgsConstructor
public class BService {

  private final TransactionPropagationRepository transactionPropagationRepository;

  public void noneTransactional() {
    log.info("BService Transaction name [{}] active is [{}]",
        TransactionSynchronizationManager.getCurrentTransactionName(),
        TransactionSynchronizationManager.isActualTransactionActive());
  }

  @Transactional(propagation = Propagation.REQUIRED)
  public void required() {
    log.info("BService Transaction name [{}] active is [{}]",
        TransactionSynchronizationManager.getCurrentTransactionName(),
        TransactionSynchronizationManager.isActualTransactionActive());
  }

  @Transactional(propagation = Propagation.SUPPORTS)
  public void supports() {
    log.info("BService Transaction name [{}] active is [{}]",
        TransactionSynchronizationManager.getCurrentTransactionName(),
        TransactionSynchronizationManager.isActualTransactionActive());
  }

  @Transactional(propagation = Propagation.MANDATORY)
  public void mandatory() {
    log.info("BService Transaction name [{}] active is [{}]",
        TransactionSynchronizationManager.getCurrentTransactionName(),
        TransactionSynchronizationManager.isActualTransactionActive());
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void requiresNew() {
    log.info("BService Transaction name [{}] active is [{}]",
        TransactionSynchronizationManager.getCurrentTransactionName(),
        TransactionSynchronizationManager.isActualTransactionActive());
  }

  @Transactional(propagation = Propagation.NOT_SUPPORTED)
  public void notSupported() {
    log.info("BService Transaction name [{}] active is [{}]",
        TransactionSynchronizationManager.getCurrentTransactionName(),
        TransactionSynchronizationManager.isActualTransactionActive());
  }

  @Transactional(propagation = Propagation.NEVER)
  public void never() {
    log.info("BService Transaction name [{}] active is [{}]",
        TransactionSynchronizationManager.getCurrentTransactionName(),
        TransactionSynchronizationManager.isActualTransactionActive());
  }

  @Transactional(propagation = Propagation.NESTED)
  public void nested() {
    log.info("BService Transaction name [{}] active is [{}]",
        TransactionSynchronizationManager.getCurrentTransactionName(),
        TransactionSynchronizationManager.isActualTransactionActive());
    transactionPropagationRepository.save(TransactionPropagation.builder()
        .abType("B")
        .propagationType(PropagationType.NESTED)
        .build());
  }

}
