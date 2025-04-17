package com.indrayani.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.indrayani.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	Optional<UserEntity> findByEmail(String email);

	@Query("SELECT u FROM UserEntity u WHERE u.mobile = :mobile")
	Optional<UserEntity> findByMobile(String mobile);

	UserEntity findByGoogleId(String googleId);
}
