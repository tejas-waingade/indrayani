package com.indrayani.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indrayani.entity.OrderEntity;
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long>{

}
