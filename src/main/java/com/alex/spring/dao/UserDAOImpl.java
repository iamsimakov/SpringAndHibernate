package com.alex.spring.dao;

import java.util.List;

import com.alex.spring.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository
public class UserDAOImpl implements UserDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addUser(User u) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(u);
		logger.info("User saved successfully, User Details="+ u);
	}

	@Override
	public void updateUser(User u) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(u);
		logger.info("User updated successfully, User Details="+ u);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsers(Integer page) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User");
		query.setFirstResult((page - 1) * 10);
		query.setMaxResults(10);
		List<User> usersList = query.list();
		for(User u : usersList){
			logger.info("User List::"+ u);
		}
		return usersList;
	}

	@Override
	public int getSize() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from User").list().size();
	}

	@Override
	public User getUserById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User u = (User) session.load(User.class, new Integer(id));
		logger.info("User loaded successfully, User details="+u);
		return u;
	}

	@Override
	public void removeUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User u = (User) session.load(User.class, new Integer(id));
		if(null != u){
			session.delete(u);
		}
		logger.info("User deleted successfully, User details="+u);
	}

	@Override
	public List<User> findUser(String name) {
		String query = "select * from user where name like '%" + name + "%'";
		Session session = sessionFactory.getCurrentSession();
		return session.createSQLQuery(query).addEntity(User.class).list();
	}
}
