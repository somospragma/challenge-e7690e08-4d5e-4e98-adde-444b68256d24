package com.bank.payment.application.events;

import com.bank.payment.domain.model.Payment;
import reactor.core.publisher.Mono;

public class PaymentRegisteredEvent {
    private final Payment payment;

    public PaymentRegisteredEvent(Payment payment) {
        this.payment = payment;
    }

    public Mono<Payment> getPayment() {
        return Mono.just(payment);
    }
}