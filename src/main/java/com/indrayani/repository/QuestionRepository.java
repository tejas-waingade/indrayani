package com.indrayani.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indrayani.entity.QuestionEntity;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity, Long>{

	
}
