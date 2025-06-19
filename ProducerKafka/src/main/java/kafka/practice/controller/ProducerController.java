package kafka.practice.controller;

import kafka.practice.entity.MyMsg;
import kafka.practice.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProducerController {
    private final KafkaProducerService kafkaProducerService;
    @PostMapping(value = "/produce")
    public ResponseEntity<String> produce(@RequestBody MyMsg myMsg) {
        try {
            kafkaProducerService.send("topic-name", myMsg);
            return ResponseEntity.ok("Message sent successfully");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to send message: " + ex.getMessage());
        }
    }

    @PostMapping(value = "/produce/two")
    public ResponseEntity<String> produceTwo(@RequestBody MyMsg myMsg) {
        try {
            kafkaProducerService.send("topic-name-two", myMsg);
            return ResponseEntity.ok("Message sent successfully");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to send message: " + ex.getMessage());
        }
    }
}
