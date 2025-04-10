package com.indrayani.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.indrayani.entity.TrendingExamEntity;

@Repository
public interface TrendingExamRepository extends JpaRepository<TrendingExamEntity, Long>{

}
