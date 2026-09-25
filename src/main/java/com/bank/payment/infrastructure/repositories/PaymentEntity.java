package com.bank.payment.infrastructure.repositories;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "payments", uniqueConstraints = @UniqueConstraint(columnNames = {"operation_number", "channel"})
)
public class PaymentEntity {

    @Id
    private UUID id;

    @Column(name = "operation_number", nullable = false)
    private String operationNumber;

    @Column(name = "channel", nullable = false)
    private String channel;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @Column(name = "beneficiary_account", nullable = false)
    private String beneficiaryAccount;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "credit_bureau_response")
    private String creditBureauResponse;

    @Column(name = "bank_core_response")
    private String bankCoreResponse;

    public PaymentEntity() {
    }

    public PaymentEntity(UUID id, String operationNumber, String channel, BigDecimal amount, String currency, String accountNumber, String beneficiaryAccount, LocalDateTime createdAt, String status, String creditBureauResponse, String bankCoreResponse) {
        this.id = id;
        this.operationNumber = operationNumber;
        this.channel = channel;
        this.amount = amount;
        this.currency = currency;
        this.accountNumber = accountNumber;
        this.beneficiaryAccount = beneficiaryAccount;
        this.createdAt = createdAt;
        this.status = status;
        this.creditBureauResponse = creditBureauResponse;
        this.bankCoreResponse = bankCoreResponse;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getOperationNumber() {
        return operationNumber;
    }

    public void setOperationNumber(String operationNumber) {
        this.operationNumber = operationNumber;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBeneficiaryAccount() {
        return beneficiaryAccount;
    }

    public void setBeneficiaryAccount(String beneficiaryAccount) {
        this.beneficiaryAccount = beneficiaryAccount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreditBureauResponse() {
        return creditBureauResponse;
    }

    public void setCreditBureauResponse(String creditBureauResponse) {
        this.creditBureauResponse = creditBureauResponse;
    }

    public String getBankCoreResponse() {
        return bankCoreResponse;
    }

    public void setBankCoreResponse(String bankCoreResponse) {
        this.bankCoreResponse = bankCoreResponse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentEntity)) return false;
        PaymentEntity that = (PaymentEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "PaymentEntity{" +
                "id=" + id +
                ", operationNumber='" + operationNumber + '\'' +
                ", channel='" + channel + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", beneficiaryAccount='" + beneficiaryAccount + '\'' +
                ", createdAt=" + createdAt +
                ", status='" + status + '\'' +
                ", creditBureauResponse='" + creditBureauResponse + '\'' +
                ", bankCoreResponse='" + bankCoreResponse + '\'' +
                '}';
    }
}