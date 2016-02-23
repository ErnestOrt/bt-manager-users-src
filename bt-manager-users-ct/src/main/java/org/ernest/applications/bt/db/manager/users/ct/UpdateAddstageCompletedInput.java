package org.ernest.applications.bt.db.manager.users.ct;

public class UpdateAddstageCompletedInput {

	private String userId;
	private String stageId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStageId() {
		return stageId;
	}
	public void setStageId(String stageId) {
		this.stageId = stageId;
	}
}