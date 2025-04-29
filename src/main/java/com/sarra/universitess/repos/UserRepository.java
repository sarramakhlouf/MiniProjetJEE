package com.sarra.universitess.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarra.universitess.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername (String username);
}

