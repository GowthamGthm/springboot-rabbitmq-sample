package org.gthm.rabbitmq.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RMQConfig {

    public static final String ORDER_EXCHANGE = "ORDER_EXCHANGE";
    public static final String  ORDER_QUEUE = "ORDER_QUEUE";

    public static final String  ORDER_ROUTING_KEY = "ORDER_ROUTING_KEY";

    @Bean
    public TopicExchange getExchange() {

        return new TopicExchange(ORDER_EXCHANGE);
    }

    @Bean
    public Queue queue() {

        return new Queue(ORDER_QUEUE);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {

        return BindingBuilder.bind(queue).to(exchange).with(ORDER_ROUTING_KEY);
    }



    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }



}