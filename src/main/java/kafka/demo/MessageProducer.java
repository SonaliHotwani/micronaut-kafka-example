package kafka.demo;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaClient
public interface MessageProducer {

    @Topic("greetings")
    void send(String message);
}

