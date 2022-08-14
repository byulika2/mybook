package com.chirs.mybook.domain.payment_card.repository;

import com.chirs.mybook.domain.payment_card.PaymentCard;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentCardRepository extends JpaRepository<PaymentCard, Long> {

  Optional<PaymentCard> findByMember_Id(Long memberId);
}
