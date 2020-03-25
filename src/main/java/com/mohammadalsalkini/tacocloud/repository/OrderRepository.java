package com.mohammadalsalkini.tacocloud.repository;

import com.mohammadalsalkini.tacocloud.model.Order;

public interface OrderRepository {
    Order save(Order order);
}