/*
package kafka;

@Service
public class KafkaProducerService {

    @Value("${spring.kafka.topic}")
    private String topic;

    private final KafkaTemplate<String, String> kakfaTemplate;

    @Autowired
    KafkaProducerService(KafkaTemplate<String, String> kakfaTemplate){
        this.kakfaTemplate = kakfaTemplate;
    }

    // This method sends a message to our configured topic.
    // The call is non-blocking and returns a CompletableFuture.
    public void sendMessage(String message) {
        LOGGER.info(String.format("Producing message to topic '%s': %s", topic, message));
        kafkaTemplate.send(topic, message);
    }
}
*/
