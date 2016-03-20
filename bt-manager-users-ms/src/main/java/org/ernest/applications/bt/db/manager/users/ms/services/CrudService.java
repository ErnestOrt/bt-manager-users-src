package org.ernest.applications.bt.db.manager.users.ms.services;

import org.ernest.applications.bt.db.manager.users.ct.entities.User;
import org.ernest.applications.bt.db.manager.users.ct.exceptions.CreateUserException;
import org.ernest.applications.bt.db.manager.users.ct.exceptions.DeleteUserException;
import org.ernest.applications.bt.db.manager.users.ct.exceptions.RetrieveUserException;
import org.ernest.applications.bt.db.manager.users.ct.exceptions.UpdateUserException;

public interface CrudService {

	void create(String userId) throws CreateUserException;
	void update(User user) throws UpdateUserException;
	User retrieve(String userId) throws RetrieveUserException;
	void delete(String userId) throws DeleteUserException;
	
}
