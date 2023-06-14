package com.codenotfound.kafka.integration;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.converter.KafkaMessageHeaders;
import org.springframework.kafka.support.converter.MessagingMessageConverter;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.lang.reflect.Type;
import java.util.Map;

public class CloudEventMessageConverter extends MessagingMessageConverter {
    private String messageKey = null;

    public CloudEventMessageConverter(String messageKey) {
        this.messageKey = messageKey;
    }

    @Override
    public Message<?> toMessage(ConsumerRecord<?, ?> record, Acknowledgment acknowledgment, Type type) {
        Message<?> message = super.toMessage(record, acknowledgment, type);
        message.getHeaders().put("KEY", messageKey);
        return message;
    }
}
