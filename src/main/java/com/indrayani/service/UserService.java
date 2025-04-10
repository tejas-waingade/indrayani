package com.indrayani.service;

import java.util.List;
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
	private  UserRepository userRepository;
	@Autowired
	private UserMapper userMapper;

	 
	private UserDTO convertEntityToDto(UserEntity userEntity) {
		return userMapper.toDTO(userEntity);
	}

	public void save(UserEntity userEntity) {
	}

	public List<UserDTO> getAllUsers() {
		return userRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
	}

	public UserDTO getUserById(Long id) {
		return userRepository.findById(id).map(this::convertEntityToDto).orElse(null);
	}

	public UserDTO addUser(UserDTO userDTO) {
		UserEntity userEntity = userMapper.toEntity(userDTO);
		UserEntity userEntityObj = userRepository.save(userEntity);
		UserDTO useDto = userMapper.toDTO(userEntityObj);
		return useDto;
	}

	public UserEntity updateUserById(Long id, UserEntity userEntity) {

		boolean isExist = userRepository.existsById(id);
		if (isExist) {
			userEntity.setId(id);
			return userRepository.save(userEntity);
		} else {
			return null;
		}

	}

	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}
}
