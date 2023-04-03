package net.codejava.spring.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView doLogin(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(!username.isEmpty() && !password.isEmpty()) {
			if(username.equalsIgnoreCase("admin") && password.equals("admin")) {
				return new ModelAndView("confirmation", "username", username);
			} else {
				return new ModelAndView("login", "error", "Username or password is invalid");
			}
		}
		return new ModelAndView("login", "error", "Please enter username and password");
		
	}
}
