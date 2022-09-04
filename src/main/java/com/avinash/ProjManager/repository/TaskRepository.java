/**
 * 
 */
package com.avinash.ProjManager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avinash.ProjManager.model.Task;
import com.avinash.ProjManager.model.User;

/**
 * @author avinash
 *
 */

@Repository
public interface TaskRepository  extends JpaRepository<Task, Long>{
	
	List<Task> findByOwnerOrderByDateDesc(User user);

}
