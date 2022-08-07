package com.api.spring.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.spring.entity.UserEntity;
import com.api.spring.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserResource {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/all")
	public List<UserEntity> getUser() {
		return userRepository.findAll();
	}
	

	@GetMapping
	public  Optional<UserEntity> getUser(@RequestParam Long id) {
		return userRepository.findById(id);
	}
	
	
	@PostMapping
	public ResponseEntity<String> register(@RequestBody UserEntity user) {
		userRepository.save(user);
		return ResponseEntity.status(HttpStatus.OK).body("Registered User");
	}
	
	@PutMapping
	public ResponseEntity<String> update(@RequestBody UserEntity user) {
		if(user.getId() > 0) {
			userRepository.save(user);
			return ResponseEntity.status(HttpStatus.OK).body("Updated User");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
	}
	
	@DeleteMapping
	public ResponseEntity<String> delete(@RequestParam Long id) {
		userRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Deleted User");
	}
}
