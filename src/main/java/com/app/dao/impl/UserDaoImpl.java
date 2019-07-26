package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUserDao;
import com.app.model.User;
@Repository
public class UserDaoImpl implements IUserDao {
	@Autowired
private HibernateTemplate ht;

	@Override
	public Integer saveUser(User user) {
		// TODO Auto-generated method stub
		return (Integer) ht.save(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		ht.update(user);
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		ht.delete(new User(id));
	}

	@Override
	public User getOneUser(Integer id) {
		// TODO Auto-generated method stub
		return ht.get(User.class, id);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return ht.loadAll(User.class);
	}
}
