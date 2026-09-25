package com.bank.payment.infrastructure.controllers;

import com.bank.payment.application.usecases.RegisterPaymentUseCase;
import com.bank.payment.domain.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private RegisterPaymentUseCase registerPaymentUseCase;

    @PostMapping
    public Mono<ResponseEntity<Payment>> registerPayment(@Valid @RequestBody Payment payment) {
        return registerPaymentUseCase.execute(payment)
               .map(p -> new ResponseEntity<>(p, HttpStatus.CREATED))
               .defaultIfEmpty(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}