package com.burakkutbay.spring_cloud_aws_sqs.controller;

import com.burakkutbay.spring_cloud_aws_sqs.service.sqs.MessageSender;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    private final MessageSender messageSender;

    public RegisterController(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @PostMapping("/register/{name}")
    public ResponseEntity<String> register(@PathVariable("name") String customerName) {
        messageSender.sendToSqs(customerName);
        return new ResponseEntity<>("Message Published", HttpStatus.OK);
    }
}
