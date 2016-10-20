package com.sapient.onlineauction.domain.model;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserTest {

	User user;

	@Before
	public void setUp() throws Exception {
		user = new User("Vishwa", "Hegde", new Date(), "vishwa@sapient.com", "password", "user", 10);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHashCode() {
		assertNotEquals(100, user.hashCode());
	}

	@Test
	public void testGetFirstName() {
		assertEquals("Vishwa", user.getFirstName());
	}

	@Test
	public void testSetFirstName() {
		user.setFirstName("Vishwamitra");
		assertEquals("Vishwamitra", user.getFirstName());
	}

	@Test
	public void testGetLastName() {
		assertEquals("Hegde", user.getLastName());
	}

	@Test
	public void testSetLastName() {
		user.setLastName("Bhat");
		assertEquals("Bhat", user.getLastName());
	}

	@Test
	public void testGetUserName() {
		assertEquals("vishwa@sapient.com", user.getUserName());
	}

	@Test
	public void testSetUserName() {
		user.setUserName("vishwamitra.hegde@gmail.com");
		assertEquals("vishwamitra.hegde@gmail.com", user.getUserName());
	}

}
