package com.indrayani.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indrayani.entity.OrderExamMap;
@Repository
public interface OrderExamMapRepository extends JpaRepository<OrderExamMap, Long>{

}
