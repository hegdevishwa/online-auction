package com.sapient.onlineauction.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;

@Configuration
public class Database {

	@Value("${hostname}")
	private String hostname;

	@Value("${bucket}")
	private String bucket;

	@Bean
	public Cluster cluster() {
		return CouchbaseCluster.create(hostname);
	}

	@Bean
	public Bucket bucket() {
		return cluster().openBucket(bucket);
	}

}
