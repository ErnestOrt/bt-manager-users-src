package org.ernest.applications.bt.db.manager.users.ct.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
	
	private String _id;
	private String _rev;
	
	private String name;
	private String description;
	private Statistics statistics;
	private int avatarIcon;
	private List<Bike> bikesList;
	private Set<String> stagesIdsCompleted;
	private Set<String> stagesIdsJoined;
	
	public User(){
		bikesList = new ArrayList<Bike>();
		stagesIdsCompleted = new HashSet<String>();
		stagesIdsJoined = new HashSet<String>();
	}
	
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String get_rev() {
		return _rev;
	}

	public void set_rev(String _rev) {
		this._rev = _rev;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAvatarIcon() {
		return avatarIcon;
	}

	public void setAvatarIcon(int avatarIcon) {
		this.avatarIcon = avatarIcon;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Statistics getStatistics() {
		return statistics;
	}

	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}

	public List<Bike> getBikesList() {
		return bikesList;
	}

	public void setBikesList(List<Bike> bikesList) {
		this.bikesList = bikesList;
	}

	public Set<String> getStagesIdsCompleted() {
		return stagesIdsCompleted;
	}

	public void setStagesIdsCompleted(Set<String> stagesIdsCompleted) {
		this.stagesIdsCompleted = stagesIdsCompleted;
	}

	public Set<String> getStagesIdsJoined() {
		return stagesIdsJoined;
	}

	public void setStagesIdsJoined(Set<String> stagesIdsJoined) {
		this.stagesIdsJoined = stagesIdsJoined;
	}	
	
}