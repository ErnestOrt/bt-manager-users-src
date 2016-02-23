package org.ernest.applications.bt.db.manager.users.ct;

import org.ernest.applications.bt.db.manager.users.ct.entities.Statistics;

public class UpdateStatisticsInput {

	private String userId;
	private Statistics statistics;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Statistics getStatistics() {
		return statistics;
	}
	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}
}