package com.sapient.onlineauction.domain.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.onlineauction.common.exception.ApplicationException;
import com.sapient.onlineauction.domain.dao.UserDao;
import com.sapient.onlineauction.domain.model.User;
import com.sapient.onlineauction.domain.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User getUserByKey(long id) {

		Optional<User> optional = userDao.getUsreByKey(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;

	}

	@Override
	public String createUser(User user) {

		return userDao.createUsre(user);

	}

	/**
	 * @return the userDao
	 */
	public UserDao getUserDao() {
		return userDao;
	}

	/**
	 * @param userDao
	 *            the userDao to set
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
