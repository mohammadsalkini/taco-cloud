package com.mohammadalsalkini.tacocloud.data;

import com.mohammadalsalkini.tacocloud.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

}