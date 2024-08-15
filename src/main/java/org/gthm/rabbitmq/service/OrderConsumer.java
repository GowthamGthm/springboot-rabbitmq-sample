package org.gthm.rabbitmq.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.gthm.rabbitmq.config.RMQConfig;
import org.gthm.rabbitmq.model.Order;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {


//    @RabbitListener(queues = RMQConfig.ORDER_QUEUE)
    @SneakyThrows
    public void receive(Order order) {

        System.out.println("Consumed Message: " + order);

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(order));

    }


}
