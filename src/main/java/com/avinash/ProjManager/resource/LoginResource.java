/**
 * 
 */
package com.avinash.ProjManager.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author avinash
 *
 */

@Controller
public class LoginResource {
	
	
	@GetMapping("/login")
	String showLoginForm() {
		return "forms/login";
	}

}
