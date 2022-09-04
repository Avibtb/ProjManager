/**
 * 
 */
package com.avinash.ProjManager.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author avinash
 *
 */

@Controller
public class StaticPageResource {
	
	@RequestMapping("/about")
	String showAboutPage() {
		return "view/about";
	}

}
