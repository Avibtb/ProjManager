/**
 * 
 */
package com.avinash.ProjManager.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.avinash.ProjManager.service.UserService;

/**
 * @author avinash
 *
 */

@Controller
public class UserResource {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public String listUsers(Model model, SecurityContextHolderAwareRequestWrapper request) {
		boolean isAdminSigned = request.isUserInRole("ROLE_ADMIN");

		model.addAttribute("users", userService.findAll());
		model.addAttribute("isAdminSigned", isAdminSigned);
		return "views/users";
	}

	@GetMapping("user/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return "redirect:/users";
	}

}
