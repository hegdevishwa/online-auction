package com.sapient.onlineauction.domain.service;

import com.sapient.onlineauction.common.exception.ApplicationException;
import com.sapient.onlineauction.domain.model.User;

public interface UserService {

	public User getUserByKey(long id) throws ApplicationException;

	public String createUser(User user) throws ApplicationException;

}
