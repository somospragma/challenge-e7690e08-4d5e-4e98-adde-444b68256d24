Feature: Payment Registration
  As a user, I want to register a payment so that it can be processed by the system.

  Scenario: Register a unique payment
    Given a payment with operation number "OP123", channel "web", amount 100.0, currency "USD", account number "123456789", beneficiary account "987654321"
    When the payment is registered
    Then the payment should be saved with status "registered"

  Scenario: Register a duplicate payment
    Given a payment with operation number "OP123", channel "web", amount 100.0, currency "USD", account number "123456789", beneficiary account "987654321"
    When the payment is registered
    Then the payment should be saved with status "duplicate"

  Scenario: Register a payment with invalid amount
    Given a payment with operation number "OP456", channel "mobile", amount -100.0, currency "USD", account number "123456789", beneficiary account "987654321"
    When the payment is registered
    Then the payment should be saved with status "invalid"

  Scenario: Register a payment with invalid currency
    Given a payment with operation number "OP789", channel "api", amount 100.0, currency "INVALID", account number "123456789", beneficiary account "987654321"
    When the payment is registered
    Then the payment should be saved with status "invalid"