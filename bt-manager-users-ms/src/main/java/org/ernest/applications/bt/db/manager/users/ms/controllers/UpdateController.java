package org.ernest.applications.bt.db.manager.users.ms.controllers;

import org.ernest.applications.bt.db.manager.users.ct.UpdateAddBikeInput;
import org.ernest.applications.bt.db.manager.users.ct.UpdateAddstageCompletedInput;
import org.ernest.applications.bt.db.manager.users.ct.UpdateDescriptionInput;
import org.ernest.applications.bt.db.manager.users.ct.UpdateJoinStageInput;
import org.ernest.applications.bt.db.manager.users.ct.UpdateNameInput;
import org.ernest.applications.bt.db.manager.users.ct.UpdateRemoveBikeInput;
import org.ernest.applications.bt.db.manager.users.ct.UpdateStatisticsInput;
import org.ernest.applications.bt.db.manager.users.ct.UpdateUnjoinStageInput;
import org.ernest.applications.bt.db.manager.users.ct.exceptions.RetrieveUserException;
import org.ernest.applications.bt.db.manager.users.ct.exceptions.UpdateUserException;
import org.ernest.applications.bt.db.manager.users.ms.services.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateController {
	
	@Autowired
	UpdateService updateService;
	
	@RequestMapping("/update/name")
	public void updateName(@RequestBody UpdateNameInput updateNameInput) throws UpdateUserException, RetrieveUserException {
		updateService.updateName(updateNameInput);
	}
	
	@RequestMapping("/update/description")
	public void updateName(@RequestBody UpdateDescriptionInput updateDescriptionInput) throws UpdateUserException, RetrieveUserException {
		updateService.updateDescription(updateDescriptionInput);
	}
	
	@RequestMapping("/update/statistics")
	public void updateStatistics(@RequestBody UpdateStatisticsInput updateStatisticsInput) throws UpdateUserException, RetrieveUserException {
		updateService.updateStatistics(updateStatisticsInput);
	}
	
	@RequestMapping("/update/addbike")
	public void addBike(@RequestBody UpdateAddBikeInput updateAddBikeInput) throws UpdateUserException, RetrieveUserException {
		updateService.addBike(updateAddBikeInput);
	}
	
	@RequestMapping("/update/removebike")
	public void removeBike(@RequestBody UpdateRemoveBikeInput updateRemoveBikeInput) throws UpdateUserException, RetrieveUserException {
		updateService.removeBike(updateRemoveBikeInput);
	}
	
	@RequestMapping("/update/addstagecompleted")
	public void addStageCompleted(@RequestBody UpdateAddstageCompletedInput updateAddstageCompletedInput) throws UpdateUserException, RetrieveUserException {
		updateService.addStageCompleted(updateAddstageCompletedInput);
	}
	
	@RequestMapping("/update/joinstage")
	public void joinStage(@RequestBody UpdateJoinStageInput updateJoinStageInput) throws UpdateUserException, RetrieveUserException {
		updateService.joinStage(updateJoinStageInput);
	}
	
	@RequestMapping("/update/unjoinstage")
	public void unjoinStage(@RequestBody UpdateUnjoinStageInput updateUnjoinStageInput) throws UpdateUserException, RetrieveUserException {
		updateService.unjoinStage(updateUnjoinStageInput);
	}
	
	
}