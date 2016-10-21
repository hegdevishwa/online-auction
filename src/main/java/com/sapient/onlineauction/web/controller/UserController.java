package com.sapient.onlineauction.web.controller;

import java.io.IOException;
import java.net.URI;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sapient.onlineauction.common.exception.ApplicationException;
import com.sapient.onlineauction.domain.model.User;
import com.sapient.onlineauction.domain.service.UserService;

@RestController
public class UserController {

	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	UserService userService;

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping("/users/{id}")
	public ResponseEntity<?> getUserByUserId(@PathVariable long id) {

		logger.info("Method: getUserInfo");

		User user;
		try {
			user = userService.getUserByKey(id);
			return ResponseEntity.ok(user);
		} catch (ApplicationException e) {
			logger.error(e);
			if (e.getCause().getClass() == IOException.class) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Error(e.getMessage()));
			}

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Error(e.getMessage()));
		}
	}

	@RequestMapping(path = "/users", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody User user) {

		logger.info("Method: createUser");

		String result;
		try {
			result = userService.createUser(user);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result).toUri();
			return ResponseEntity.created(uri).body(result);

		} catch (ApplicationException e) {
			logger.error(e);
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}

	@RequestMapping("/")
	public String welcome() {
		return "welcome";
	}

}
