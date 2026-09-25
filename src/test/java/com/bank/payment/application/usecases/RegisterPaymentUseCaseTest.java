package com.bank.payment.application.usecases;

import com.bank.payment.domain.model.Payment;
import com.bank.payment.domain.ports.PaymentRepository;
import com.bank.payment.domain.ports.CreditBureauClient;
import com.bank.payment.domain.ports.BankCoreClient;
import com.bank.payment.domain.ports.AuditEventPublisher;
import com.bank.payment.application.events.PaymentRegisteredEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RegisterPaymentUseCaseTest {

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private CreditBureauClient creditBureauClient;

    @Mock
    private BankCoreClient bankCoreClient;

    @Mock
    private AuditEventPublisher auditEventPublisher;

    @InjectMocks
    private RegisterPaymentUseCase registerPaymentUseCase;

    @Test
    void registerPayment_success() {
        // Arrange
        Payment payment = Payment.builder()
               .id(UUID.randomUUID())
               .operationNumber("123456")
               .channel("web")
               .amount(new BigDecimal("100.00"))
               .currency("USD")
               .accountNumber("1234567890")
               .beneficiaryAccount("0987654321")
               .createdAt(LocalDateTime.now())
               .status("pending")
               .build();

        when(paymentRepository.save(payment)).thenReturn(Mono.just(payment));
        when(creditBureauClient.verifyCreditScore(payment.getAccountNumber(), payment.getBeneficiaryAccount(), payment.getCurrency())).thenReturn(Mono.just("approved"));
        when(bankCoreClient.processPayment(payment)).thenReturn(Mono.just(payment));

        // Act
        Mono<Payment> result = registerPaymentUseCase.registerPayment(payment);

        // Assert
        result.subscribe(registeredPayment -> {
            assertEquals(payment, registeredPayment);
            verify(paymentRepository).save(payment);
            verify(creditBureauClient).verifyCreditScore(payment.getAccountNumber(), payment.getBeneficiaryAccount(), payment.getCurrency());
            verify(bankCoreClient).processPayment(payment);
            verify(auditEventPublisher).publishEvent(any(PaymentRegisteredEvent.class));
        });
    }

    @Test
    void registerPayment_creditBureauFailure() {
        // Arrange
        Payment payment = Payment.builder()
               .id(UUID.randomUUID())
               .operationNumber("123456")
               .channel("web")
               .amount(new BigDecimal("100.00"))
               .currency("USD")
               .accountNumber("1234567890")
               .beneficiaryAccount("0987654321")
               .createdAt(LocalDateTime.now())
               .status("pending")
               .build();

        when(creditBureauClient.verifyCreditScore(payment.getAccountNumber(), payment.getBeneficiaryAccount(), payment.getCurrency())).thenReturn(Mono.error(new RuntimeException("Credit bureau timeout")));

        // Act
        Mono<Payment> result = registerPaymentUseCase.registerPayment(payment);

        // Assert
        result.subscribe(registeredPayment -> fail("Expected exception"),
                error -> {
                    assertTrue(error instanceof RuntimeException);
                    assertEquals("Credit bureau timeout", error.getMessage());
                    verify(paymentRepository, never()).save(payment);
                    verify(creditBureauClient).verifyCreditScore(payment.getAccountNumber(), payment.getBeneficiaryAccount(), payment.getCurrency());
                    verify(bankCoreClient, never()).processPayment(payment);
                    verify(auditEventPublisher, never()).publishEvent(any(PaymentRegisteredEvent.class));
                });
    }
}