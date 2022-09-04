/**
 * 
 */
package com.avinash.ProjManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avinash.ProjManager.model.Role;

/**
 * @author avinash
 *
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Role findByRole(String user);

}
