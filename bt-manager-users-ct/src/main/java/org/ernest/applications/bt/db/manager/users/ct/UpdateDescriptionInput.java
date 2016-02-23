package org.ernest.applications.bt.db.manager.users.ct;

public class UpdateDescriptionInput {

	private String userId;
	private String description;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	
}