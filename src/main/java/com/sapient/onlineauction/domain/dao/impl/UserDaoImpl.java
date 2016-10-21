package com.sapient.onlineauction.domain.dao.impl;

import java.io.IOException;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.couchbase.client.deps.com.fasterxml.jackson.core.JsonProcessingException;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.JsonLongDocument;
import com.couchbase.client.java.document.RawJsonDocument;
import com.couchbase.client.java.error.DocumentAlreadyExistsException;
import com.sapient.onlineauction.common.exception.ApplicationException;
import com.sapient.onlineauction.domain.dao.UserDao;
import com.sapient.onlineauction.domain.model.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

	@Override
	public String createUsre(User user) throws ApplicationException {

		// Mapper to map POJO to Json string
		ObjectMapper mapper = new ObjectMapper();
		String userJson = null;

		try {
			// Counter to create unique user keys and user ids
			JsonLongDocument userCounter = getBucket().counter("user", 1, 1);

			// Set the document type to user and id
			user.setType("user");
			user.setId(userCounter.content());

			// Write POJO to JSON String
			userJson = mapper.writeValueAsString(user);
			// Transform the JSON String to RawJsonDocument by passing key,
			// expiry and content to persist in DB.
			RawJsonDocument doc = RawJsonDocument.create(String.valueOf(user.hashCode()), getExpiry(), userJson);
			// Insert the document
			return getBucket().insert(doc).id();

		} catch (JsonProcessingException | DocumentAlreadyExistsException e) {
			logger.error(e);
			if (e.getClass() == JsonProcessingException.class) {
				throw new ApplicationException("Error processing Json");
			} else {
				throw new ApplicationException("user already exists");
			}
		}
	}

	@Override
	public Optional<User> getUsreByKey(long id) throws ApplicationException, IOException {

		logger.info("Method:getUsreByKey. " + "id : " + id);
		JsonDocument result;
		User user;
		result = getBucket().get(String.valueOf(id));
		if (null != result) {
			user = new ObjectMapper().readValue(result.content().toString(), User.class);
		} else {
			throw new ApplicationException("Could not find the user with the key: " + id);
		}
		return Optional.ofNullable(user);
	}
}
