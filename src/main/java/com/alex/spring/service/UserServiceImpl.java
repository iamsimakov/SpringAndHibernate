package com.alex.spring.service;

import java.util.List;

import com.alex.spring.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alex.spring.dao.UserDAO;


@Service
public class UserServiceImpl implements UserService {
	
	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	@Transactional
	public void addUser(User p) {
		this.userDAO.addUser(p);
	}

	@Override
	@Transactional
	public void updateUser(User p) {
		this.userDAO.updateUser(p);
	}

	@Override
	@Transactional
	public List<User> listUsers(Integer page) {
		return this.userDAO.listUsers(page);
	}

	@Override
	@Transactional
	public int getSize(){
		return this.userDAO.getSize();
	}

	@Override
	@Transactional
	public User getUserById(int id) {
		return this.userDAO.getUserById(id);
	}

	@Override
	@Transactional
	public void removeUser(int id) {
		this.userDAO.removeUser(id);
	}

	@Override
	@Transactional
	public List<User> findUser(String name) {
		return this.userDAO.findUser(name);
	}
}
