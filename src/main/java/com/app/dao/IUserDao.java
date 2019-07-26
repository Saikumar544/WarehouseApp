package com.app.dao;

import java.util.List;

import com.app.model.User;

public interface IUserDao {
Integer saveUser(User user);
void updateUser(User user);
void deleteUser(Integer id);
User getOneUser(Integer id);
List<User> getAllUsers();
}
