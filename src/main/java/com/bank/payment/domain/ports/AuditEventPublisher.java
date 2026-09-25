package com.bank.payment.domain.ports;

import com.bank.payment.domain.model.Payment;
import reactor.core.publisher.Mono;

public interface AuditEventPublisher {
    Mono<Void> publishEvent(Payment payment);
}