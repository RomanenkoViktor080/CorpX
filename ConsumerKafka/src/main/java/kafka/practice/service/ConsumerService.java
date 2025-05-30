package kafka.practice.service;

import kafka.practice.entity.MyMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConsumerService {
   @KafkaListener(topics={"topic-name"}, groupId = "topic-name")
   public void consume(MyMsg myMsg) {
      log.info(String.format("Received: " + myMsg));
   }
}
