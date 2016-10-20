package com.sapient.onlineauction.domain.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.sapient.onlineauction.domain.dao.BaseDao;

@Repository
public class BaseDaoImpl implements BaseDao {

	@Autowired
	private Cluster cluster;

	@Autowired
	private Bucket bucket;

	@Value("${storage.expiry:0}")
	public static int expiry;

	/**
	 * @return the cluster
	 */
	public Cluster getCluster() {
		return cluster;
	}

	/**
	 * @param cluster
	 *            the cluster to set
	 */
	public void setCluster(Cluster cluster) {
		this.cluster = cluster;
	}

	/**
	 * @return the bucket
	 */
	public Bucket getBucket() {
		return bucket;
	}

	/**
	 * @param bucket
	 *            the bucket to set
	 */
	public void setBucket(Bucket bucket) {
		this.bucket = bucket;
	}

	/**
	 * @return the expiry
	 */
	public static int getExpiry() {
		return expiry;
	}

}
