package com.sarra.universitess.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarra.universitess.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRole(String role);
}
