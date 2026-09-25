Feature: Payment Consolidation
  As a user, I want to consolidate payments from different channels so that they can be processed together.

  Scenario: Consolidate payments from web and mobile channels
    Given a payment with operation number "OP123", channel "web", amount 100.0, currency "USD", account number "123456789", beneficiary account "987654321"
    And a payment with operation number "OP456", channel "mobile", amount 200.0, currency "USD", account number "123456789", beneficiary account "987654321"
    When the payments are consolidated
    Then the total amount should be 300.0

  Scenario: Consolidate payments with backpressure from one channel
    Given a payment with operation number "OP123", channel "web", amount 100.0, currency "USD", account number "123456789", beneficiary account "987654321"
    And a payment with operation number "OP456", channel "mobile", amount 200.0, currency "USD", account number "123456789", beneficiary account "987654321"
    And a payment with operation number "OP789", channel "api", amount 300.0, currency "USD", account number "123456789", beneficiary account "987654321"
    When the payments are consolidated with backpressure from the api channel
    Then the total amount should be 300.0