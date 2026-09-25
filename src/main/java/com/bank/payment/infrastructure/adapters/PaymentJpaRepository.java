package com.bank.payment.infrastructure.adapters;

import com.bank.payment.domain.model.Payment;
import com.bank.payment.domain.ports.PaymentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public interface PaymentJpaRepository extends JpaRepository<Payment, UUID>, PaymentRepository {
    @Override
    default Mono<Payment> save(Payment payment) {
        return Mono.fromCallable(() -> saveAndFlush(payment));
    }

    @Override
    default Mono<Payment> findById(UUID id) {
        return Mono.fromCallable(() -> findById(id).orElse(null));
    }

    @Override
    default Mono<Boolean> existsByOperationNumberAndChannel(String operationNumber, String channel) {
        return Mono.fromCallable(() -> existsByOperationNumberAndChannel(operationNumber, channel));
    }

    @Override
    default Mono<Payment> findByOperationNumberAndChannel(String operationNumber, String channel) {
        return Mono.fromCallable(() -> findByOperationNumberAndChannel(operationNumber, channel).orElse(null));
    }
}