/**
 * 
 */
package com.avinash.ProjManager.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avinash.ProjManager.model.Role;
import com.avinash.ProjManager.repository.RoleRepository;
import com.avinash.ProjManager.service.RoleService;

/**
 * @author avinash
 *
 */

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role createRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}
	

}
