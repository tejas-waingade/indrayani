package com.indrayani.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.indrayani.entity.CategoriesEntity;

@Repository
public interface CategoriesRepository extends JpaRepository<CategoriesEntity, Long> {

	@Query("SELECT c FROM CategoriesEntity c WHERE c.isActive =:active")
	public List<CategoriesEntity> getActiveCategories(@Param("active") Boolean active);
}
