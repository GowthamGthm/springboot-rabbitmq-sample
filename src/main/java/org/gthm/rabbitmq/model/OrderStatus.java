package org.gthm.rabbitmq.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
public class OrderStatus {

    private Status status;
    private String deliveryPersonName;



}