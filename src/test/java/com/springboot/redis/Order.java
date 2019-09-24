package com.springboot.redis;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

    private Long orderId;

    private Double price;

    private String name;

    private Instant createdTime;
}
