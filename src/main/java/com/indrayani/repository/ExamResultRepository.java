package com.indrayani.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indrayani.entity.ExamResultEntity;
@Repository
public interface ExamResultRepository extends JpaRepository<ExamResultEntity, Long>{

}
