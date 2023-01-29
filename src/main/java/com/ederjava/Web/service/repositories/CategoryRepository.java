package com.ederjava.Web.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ederjava.Web.service.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
