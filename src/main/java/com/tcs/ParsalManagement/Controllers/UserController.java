package com.tcs.ParsalManagement.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.ParsalManagement.Models.User;
import com.tcs.ParsalManagement.Services.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController
{
	@Autowired
	UserService us;
	
	@PostMapping("/register")
	int register(@RequestBody User u)
	{
		return us.registerService(u);
	}

	@PostMapping("/login")
	public User login(@RequestBody User u)
	{
		return us.loginService(u.getUserId(), u.getPassword());
	}

	@GetMapping("/user/{id}")
	public User getUser(@PathVariable String id)
	{
		return us.getUser(id);
	}

	@GetMapping("/users")
	public List<User> getAllUsers()
	{
		return us.getAllUsers();
	}

	@GetMapping("/check-username/{id}")
	public boolean checkUsername(@PathVariable String id)
	{
		return us.getUser(id) != null;
	}
}
