package com.alex.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.alex.spring.model.User;
import com.alex.spring.service.UserService;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@Controller
public class UserController {
	
	private UserService userService;
	
	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService ps){
		this.userService = ps;
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listUsers(@RequestParam(value = "page", required = false) Integer page,
							Model model) {
		if (page == null) page = 1;
		model.addAttribute("user", new User());
		model.addAttribute("listUsers", this.userService.listUsers(page));
		setAttributes(model);
		return "user";
	}

	@RequestMapping(value = "/users/find", method = RequestMethod.POST)
	public String Search(@RequestParam(value="name", required=true) String name,
						 Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("listUsers", this.userService.findUser(name));

		return "finduser";
	}
	
	//For add and update user both
	@RequestMapping(value= "/user/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User p){
		if(p.getId() == 0){
			//new user, add it
			p.setCreatedDate(new Date());
			this.userService.addUser(p);
		}else{
			//existing user, call update
			this.userService.updateUser(p);
		}
		return "redirect:/users";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id){
        this.userService.removeUser(id);
        return "redirect:/users";
    }
 
    @RequestMapping("/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUsers", this.userService.listUsers(1));
		setAttributes(model);
        return "user";
    }

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	public void setAttributes(Model model){
		int startpage = 1;
		int ch = this.userService.getSize() / 10;
		int div = this.userService.getSize() % 10;
		int endpage = div > 0 ? ch + 1 : ch;
		model.addAttribute("startpage", startpage);
		model.addAttribute("endpage", endpage);
	}

}
