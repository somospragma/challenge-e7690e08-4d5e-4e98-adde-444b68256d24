package com.bank.payment.application.usecases;

import com.bank.payment.domain.model.Payment;
import com.bank.payment.domain.ports.PaymentRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import org.springframework.beans.factory.annotation.Autowired;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class ConsolidatePaymentsUseCase {

    @Autowired
    private PaymentRepository paymentRepository;

    @CircuitBreaker(name = "consolidatePayments", fallbackMethod = "fallbackConsolidatePayments")
    @Retry(name = "consolidatePayments")
    public Flux<Payment> consolidatePayments(Flux<Payment> payments) {
        return payments.concatMap(payment -> paymentRepository.save(payment));
    }

    public Flux<Payment> fallbackConsolidatePayments(Flux<Payment> payments, Throwable throwable) {
        return Flux.error(throwable);
    }
}