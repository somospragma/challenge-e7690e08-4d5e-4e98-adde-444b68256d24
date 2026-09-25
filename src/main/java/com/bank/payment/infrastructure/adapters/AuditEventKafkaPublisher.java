package com.bank.payment.infrastructure.adapters;

import com.bank.payment.domain.ports.AuditEventPublisher;
import com.bank.payment.domain.model.Payment;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuditEventKafkaPublisher implements AuditEventPublisher {

    private final KafkaProducer<String, String> kafkaProducer;

    @Value("${kafka.topic.audit}")
    private String auditTopic;

    public AuditEventKafkaPublisher(KafkaProducer<String, String> kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @Override
    public void publish(Payment payment) {
        String key = payment.getOperationNumber();
        String value = payment.toString();
        ProducerRecord<String, String> record = new ProducerRecord<>(auditTopic, key, value);
        kafkaProducer.send(record);
    }
}