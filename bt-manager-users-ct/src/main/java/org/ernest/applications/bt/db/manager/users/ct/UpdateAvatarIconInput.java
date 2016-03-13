package org.ernest.applications.bt.db.manager.users.ct;

public class UpdateAvatarIconInput {

	private String userId;
	private int iconId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getIconId() {
		return iconId;
	}
	public void setIconId(int iconId) {
		this.iconId = iconId;
	}
}