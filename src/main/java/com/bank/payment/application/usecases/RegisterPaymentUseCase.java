package com.bank.payment.application.usecases;

import com.bank.payment.domain.model.Payment;
import com.bank.payment.domain.ports.PaymentRepository;
import com.bank.payment.domain.ports.CreditBureauClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import org.springframework.beans.factory.annotation.Autowired;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class RegisterPaymentUseCase {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private CreditBureauClient creditBureauClient;

    @CircuitBreaker(name = "registerPayment", fallbackMethod = "fallbackRegisterPayment")
    @Retry(name = "registerPayment")
    public Mono<Payment> registerPayment(Payment payment) {
        return paymentRepository.existsByOperationNumberAndChannel(payment.getOperationNumber(), payment.getChannel())
               .flatMap(exists -> {
                    if (exists) {
                        return Mono.error(new IllegalArgumentException("Payment already exists"));
                    }
                    return creditBureauClient.verifyCreditScore(payment.getAccountNumber(), payment.getBeneficiaryAccount(), payment.getCurrency())
                           .flatMap(creditScore -> {
                                payment.setCreditBureauResponse(creditScore);
                                return paymentRepository.save(payment);
                            });
                });
    }

    public Mono<Payment> fallbackRegisterPayment(Payment payment, Throwable throwable) {
        return Mono.error(throwable);
    }
}