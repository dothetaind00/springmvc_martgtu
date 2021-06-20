package com.tai06dothe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tai06dothe.entity.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity, Long>{

}
