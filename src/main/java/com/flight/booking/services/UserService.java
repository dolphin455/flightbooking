package com.flight.booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flight.booking.daos.UserDao;
import com.flight.booking.entities.User;



@Service
public class UserService {
	@Autowired
	private UserDao dao;

//	public UserDao getDao() {
//		return dao;
//	}
//
//	public void setDao(UserDao dao) {
//		this.dao = dao;
//	}

	@Transactional
	public int save(User user) {
		//business logic
		return dao.create(user);
	}

	public List<User> getUsers() {

		return dao.findUsers();
	}
}