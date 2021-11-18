package com.connor.taotie.mq.controller;

import com.connor.taotie.baseservice.dto.RepsponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;
import java.math.BigDecimal;

@RestController
public class SentMQController {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @RequestMapping("/sendMQ")
    public RepsponseDTO sendMQ() {
        //send message synchronously
        rocketMQTemplate.convertAndSend("CONNOR_A", "Hello, World!");
        //send spring message
        rocketMQTemplate.send("CONNOR_A", MessageBuilder.withPayload("Hello, World! I'm from spring message").build());
        //send messgae asynchronously
        rocketMQTemplate.asyncSend("CONNOR_A", new OrderPaidEvent("T_001", new BigDecimal("88.00")), new SendCallback() {
            @Override
            public void onSuccess(SendResult var1) {
                System.out.printf("async onSucess SendResult=%s %n", var1);
            }

            @Override
            public void onException(Throwable var1) {
                System.out.printf("async onException Throwable=%s %n", var1);
            }
        });
        //Send messages orderly
        //rocketMQTemplate.syncSendOrderly("orderly_topic",MessageBuilder.withPayload("Hello, World").build(),"hashkey");


        return new RepsponseDTO("success", "000000", "");
    }

    @RequestMapping("/sendDMQ")
    public RepsponseDTO sendDMQ() throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        DefaultMQProducer producer = rocketMQTemplate.getProducer();
        Message msg = new Message();
        msg.setTopic("CONNOR_A");
        msg.setBody("this is a delay message1".getBytes());
        //设置延迟level为5，对应延迟1分钟
        msg.setDelayTimeLevel(5);
        producer.send(msg);


        Message msg2 = new Message();
        msg2.setTopic("CONNOR_A");
        msg2.setBody("this is a delay message2".getBytes());
        //设置延迟level为5，对应延迟1分钟
        msg2.setDelayTimeLevel(4);
        producer.send(msg2);
        return new RepsponseDTO("success", "000000", "");
    }

    @Data
    @AllArgsConstructor
    public class OrderPaidEvent implements Serializable {
        private String orderId;

        private BigDecimal paidMoney;
    }

}
