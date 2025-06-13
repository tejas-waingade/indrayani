package com.indrayani.controller;

import com.indrayani.DTO.UserDTO;
import com.indrayani.entity.UserEntity;
import com.indrayani.service.UserService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public List<UserDTO> getallUsers() {
		return userService.getAllUsers();

	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
		UserDTO userDTO = userService.getUserById(id);
		if (userDTO != null) {
			return ResponseEntity.ok(userDTO);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<?> addUser(@RequestBody UserDTO userDTO) {
		try {
			UserDTO userDTOObj = userService.addUser(userDTO);
			return new ResponseEntity<>(userDTOObj, HttpStatus.CREATED);
		} catch (IllegalArgumentException ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserEntity> updateUserById(@PathVariable Long id, @RequestBody UserEntity userEntity) {
		UserEntity userEntity1 = userService.updateUserById(id, userEntity);
		if (userEntity1 != null) {
			return ResponseEntity.ok(userEntity1);

		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<UserEntity> deleteUserById(@PathVariable Long id) {
		userService.deleteUserById(id);
		return ResponseEntity.noContent().build();
	}

}
