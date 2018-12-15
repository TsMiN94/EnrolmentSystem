package kr.ac.hansung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, ModelMap model) {
		if (error != null) {
			model.addAttribute("errorMsg", "Invalid username and password");
		}
		if (logout != null) {
			model.addAttribute("logoutMsg", "you have been logout success");
		}
		return "login";
	}

}
