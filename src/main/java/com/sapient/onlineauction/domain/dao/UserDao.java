package com.sapient.onlineauction.domain.dao;

import java.io.IOException;
import java.util.Optional;

import com.sapient.onlineauction.common.exception.ApplicationException;
import com.sapient.onlineauction.domain.model.User;

public interface UserDao {

	public String createUsre(User user) throws ApplicationException;

	public Optional<User> getUsreByKey(long id) throws ApplicationException, IOException;

}
