package com.sapient.onlineauction.domain.dao;

import java.util.Optional;

import com.sapient.onlineauction.domain.model.User;

public interface UserDao {

	public String createUsre(User user);

	public Optional<User> getUsreByKey(long id);

}
