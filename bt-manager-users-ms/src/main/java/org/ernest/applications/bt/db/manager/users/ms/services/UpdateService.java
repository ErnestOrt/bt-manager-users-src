package org.ernest.applications.bt.db.manager.users.ms.services;

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

public interface UpdateService {

	void updateName(UpdateNameInput updateNameInput) throws UpdateUserException, RetrieveUserException;

	void updateDescription(UpdateDescriptionInput updateDescriptionInput) throws UpdateUserException, RetrieveUserException;

	void addBike(UpdateAddBikeInput updateAddBikeInput) throws UpdateUserException, RetrieveUserException;

	void removeBike(UpdateRemoveBikeInput updateRemoveBikeInput) throws UpdateUserException, RetrieveUserException;

	void addStageCompleted(UpdateAddstageCompletedInput updateAddstageCompletedInput) throws UpdateUserException, RetrieveUserException;

	void joinStage(UpdateJoinStageInput updateJoinStageInput) throws UpdateUserException, RetrieveUserException;

	void unjoinStage(UpdateUnjoinStageInput updateUnjoinStageInput) throws UpdateUserException, RetrieveUserException;

	void updateStatistics(UpdateStatisticsInput updateStatisticsInput) throws UpdateUserException, RetrieveUserException;

}
