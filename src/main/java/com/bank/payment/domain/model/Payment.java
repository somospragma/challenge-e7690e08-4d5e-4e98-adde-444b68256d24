package com.bank.payment.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Entidad de dominio que representa un pago con unicidad garantizada por operación y canal.
 * Incluye validaciones de negocio para asegurar consistencia.
 */
public final class Payment {
    private final UUID id;
    private final String operationNumber;
    private final String channel;
    private final BigDecimal amount;
    private final String currency;
    private final String accountNumber;
    private final String beneficiaryAccount;
    private final LocalDateTime createdAt;
    private final String status;
    private final String creditBureauResponse;
    private final String bankCoreResponse;

    private Payment(Builder builder) {
        this.id = Objects.requireNonNull(builder.id, "El ID no puede ser nulo");
        this.operationNumber = Objects.requireNonNull(builder.operationNumber, "El número de operación no puede ser nulo");
        this.channel = Objects.requireNonNull(builder.channel, "El canal no puede ser nulo");
        this.amount = Objects.requireNonNull(builder.amount, "El monto no puede ser nulo");
        this.currency = Objects.requireNonNull(builder.currency, "La moneda no puede ser nula");
        this.accountNumber = Objects.requireNonNull(builder.accountNumber, "El número de cuenta no puede ser nulo");
        this.beneficiaryAccount = Objects.requireNonNull(builder.beneficiaryAccount, "La cuenta del beneficiario no puede ser nula");
        this.createdAt = Objects.requireNonNull(builder.createdAt, "La fecha de creación no puede ser nula");
        this.status = Objects.requireNonNull(builder.status, "El estado no puede ser nulo");
        
        if (builder.amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo");
        }
        
        if (!"COP|USD|EUR".contains(builder.currency)) {
            throw new IllegalArgumentException("Moneda no soportada");
        }
        
        if (!"WEB|MOBILE|API".contains(builder.channel)) {
            throw new IllegalArgumentException("Canal no soportado");
        }
        
        this.creditBureauResponse = builder.creditBureauResponse;
        this.bankCoreResponse = builder.bankCoreResponse;
    }

    public UUID getId() {
        return id;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getStatus() {
        return status;
    }

    public String getCreditBureauResponse() {
        return creditBureauResponse;
    }

    public String getBankCoreResponse() {
        return bankCoreResponse;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return operationNumber.equals(payment.operationNumber) && channel.equals(payment.channel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationNumber, channel);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", operationNumber='" + operationNumber + '\'' +
                ", channel='" + channel + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public static final class Builder {
        private UUID id;
        private String operationNumber;
        private String channel;
        private BigDecimal amount;
        private String currency;
        private String accountNumber;
        private String beneficiaryAccount;
        private LocalDateTime createdAt;
        private String status;
        private String creditBureauResponse;
        private String bankCoreResponse;

        private Builder() {
        }

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder operationNumber(String operationNumber) {
            this.operationNumber = operationNumber;
            return this;
        }

        public Builder channel(String channel) {
            this.channel = channel;
            return this;
        }

        public Builder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }

        public Builder accountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder beneficiaryAccount(String beneficiaryAccount) {
            this.beneficiaryAccount = beneficiaryAccount;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder creditBureauResponse(String creditBureauResponse) {
            this.creditBureauResponse = creditBureauResponse;
            return this;
        }

        public Builder bankCoreResponse(String bankCoreResponse) {
            this.bankCoreResponse = bankCoreResponse;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }
}