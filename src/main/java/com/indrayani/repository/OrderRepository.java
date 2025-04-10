package com.indrayani.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indrayani.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long>{

}
