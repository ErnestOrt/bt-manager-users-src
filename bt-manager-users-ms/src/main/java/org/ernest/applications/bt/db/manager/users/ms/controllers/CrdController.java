package org.ernest.applications.bt.db.manager.users.ms.controllers;

import org.ernest.applications.bt.db.manager.users.ct.entities.User;
import org.ernest.applications.bt.db.manager.users.ct.exceptions.CreateUserException;
import org.ernest.applications.bt.db.manager.users.ct.exceptions.DeleteUserException;
import org.ernest.applications.bt.db.manager.users.ct.exceptions.RetrieveUserException;
import org.ernest.applications.bt.db.manager.users.ms.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrdController {

	@Autowired
	CrudService crudService;
	
	@RequestMapping(path = "/create/{userId}", method = RequestMethod.GET)
	public void create(@PathVariable("userId") String userId) throws CreateUserException {
		crudService.create(userId);
	}
	
	@RequestMapping(path = "/retrieve/{userId}", method = RequestMethod.GET)
	public User retrieve(@PathVariable("userId") String userId) throws RetrieveUserException {
		return crudService.retrieve(userId);
	}
	
	@RequestMapping(path = "/delete/{userId}", method = RequestMethod.GET)
	public void delete(@PathVariable("userId") String userId) throws DeleteUserException {
		crudService.delete(userId);
	}
}