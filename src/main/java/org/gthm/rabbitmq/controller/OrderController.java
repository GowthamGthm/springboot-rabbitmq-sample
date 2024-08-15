package org.gthm.rabbitmq.controller;


import org.gthm.rabbitmq.config.RMQConfig;
import org.gthm.rabbitmq.model.Order;
import org.gthm.rabbitmq.model.OrderStatus;
import org.gthm.rabbitmq.model.Status;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class OrderController {



    @Autowired
    AmqpTemplate template;

    @PostMapping("/order")
    public String order(@RequestBody Order order) {

        order.setId(UUID.randomUUID().toString());
        OrderStatus odStatus = OrderStatus.builder().status(Status.PROCESSED)
                .deliveryPersonName("Gowtham").build();
        order.setOrderStatus(odStatus);

        template.convertAndSend(RMQConfig.ORDER_EXCHANGE, RMQConfig.ORDER_ROUTING_KEY,
                order);

        return "Success!!!!!";

    }
}