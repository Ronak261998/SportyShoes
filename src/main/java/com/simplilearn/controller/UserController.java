package com.simplilearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.entity.User;
import com.simplilearn.repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepo;
	

	@GetMapping("/register")
	public ModelAndView addUser() {
		ModelAndView mav = new ModelAndView("signUp");
		User user = new User();
		mav.addObject("user", user);
		return mav;
	}
	@PostMapping("/saveUser")
	public String saveEmployee(@ModelAttribute User user) {
		userRepo.save(user);
		return "redirect:/users";
	}
	@GetMapping("/users")
	public ModelAndView getUsers(Model model) {
		ModelAndView mav = new ModelAndView("allUsers");
		mav.addObject("users", userRepo.findAll());
		return mav;
	}
	@GetMapping("/updateUser")
	public ModelAndView showUpdateForm(@RequestParam int id) {
		ModelAndView mav = new ModelAndView("signUp");
		User user = userRepo.findById(id).get();
		mav.addObject("user", user);
		return mav;
	}
	@GetMapping("/deleteUser")
	public String deleteEmp(@ModelAttribute User user,@RequestParam int id) {
		 userRepo.deleteById(id);
		return "redirect:/users";
	}
	@GetMapping("/userLogin")
    public ModelAndView login(@RequestParam String email, BindingResult result){
		ModelAndView mav = new ModelAndView("login-page");
		return mav;
   }

}
