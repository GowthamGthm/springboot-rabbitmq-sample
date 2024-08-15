package org.gthm.rabbitmq.model;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
public class Order {

    private String id;
    private String item;
    private Integer quantity;
    private Integer price;


    private OrderStatus orderStatus;


}