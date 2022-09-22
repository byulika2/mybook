package com.chirs.mybook.domain.transaction_propagation.repository;

import com.chirs.mybook.domain.transaction_propagation.TransactionPropagation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionPropagationRepository extends JpaRepository<TransactionPropagation, Long> {

}
