package com.example.carservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class HouseDeleteConfig {
    @Bean
    public NewTopic deletePersonIdTopic(){
        return new NewTopic("house_delete_event", 1, (short) 1);
    }

    @Bean
    public Map<String,Object> deletePersonIdConfig(){
        Map<String,Object> props=new HashMap<>();
        props.put(org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "localhost:29092");
        props.put(org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        props.put(org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                JsonSerializer.class);
        return props;
    }
    @Bean
    public ProducerFactory<String,Object> deletePersonIdFactory(){
        return new DefaultKafkaProducerFactory<>(deletePersonIdConfig());
    }

    @Bean
    public KafkaTemplate<String,Object> deletePersonIdKafkaTemplate(){
        return new KafkaTemplate<>(deletePersonIdFactory());
    }
}

