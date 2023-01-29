package com.ederjava.Web.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ederjava.Web.service.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
