package com.sapient.onlineauction.domain.service.impl;

import java.io.IOException;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.onlineauction.common.exception.ApplicationException;
import com.sapient.onlineauction.domain.dao.UserDao;
import com.sapient.onlineauction.domain.model.User;
import com.sapient.onlineauction.domain.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDao userDao;

	@Override
	public User getUserByKey(long id) throws ApplicationException {
		Optional<User> optional;
		try {
			optional = userDao.getUsreByKey(id);
			return optional.orElseThrow(ApplicationException::new);
		} catch (IOException e) {
			logger.error(e);
			throw new ApplicationException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public String createUser(User user) throws ApplicationException {
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
