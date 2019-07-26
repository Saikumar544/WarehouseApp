package com.app.service;

import java.util.List;

import com.app.model.User;

public interface IUserService {
		Integer saveUser(User user);
		void updateUser(User user);
		void deleteUser(Integer id);
		User getOneUser(Integer id);
		List<User> getAllUsers();

}
