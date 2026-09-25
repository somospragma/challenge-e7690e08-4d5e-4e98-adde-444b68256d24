package com.bank.payment.domain.ports;

import com.bank.payment.domain.model.Payment;
import reactor.core.publisher.Mono;
import java.util.UUID;

/**
 * Puerto definido por el dominio para persistencia de pagos.
 * La implementación debe garantizar unicidad por operationNumber y channel.
 */
public interface PaymentRepository {
    Mono<Payment> save(Payment payment);
    
    Mono<Payment> findById(UUID id);
    
    Mono<Boolean> existsByOperationNumberAndChannel(String operationNumber, String channel);
    
    Mono<Payment> findByOperationNumberAndChannel(String operationNumber, String channel);
}