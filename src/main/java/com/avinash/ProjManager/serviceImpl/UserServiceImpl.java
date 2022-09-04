/**
 * 
 */
package com.avinash.ProjManager.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.avinash.ProjManager.model.Role;
import com.avinash.ProjManager.model.User;
import com.avinash.ProjManager.repository.RoleRepository;
import com.avinash.ProjManager.repository.TaskRepository;
import com.avinash.ProjManager.repository.UserRepository;
import com.avinash.ProjManager.service.UserService;

/**
 * @author avinash
 *
 */

@Service
public class UserServiceImpl implements UserService {

	private static final String ADMIN = "ADMIN";
	private static final String USER = "USER";

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User createUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		Role userRole = roleRepository.findByRole(USER);
		user.setRoles(new ArrayList<>(Collections.singleton(userRole)));
		return userRepository.save(user);
	}

	@Override
	public User changeRoleToAdmin(User user) {
		Role adminRole = roleRepository.findByRole(ADMIN);
		user.setRoles(new ArrayList<>(Collections.singleton(adminRole)));
		return userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public boolean isUserEmailPresent(String email) {
		return userRepository.findByEmail(email) != null;
	}

	@Override
	public User getUserById(Long userId) {
		return userRepository.findById(userId).orElse(null);
	}

	@Override
	public void deleteUser(Long id) {
		User user = userRepository.getOne(id);
		user.getTasksOwned().forEach(task -> task.setOwner(null));
		userRepository.delete(user);
	}

}
