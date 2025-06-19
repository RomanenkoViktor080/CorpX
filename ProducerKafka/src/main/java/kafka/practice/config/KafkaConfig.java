package kafka.practice.config;

import kafka.practice.entity.MyMsg;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {
    @Value("${spring.kafka.bootstrap-servers}") String bootstrapServers;
    @Bean
    public ProducerFactory<String, MyMsg> producerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(config);
    }
    @Bean
    public NewTopic taskTopic() {
        return TopicBuilder.name("topic-name")
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic taskTopicTwo() {
        return TopicBuilder.name("topic-name-two")
                .partitions(1)
                .replicas(1)
                .build();
    }
    @Bean
    public KafkaTemplate<String, MyMsg> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
