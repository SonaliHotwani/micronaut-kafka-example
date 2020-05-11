package kafka.demo;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@MicronautTest(environments = "kafka")
class MessageProducerTest {

    @Inject
    MessageProducer messageProducer;

    @Inject
    MessageListener messageListener;

    @Test
    void shouldListenToMessagesSentOnProductsTopic() throws InterruptedException {

        messageProducer.send("Hello Sonali");
        final String messages = messageListener.messages.poll(2, TimeUnit.SECONDS);
        assertThat(messages).isEqualTo("Hello Sonali");
    }

}
