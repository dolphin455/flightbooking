package com.flight.booking.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flight.booking.user.dao.UserDao;
import com.flight.booking.user.entity.User;

@Service
public class UserServiceImpl {
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
