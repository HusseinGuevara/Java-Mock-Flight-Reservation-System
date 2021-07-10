package com.hussein.java_project.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hussein.java_project.models.User;

public interface UserRepo extends CrudRepository<User, Long> {
	Optional<User> findByEmail(String email);
}
