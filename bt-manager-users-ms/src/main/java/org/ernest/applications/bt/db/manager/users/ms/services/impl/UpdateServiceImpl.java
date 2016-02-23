package org.ernest.applications.bt.db.manager.users.ms.services.impl;

import java.util.stream.Collectors;

import org.ernest.applications.bt.db.manager.users.ct.UpdateAddBikeInput;
import org.ernest.applications.bt.db.manager.users.ct.UpdateAddstageCompletedInput;
import org.ernest.applications.bt.db.manager.users.ct.UpdateDescriptionInput;
import org.ernest.applications.bt.db.manager.users.ct.UpdateJoinStageInput;
import org.ernest.applications.bt.db.manager.users.ct.UpdateNameInput;
import org.ernest.applications.bt.db.manager.users.ct.UpdateRemoveBikeInput;
import org.ernest.applications.bt.db.manager.users.ct.UpdateStatisticsInput;
import org.ernest.applications.bt.db.manager.users.ct.UpdateUnjoinStageInput;
import org.ernest.applications.bt.db.manager.users.ct.entities.User;
import org.ernest.applications.bt.db.manager.users.ct.exceptions.RetrieveUserException;
import org.ernest.applications.bt.db.manager.users.ct.exceptions.UpdateUserException;
import org.ernest.applications.bt.db.manager.users.ms.services.CrudService;
import org.ernest.applications.bt.db.manager.users.ms.services.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateServiceImpl implements UpdateService {
	
	@Autowired
	CrudService srdService;

	@Override
	public void updateName(UpdateNameInput updateNameInput) throws UpdateUserException, RetrieveUserException {
		
		User user = srdService.retrieve(updateNameInput.getUserId());
		user.setName(updateNameInput.getName());
		srdService.update(user);
	}

	@Override
	public void updateDescription(UpdateDescriptionInput updateDescriptionInput) throws UpdateUserException, RetrieveUserException {
		
		User user = srdService.retrieve(updateDescriptionInput.getUserId());
		user.setDescription(updateDescriptionInput.getDescription());
		srdService.update(user);
	}
	
	@Override
	public void updateStatistics(UpdateStatisticsInput updateStatisticsInput) throws UpdateUserException, RetrieveUserException {
		
		User user = srdService.retrieve(updateStatisticsInput.getUserId());
		user.setStatistics(updateStatisticsInput.getStatistics());
		srdService.update(user);	
	}

	@Override
	public void addBike(UpdateAddBikeInput updateAddBikeInput) throws UpdateUserException, RetrieveUserException {
		
		User user = srdService.retrieve(updateAddBikeInput.getUserId());
		user.getBikesList().add(updateAddBikeInput.getBike());
		srdService.update(user);
	}

	@Override
	public void removeBike(UpdateRemoveBikeInput updateRemoveBikeInput) throws UpdateUserException, RetrieveUserException {
		
		User user = srdService.retrieve(updateRemoveBikeInput.getUserId());
		user.setBikesList(user.getBikesList().stream()
				 .filter(bike -> !bike.getId().equals(updateRemoveBikeInput.getBikeId()))
				 .collect(Collectors.toList()));
		srdService.update(user);
	}

	@Override
	public void addStageCompleted(UpdateAddstageCompletedInput updateAddstageCompletedInput) throws UpdateUserException, RetrieveUserException {
		
		User user = srdService.retrieve(updateAddstageCompletedInput.getUserId());
		user.getStagesIdsCompleted().add(updateAddstageCompletedInput.getStageId());
		srdService.update(user);
	}

	@Override
	public void joinStage(UpdateJoinStageInput updateJoinStageInput) throws UpdateUserException, RetrieveUserException {
		
		User user = srdService.retrieve(updateJoinStageInput.getUserId());
		user.getStagesIdsJoined().add(updateJoinStageInput.getStageId());
		srdService.update(user);
	}

	@Override
	public void unjoinStage(UpdateUnjoinStageInput updateUnjoinStageInput) throws UpdateUserException, RetrieveUserException {
		
		User user = srdService.retrieve(updateUnjoinStageInput.getUserId());
		user.getStagesIdsJoined().remove(updateUnjoinStageInput.getStageId());
		srdService.update(user);
	}
}