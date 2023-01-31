package com.ederjava.Web.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ederjava.Web.service.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
