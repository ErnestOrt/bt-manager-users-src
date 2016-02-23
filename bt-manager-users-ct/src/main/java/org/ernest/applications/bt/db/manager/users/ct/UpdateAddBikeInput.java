package org.ernest.applications.bt.db.manager.users.ct;

import org.ernest.applications.bt.db.manager.users.ct.entities.Bike;

public class UpdateAddBikeInput {

	private String userId;
	private Bike bike;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Bike getBike() {
		return bike;
	}
	public void setBike(Bike bike) {
		this.bike = bike;
	}
}