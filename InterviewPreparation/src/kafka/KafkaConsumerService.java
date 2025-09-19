/*
package kafka;


@Component
public class KafkaConsumerService {

    private static final Logger LOGGER = Logger.getLogger(KafkaConsumerService.class.getName());

    // @KafkaListener automatically sets up a message listener.
    // 'topics' specifies which topic to listen to.
    // 'groupId' specifies the consumer group, which is crucial for
    // scaling and message delivery.
    @KafkaListener(topics = "${spring.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeMessage(String message) {
        LOGGER.info(String.format("Consumed message: %s", message));
        // You would typically add business logic here to process the message.
        // For example, saving it to a database, sending an email, etc.
    }
}
*/
