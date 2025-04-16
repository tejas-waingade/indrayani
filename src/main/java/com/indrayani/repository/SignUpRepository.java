package com.indrayani.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.indrayani.entity.UserSignUpEntity;

@Repository
public interface SignUpRepository extends JpaRepository<UserSignUpEntity, Long> {
	Optional<UserSignUpEntity> findByMobile(String mobile);

	Optional<UserSignUpEntity> findByEmail(String email);
}
