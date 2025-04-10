package com.indrayani.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indrayani.entity.ExamEntity;

@Repository
public interface ExamRepository extends JpaRepository<ExamEntity, Long> {

}

