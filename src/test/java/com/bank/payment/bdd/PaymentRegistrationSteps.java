package com.bank.payment.bdd;

import com.bank.payment.domain.model.Payment;
import com.bank.payment.domain.ports.PaymentRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentRegistrationSteps {

    @Autowired
    private PaymentRepository paymentRepository;

    private Payment payment;
    private Mono<Payment> savedPayment;

    @Given("a payment with operation number {string}, channel {string}, amount {double}, currency {string}, account number {string}, beneficiary account {string}")
    public void a_payment_with_operation_number_channel_amount_currency_account_number_beneficiary_account(String operationNumber, String channel, double amount, String currency, String accountNumber, String beneficiaryAccount) {
        payment = Payment.builder()
               .operationNumber(operationNumber)
               .channel(channel)
               .amount(BigDecimal.valueOf(amount))
               .currency(currency)
               .accountNumber(accountNumber)
               .beneficiaryAccount(beneficiaryAccount)
               .build();
    }

    @When("the payment is registered")
    public void the_payment_is_registered() {
        savedPayment = paymentRepository.save(payment);
    }

    @Then("the payment should be saved with status {string}")
    public void the_payment_should_be_saved_with_status(String status) {
        savedPayment.subscribe(p -> {
            assertEquals(status, p.getStatus());
        });
    }
}