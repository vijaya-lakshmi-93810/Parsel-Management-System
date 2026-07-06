package com.tcs.ParsalManagement.Services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.ParsalManagement.Models.User;
import com.tcs.ParsalManagement.Repositories.UserRepository;

@Service
@Transactional
public class UserService
{
	@Autowired
	UserRepository ur;
	

	public int registerService(User u)
	{
		if(ur.save(u) != null)
		{
			return 1;
		}
		return 0;
	}

	public User loginService(String userId, String password) {
		Optional<User> opt = ur.findById(userId);
		if (opt.isPresent()) {
			User user = opt.get();
			if (user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

	public User getUser(String userId) {
		Optional<User> opt = ur.findById(userId);
		return opt.orElse(null);
	}

	public List<User> getAllUsers() {
		return ur.findAll();
	}
}
