/**
 * 
 */
package com.avinash.ProjManager.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.avinash.ProjManager.model.User;
import com.avinash.ProjManager.service.TaskService;
import com.avinash.ProjManager.service.UserService;
import java.security.Principal;

/**
 * @author avinash
 *
 */

@Controller
public class ProfileResource {

	@Autowired
	private UserService userService;

	@Autowired
	private TaskService taskService;

	@GetMapping("/profile")
	public String showProfilePage(Model model, Principal principal) {
		String email = principal.getName();
		User user = userService.getUserByEmail(email);
		model.addAttribute("user", user);
		model.addAttribute("tasksOwned", taskService.findByOwnerOrderByDateDesc(user));
		return "views/profile";
	}

	@GetMapping("/profile/mark-done/{taskId}")
	public String setTaskCompleted(@PathVariable Long taskId) {
		taskService.setTaskCompleted(taskId);
		return "redirect:/profile";
	}

	@GetMapping("/profile/unmark-done/{taskId}")
	public String setTaskNotCompleted(@PathVariable Long taskId) {
		taskService.setTaskNotCompleted(taskId);
		return "redirect:/profile";
	}
}