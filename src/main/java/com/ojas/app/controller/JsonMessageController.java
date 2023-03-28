package com.ojas.app.controller;

import com.ojas.app.dto.User;
import com.ojas.app.publisher.RabbitMQJsonProducer;
import com.ojas.app.publisher.RabbitMQProducer;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2")
public class JsonMessageController {

    private RabbitMQJsonProducer producer;

    public JsonMessageController(RabbitMQJsonProducer producer) {
        this.producer = producer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestBody User user) {

        producer.sendJsonMessge(user);
        return ResponseEntity.ok("Json Message sent to RabbitMQ ...");
    }

}
