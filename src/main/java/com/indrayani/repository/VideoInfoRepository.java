package com.indrayani.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indrayani.entity.VideoInfoEntity;
@Repository
public interface VideoInfoRepository extends JpaRepository<VideoInfoEntity, Long>{

}
