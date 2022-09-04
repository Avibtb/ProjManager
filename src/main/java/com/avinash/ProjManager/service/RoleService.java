/**
 * 
 */
package com.avinash.ProjManager.service;

import java.util.List;

import com.avinash.ProjManager.model.Role;

/**
 * @author avinash
 *
 */
public interface RoleService {

	Role createRole(Role role);

	List<Role> findAll();

}
