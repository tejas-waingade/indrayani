package com.indrayani.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indrayani.DTO.UserDTO;
import com.indrayani.entity.UserEntity;
import com.indrayani.mapper.UserMapper;
import com.indrayani.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	private UserDTO convertEntityToDto(UserEntity userEntity) {
		return userMapper.toDTO(userEntity);
	}

	public List<UserDTO> getAllUsers() {
		return userRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
	}

	public UserDTO getUserById(Long id) {
		return userRepository.findById(id).map(this::convertEntityToDto).orElse(null);
	}

	public UserDTO addUser(UserDTO userDTO) {

		if (userRepository.existsByMobile(userDTO.getMobile())) {
			throw new RuntimeException("Mobile number already exists");
		}
		if (userRepository.existsByEmail(userDTO.getEmail())) {
			throw new RuntimeException("Email already exists");
		}

		UserEntity userEntity = userMapper.toEntity(userDTO);

		String otp = String.format("%04d", new Random().nextInt(10000));
		LocalDateTime now = LocalDateTime.now();

		userEntity.setEmailOtp(otp);
		userEntity.setMobileOtp(otp);
		userEntity.setEmailOtpGeneratedAt(now);
		userEntity.setMobileOtpGeneratedAt(now);
		userEntity.setCreatedAt(now);
		userEntity.setFcmToken("fcmToken" + UUID.randomUUID());
		userEntity.setGoogleId("google-" + UUID.randomUUID());

		UserEntity saved = userRepository.save(userEntity);
		return userMapper.toDTO(saved);
	}

	public UserEntity updateUserById(Long id, UserEntity userEntity) {
		if (userRepository.existsById(id)) {
			userEntity.setId(id);
			userEntity.setUpdatedAt(LocalDateTime.now());
			return userRepository.save(userEntity);
		}
		return null;
	}

	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}
}
