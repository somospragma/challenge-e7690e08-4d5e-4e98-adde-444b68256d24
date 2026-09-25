package com.bank.payment.domain.ports;

import reactor.core.publisher.Mono;

/**
 * Puerto definido por el dominio para comunicación con el buró de crédito.
 * La implementación debe manejar timeouts y fallos del servicio.
 */
public interface CreditBureauClient {
    Mono<String> verifyCreditScore(String accountNumber, String beneficiaryAccount, String currency);
}