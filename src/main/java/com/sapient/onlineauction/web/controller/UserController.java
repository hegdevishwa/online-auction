package com.sapient.onlineauction.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sapient.onlineauction.domain.model.User;
import com.sapient.onlineauction.domain.service.UserService;

@RestController
public class UserController {

	Logger LOGGER = Logger.getLogger(this.getClass());

	@Autowired
	UserService userService;

	@RequestMapping("/users/{id}")
	public ResponseEntity<User> getUserInfo(@PathVariable long id) {

		LOGGER.info("Method: getUserInfo");
		User user = userService.getUserByKey(id);
		if (null != user) {
			return new ResponseEntity<>(user, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(path = "/users", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody User user) {

		LOGGER.info("Method: createUser");

		String result = userService.createUser(user);
		HttpHeaders httpHeaders = new HttpHeaders();

		if (result == "fail") {
			return new ResponseEntity<>("fail", HttpStatus.ALREADY_REPORTED);

		} else {
			httpHeaders.setLocation(
					ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result).toUri());
			return new ResponseEntity<>("created", httpHeaders, HttpStatus.CREATED);
		}
	}

	@RequestMapping("/")
	public String welcome() {
		return "welcome";
	}

}
