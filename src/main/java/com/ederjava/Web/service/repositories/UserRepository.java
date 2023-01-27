package com.ederjava.Web.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ederjava.Web.service.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
