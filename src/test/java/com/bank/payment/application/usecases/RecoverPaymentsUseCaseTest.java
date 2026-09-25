package com.bank.payment.application.usecases;

import com.bank.payment.domain.model.Payment;
import com.bank.payment.domain.ports.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class RecoverPaymentsUseCaseTest {

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private RecoverPaymentsUseCase recoverPaymentsUseCase;

    @Test
    void shouldRecoverPaymentSuccessfully() {
        UUID paymentId = UUID.randomUUID();
        Payment payment = Payment.builder()
               .id(paymentId)
               .operationNumber("OP-123")
               .channel("WEB")
               .amount(new BigDecimal("100.00"))
               .currency("USD")
               .accountNumber("123456789")
               .beneficiaryAccount("987654321")
               .createdAt(LocalDateTime.now())
               .status("PENDING")
               .creditBureauResponse("APPROVED")
               .bankCoreResponse("PROCESSING")
               .build();

        Mono<Payment> expectedPaymentMono = Mono.just(payment);

        when(paymentRepository.findById(paymentId)).thenReturn(expectedPaymentMono);

        StepVerifier.create(recoverPaymentsUseCase.recoverPayment(paymentId))
               .expectNext(payment)
               .verifyComplete();
    }

    @Test
    void shouldHandlePaymentNotFound() {
        UUID paymentId = UUID.randomUUID();
        Mono<Payment> emptyMono = Mono.empty();

        when(paymentRepository.findById(paymentId)).thenReturn(emptyMono);

        StepVerifier.create(recoverPaymentsUseCase.recoverPayment(paymentId))
               .expectError(NoSuchElementException.class)
               .verify();
    }

    @Test
    void shouldHandleRepositoryError() {
        UUID paymentId = UUID.randomUUID();
        Mono<Payment> errorMono = Mono.error(new RuntimeException("Database error"));

        when(paymentRepository.findById(paymentId)).thenReturn(errorMono);

        StepVerifier.create(recoverPaymentsUseCase.recoverPayment(paymentId))
               .expectError(RuntimeException.class)
               .verify();
    }
}