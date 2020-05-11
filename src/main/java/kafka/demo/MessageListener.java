package kafka.demo;

import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

@Singleton
@KafkaListener(groupId = "greetings-listener", clientId = "test-greetings-listener")
public class MessageListener {

    private Logger logger = LoggerFactory.getLogger(MessageListener.class);

    public BlockingQueue<String> messages = new LinkedBlockingDeque<>();


    @Topic("greetings")
    public void receive(String message) {
        logger.info("Greetings - " + message);
        System.out.println("Greetings - " + message);
        messages.add(message);
    }
}
