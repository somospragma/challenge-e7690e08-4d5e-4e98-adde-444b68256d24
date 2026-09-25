package com.bank.payment.domain.ports;

import com.bank.payment.domain.model.Payment;
import reactor.core.publisher.Mono;

public interface BankCoreClient {
    Mono<String> processPayment(Payment payment);
}