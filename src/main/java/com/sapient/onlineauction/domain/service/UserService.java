package com.sapient.onlineauction.domain.service;

import com.sapient.onlineauction.domain.model.User;

public interface UserService {

	public User getUserByKey(long id);

	public String createUser(User user);

}
