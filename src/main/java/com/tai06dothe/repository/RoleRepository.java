package com.tai06dothe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tai06dothe.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>{

	RoleEntity findByCode(String code);
	
}
