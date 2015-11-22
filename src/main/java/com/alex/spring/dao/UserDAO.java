package com.alex.spring.dao;

import java.util.List;

import com.alex.spring.model.User;

public interface UserDAO {
	void addUser(User u);
	void updateUser(User p);
	List<User> listUsers();
	User getUserById(int id);
	void removeUser(int id);
}
