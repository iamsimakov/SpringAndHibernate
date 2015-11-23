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
	public String listUsers(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("listUsers", this.userService.listUsers());
		return "user";
	}

	@RequestMapping(value = "/testangular.json", method = RequestMethod.GET, produces={"application/xml", "application/json"})
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody User getUser() {
		User user = new User();
		user.setName("ivan");
		user.setAge(23);
		user.setCreateDate(new Date());
		user.setId(100);
		user.setIsAdmin(true);
		return user;
	}
	
	//For add and update user both
	@RequestMapping(value= "/user/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User p){
		
		if(p.getId() == 0){
			//new user, add it
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
        model.addAttribute("listUsers", this.userService.listUsers());
        return "user";
    }

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
}
