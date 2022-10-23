package com.burakkutbay.spring_cloud_aws_sqs.service.sqs;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageSender {
    @Autowired
    private AmazonSQSAsync sqs;
    @Value("${sqs.url}")
    private String sqsUrl;

    public void sendToSqs(String customerName) {
        sqs.sendMessage(sqsUrl, customerName);
    }
}
