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
class ConsolidatePaymentsUseCaseTest {

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private CreditBureauClient creditBureauClient;

    @Mock
    private BankCoreClient bankCoreClient;

    @Mock
    private AuditEventPublisher auditEventPublisher;

    @InjectMocks
    private ConsolidatePaymentsUseCase consolidatePaymentsUseCase;

    @Test
    void consolidatePayments_success() {
        // Arrange
        Payment payment1 = Payment.builder()
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

        Payment payment2 = Payment.builder()
               .id(UUID.randomUUID())
               .operationNumber("654321")
               .channel("mobile")
               .amount(new BigDecimal("200.00"))
               .currency("USD")
               .accountNumber("1234567890")
               .beneficiaryAccount("0987654321")
               .createdAt(LocalDateTime.now())
               .status("pending")
               .build();

        when(paymentRepository.save(payment1)).thenReturn(Mono.just(payment1));
        when(paymentRepository.save(payment2)).thenReturn(Mono.just(payment2));
        when(creditBureauClient.verifyCreditScore(payment1.getAccountNumber(), payment1.getBeneficiaryAccount(), payment1.getCurrency())).thenReturn(Mono.just("approved"));
        when(creditBureauClient.verifyCreditScore(payment2.getAccountNumber(), payment2.getBeneficiaryAccount(), payment2.getCurrency())).thenReturn(Mono.just("approved"));
        when(bankCoreClient.processPayment(payment1)).thenReturn(Mono.just(payment1));
        when(bankCoreClient.processPayment(payment2)).thenReturn(Mono.just(payment2));

        // Act
        Mono<Void> result = consolidatePaymentsUseCase.consolidatePayments(Mono.just(payment1).concatWith(Mono.just(payment2)));

        // Assert
        result.subscribe();
        verify(paymentRepository).save(payment1);
        verify(paymentRepository).save(payment2);
        verify(creditBureauClient).verifyCreditScore(payment1.getAccountNumber(), payment1.getBeneficiaryAccount(), payment1.getCurrency());
        verify(creditBureauClient).verifyCreditScore(payment2.getAccountNumber(), payment2.getBeneficiaryAccount(), payment2.getCurrency());
        verify(bankCoreClient).processPayment(payment1);
        verify(bankCoreClient).processPayment(payment2);
        verify(auditEventPublisher, times(2)).publishEvent(any(PaymentRegisteredEvent.class));
    }

    @Test
    void consolidatePayments_creditBureauFailure() {
        // Arrange
        Payment payment1 = Payment.builder()
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

        when(creditBureauClient.verifyCreditScore(payment1.getAccountNumber(), payment1.getBeneficiaryAccount(), payment1.getCurrency())).thenReturn(Mono.error(new RuntimeException("Credit bureau timeout")));

        // Act
        Mono<Void> result = consolidatePaymentsUseCase.consolidatePayments(Mono.just(payment1));

        // Assert
        result.subscribe(success -> fail("Expected exception"),
                error -> {
                    assertTrue(error instanceof RuntimeException);
                    assertEquals("Credit bureau timeout", error.getMessage());
                    verify(paymentRepository, never()).save(payment1);
                    verify(creditBureauClient).verifyCreditScore(payment1.getAccountNumber(), payment1.getBeneficiaryAccount(), payment1.getCurrency());
                    verify(bankCoreClient, never()).processPayment(payment1);
                    verify(auditEventPublisher, never()).publishEvent(any(PaymentRegisteredEvent.class));
                });
    }
}