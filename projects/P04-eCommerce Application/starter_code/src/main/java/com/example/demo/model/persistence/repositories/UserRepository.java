package com.example.demo.model.persistence.repositories;

import com.example.demo.model.persistence.Userd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Userd, Long> {
	Userd findByUsername(String username);


}
