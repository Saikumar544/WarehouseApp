package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.User;
import com.app.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
private IUserService service;
	@RequestMapping("/reg")
	public String show(ModelMap map)
	{
		map.addAttribute("user",new User());
	return "User";	
	}
	@RequestMapping("/save")
	public String saveUser(@ModelAttribute User user,ModelMap map)
	{
	map.addAttribute("user",new User());
	Integer id=service.saveUser(user);
	map.addAttribute("msg","User Saved With id '"+id+"' Succesfully.. ");
	return "User";
	}
	@RequestMapping("/all")
	public String getAll(ModelMap map)
	{
		List<User> list=service.getAllUsers();
		map.addAttribute("list",list);
		return "UserData";
	}
	@RequestMapping("/edit{id}")
	public String editUser(@RequestParam Integer id,ModelMap map)
	{
//		map.addAttribute("user",new User());
	User user=service.getOneUser(id);
	map.addAttribute("user",user);
		return "UserEdit";
		
	}
	@RequestMapping("/update")
	public String updateUser(@ModelAttribute User user,ModelMap map)
	{
	service.updateUser(user);
	List<User> list=service.getAllUsers();
	map.addAttribute("list",list);
	return "UserData";
	}
}
