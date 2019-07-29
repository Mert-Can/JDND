package com.example.demo.model.persistence;

import com.example.demo.model.persistence.repositories.CartRepository;
import com.example.demo.model.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CartRepository cartRepository;


	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserController(UserRepository userRepository,
						  BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Userd> findById(@PathVariable Long id) {
		return ResponseEntity.of(userRepository.findById(id));
	}
	
	@GetMapping("/{username}")
	public ResponseEntity<Userd> findByUserName(@PathVariable String username) {
		Userd user = userRepository.findByUsername(username);
		return user == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(user);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Userd> createUser(@RequestBody Userd user) {
		//User user = new User();
		//user.setUsername(createUserRequest.getUsername());
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		Cart cart = new Cart();
		cartRepository.save(cart);
		user.setCart(cart);

		return ResponseEntity.ok(user);
	}
	
}
