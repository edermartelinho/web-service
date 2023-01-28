package com.ederjava.Web.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ederjava.Web.service.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
