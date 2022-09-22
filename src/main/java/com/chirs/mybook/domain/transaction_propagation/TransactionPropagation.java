package com.chirs.mybook.domain.transaction_propagation;

import com.chirs.mybook.domain.transaction_propagation.enums.PropagationType;
import com.chirs.mybook.domain.transaction_propagation.dto.TransactionPropagationDto;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "transaction_propagation")
@ToString
public class TransactionPropagation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "transaction_propagation_id")
  private Long id;

  @Column(name = "ab_type")
  private String abType;

  @Enumerated(value = EnumType.STRING)
  private PropagationType propagationType;

  @CreationTimestamp
  private LocalDateTime createAt;

  @Builder
  public TransactionPropagation(String abType, PropagationType propagationType) {
    this.abType = abType;
    this.propagationType = propagationType;
  }

  public TransactionPropagation(TransactionPropagationDto transactionPropagationDto) {
    this.id = transactionPropagationDto.getTransactionPropagationId();
    this.propagationType = transactionPropagationDto.getPropagationType();
    this.abType = transactionPropagationDto.getAbType();
  }
}
