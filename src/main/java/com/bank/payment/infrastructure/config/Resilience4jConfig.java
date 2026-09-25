package com.bank.payment.infrastructure.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.reactor.circuitbreaker.operator.CircuitBreakerOperator;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.reactor.retry.operator.RetryOperator;
import io.github.resilience4j.bulkhead.BulkheadConfig;
import io.github.resilience4j.reactor.bulkhead.operator.BulkheadOperator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Resilience4jConfig {

    @Bean
    public CircuitBreakerConfig circuitBreakerConfig() {
        return CircuitBreakerConfig.custom()
               .failureRateThreshold(50)
               .waitDurationInOpenState(10000)
               .build();
    }

    @Bean
    public CircuitBreakerOperator circuitBreakerOperator(CircuitBreakerConfig config) {
        return CircuitBreakerOperator.of(config);
    }

    @Bean
    public RetryConfig retryConfig() {
        return RetryConfig.custom()
               .maxAttempts(3)
               .waitDuration(java.time.Duration.ofSeconds(1))
               .build();
    }

    @Bean
    public RetryOperator retryOperator(RetryConfig config) {
        return RetryOperator.of(config);
    }

    @Bean
    public BulkheadConfig bulkheadConfig() {
        return BulkheadConfig.custom()
               .maxConcurrentCalls(10)
               .maxWaitDuration(java.time.Duration.ofSeconds(1))
               .build();
    }

    @Bean
    public BulkheadOperator bulkheadOperator(BulkheadConfig config) {
        return BulkheadOperator.of(config);
    }
}