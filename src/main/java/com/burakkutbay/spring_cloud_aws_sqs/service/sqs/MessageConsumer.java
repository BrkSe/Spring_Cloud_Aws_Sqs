package com.burakkutbay.spring_cloud_aws_sqs.service.sqs;

import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @SqsListener(value = "Register-Queue", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void myConsumer(String customerName) {
        System.out.println("Hoşgeldin :" + customerName);

    }
}
