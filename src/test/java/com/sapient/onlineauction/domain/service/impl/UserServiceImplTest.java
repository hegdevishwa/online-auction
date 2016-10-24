package com.sapient.onlineauction.domain.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.stub;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.sapient.onlineauction.common.exception.ApplicationException;
import com.sapient.onlineauction.domain.dao.impl.UserDaoImpl;
import com.sapient.onlineauction.domain.model.User;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

	@Mock
	UserDaoImpl userDao;

	@InjectMocks
	public UserServiceImpl userService;

	@Test
	public void testGetUserByKey() {

		Optional<User> user = getUser();
		try {
			stub(userDao.getUsreByKey(10)).toReturn(user);

			User userRes = userService.getUserByKey(10);

			assertEquals(user.get(), userRes);

		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testCreateUser() {
		fail("Not yet implemented");
	}

	private Optional<User> getUser() {

		return Optional.of(new User("Vishwa", "Hegde", new Date(), "vishwa@sapientr.com", "password", "user", 10));

	}

}
