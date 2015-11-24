package com.alex.spring.service;

import java.util.List;


import com.alex.spring.model.User;

public interface UserService {

	void addUser(User p);

	void updateUser(User p);

	List<User> listUsers(Integer page);

	User getUserById(int id);

	void removeUser(int id);

	int getSize();

	List<User> findUser(String name);
}
