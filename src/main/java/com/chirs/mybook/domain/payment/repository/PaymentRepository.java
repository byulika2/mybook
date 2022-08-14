package com.chirs.mybook.domain.payment.repository;

import com.chirs.mybook.domain.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
