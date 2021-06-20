package com.tai06dothe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tai06dothe.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	UserEntity findOneByUserNameAndStatus(String name,Boolean status);
	
	UserEntity findOneByUserName(String name);
}
