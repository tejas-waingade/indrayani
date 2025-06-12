package com.indrayani.repository;

import com.indrayani.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	Optional<UserEntity> findByMobile(String mobile);
	Optional<UserEntity> findByGoogleId(String googleId);
}