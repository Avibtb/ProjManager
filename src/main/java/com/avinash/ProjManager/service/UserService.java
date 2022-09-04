/**
 * 
 */
package com.avinash.ProjManager.service;

import java.util.List;

import com.avinash.ProjManager.model.User;

/**
 * @author avinash
 *
 */
public interface UserService {

	User createUser(User user);

	User changeRoleToAdmin(User user);

	List<User> findAll();

	User getUserByEmail(String email);

	boolean isUserEmailPresent(String email);

	User getUserById(Long userId);

	void deleteUser(Long id);
}
