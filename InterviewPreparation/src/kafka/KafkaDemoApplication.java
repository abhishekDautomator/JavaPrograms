/*
package kafka;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.logging.Logger;

@SpringBootApplication
public class KafkaDemoApplication {

    private static final Logger LOGGER = Logger.getLogger(KafkaDemoApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(KafkaDemoApplication.class, args);
    }

    // This is a simple runner to demonstrate the producer sending a message
    // as soon as the application starts.
    @Bean
    public CommandLineRunner run(KafkaProducerService producerService) {
        return args -> {
            LOGGER.info("Starting up and producing a message...");
            producerService.sendMessage("Hello, Kafka! This is an asynchronous message.");
        };
    }
}
*/
