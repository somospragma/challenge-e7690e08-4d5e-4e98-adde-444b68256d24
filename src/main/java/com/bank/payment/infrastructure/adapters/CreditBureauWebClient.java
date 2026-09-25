package com.bank.payment.infrastructure.adapters;


import com.bank.payment.domain.model.Builder;
import com.bank.payment.domain.ports.CreditBureauClient;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class CreditBureauWebClient implements CreditBureauClient {
    private final WebClient webClient;

    public CreditBureauWebClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://credit-bureau.com").build();
    }

    @Override
    public Mono<String> verifyCreditScore(String accountNumber, String beneficiaryAccount, String currency) {
        return webClient.get()
               .uri(uriBuilder -> uriBuilder
                       .path("/verify")
                       .queryParam("accountNumber", accountNumber)
                       .queryParam("beneficiaryAccount", beneficiaryAccount)
                       .queryParam("currency", currency)
                       .build())
               .retrieve()
               .bodyToMono(String.class);
    }
}