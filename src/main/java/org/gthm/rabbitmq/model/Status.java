package org.gthm.rabbitmq.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Status {


    ORDERED,
    PROCESSING,
    PROCESSED,
    DELIVERED

}