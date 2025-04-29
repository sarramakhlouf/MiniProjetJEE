package com.sarra.universitess.service;

import com.sarra.universitess.entities.Role;
import com.sarra.universitess.entities.User;

public interface UserService {
	void deleteAllusers();
	void deleteAllRoles();
	User saveUser(User user);
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);

}
