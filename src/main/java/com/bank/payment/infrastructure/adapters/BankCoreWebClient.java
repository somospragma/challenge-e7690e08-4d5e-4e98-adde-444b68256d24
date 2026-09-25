package com.bank.payment.infrastructure.adapters;


import com.bank.payment.domain.model.Builder;
import com.bank.payment.domain.ports.BankCoreClient;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class BankCoreWebClient implements BankCoreClient {
    private final WebClient webClient;

    public BankCoreWebClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://bank-core.com").build();
    }

    @Override
    public Mono<String> processPayment(String operationNumber, String channel, BigDecimal amount, String currency, String accountNumber, String beneficiaryAccount) {
        return webClient.post()
               .uri("/process")
               .bodyValue(new PaymentRequest(operationNumber, channel, amount, currency, accountNumber, beneficiaryAccount))
               .retrieve()
               .bodyToMono(String.class);
    }

    private static class PaymentRequest {
        private final String operationNumber;
        private final String channel;
        private final BigDecimal amount;
        private final String currency;
        private final String accountNumber;
        private final String beneficiaryAccount;

        public PaymentRequest(String operationNumber, String channel, BigDecimal amount, String currency, String accountNumber, String beneficiaryAccount) {
            this.operationNumber = operationNumber;
            this.channel = channel;
            this.amount = amount;
            this.currency = currency;
            this.accountNumber = accountNumber;
            this.beneficiaryAccount = beneficiaryAccount;
        }

        public String getOperationNumber() {
            return operationNumber;
        }

        public String getChannel() {
            return channel;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public String getCurrency() {
            return currency;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public String getBeneficiaryAccount() {
            return beneficiaryAccount;
        }
    }
}