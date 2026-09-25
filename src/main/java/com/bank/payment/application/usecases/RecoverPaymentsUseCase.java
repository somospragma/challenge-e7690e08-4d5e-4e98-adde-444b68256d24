package com.bank.payment.application.usecases;

import com.bank.payment.domain.model.Payment;
import com.bank.payment.domain.ports.PaymentRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import org.springframework.beans.factory.annotation.Autowired;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class RecoverPaymentsUseCase {

    @Autowired
    private PaymentRepository paymentRepository;

    @CircuitBreaker(name = "recoverPayments", fallbackMethod = "fallbackRecoverPayments")
    @Retry(name = "recoverPayments")
    public Flux<Payment> recoverPayments(Flux<Payment> payments) {
        return payments.concatMap(payment -> paymentRepository.findById(payment.getId())
               .flatMap(existingPayment -> {
                    if (existingPayment!= null &&!existingPayment.getStatus().equals("SUCCESS")) {
                        return paymentRepository.save(payment);
                    }
                    return Mono.just(existingPayment);
                }).defaultIfEmpty(payment));
    }

    public Flux<Payment> fallbackRecoverPayments(Flux<Payment> payments, Throwable throwable) {
        return Flux.error(throwable);
    }
}