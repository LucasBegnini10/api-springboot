package com.api.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.spring.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	
}
