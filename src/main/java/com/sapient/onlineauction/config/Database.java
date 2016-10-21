package com.sapient.onlineauction.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;

@Configuration
public class Database {

	private static final Logger logger = Logger.getLogger(Database.class);

	@Value("${hostname}")
	private String hostname;

	@Value("${bucket}")
	private String bucket;

	@Bean
	public Cluster cluster() {
		logger.info("Getting couchbase cluster.");
		return CouchbaseCluster.create(hostname);
	}

	@Bean
	public Bucket bucket() {
		logger.info("Opening couchbase bucket:" + bucket);
		return cluster().openBucket(bucket);
	}

}
