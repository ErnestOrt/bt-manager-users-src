package org.ernest.applications.bt.db.manager.users.ms.services.impl;

import java.util.UUID;

import org.ernest.applications.bt.db.manager.users.ct.entities.User;
import org.ernest.applications.bt.db.manager.users.ct.exceptions.CreateUserException;
import org.ernest.applications.bt.db.manager.users.ct.exceptions.DeleteUserException;
import org.ernest.applications.bt.db.manager.users.ct.exceptions.RetrieveUserException;
import org.ernest.applications.bt.db.manager.users.ct.exceptions.UpdateUserException;
import org.ernest.applications.bt.db.manager.users.ms.services.CrudService;
import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CrudServiceImpl implements CrudService{
	
	@Value("${db.name}")
	private String dbName;
	
	@Value("${db.host}")
	private String dbHost;

	@Override
	public String create() throws CreateUserException {
		
		User user = new User();
		user.set_id(UUID.randomUUID().toString());
		try{
			CouchDbClient dbClient = new CouchDbClient(buildCouchDbProperties());
			dbClient.save(user);
			dbClient.shutdown();
		
			return user.get_id();
			
		}catch(Exception e){
			e.printStackTrace();
			throw new CreateUserException(e.getMessage());
		}
	}

	@Override
	public User retrieve(String userId) throws RetrieveUserException {
		
		try{
			CouchDbClient dbClient = new CouchDbClient(buildCouchDbProperties());
			User user = dbClient.find(User.class, userId);
			dbClient.shutdown();
			
			return user;
			
		}catch(Exception e){
			e.printStackTrace();
			throw new RetrieveUserException(e.getMessage());
		}
		
	}

	@Override
	public void delete(String userId) throws DeleteUserException {
		try{
			CouchDbClient dbClient = new CouchDbClient(buildCouchDbProperties());
			User user = dbClient.find(User.class, userId);
			dbClient.remove(user);
			dbClient.shutdown();
		}catch(Exception e){
			e.printStackTrace();
			throw new DeleteUserException(e.getMessage());
		}
	}

	@Override
	public void update(User user) throws UpdateUserException {
		try{
			CouchDbClient dbClient = new CouchDbClient(buildCouchDbProperties());
			dbClient.update(user);
			dbClient.shutdown();
		}catch(Exception e){
			e.printStackTrace();
			throw new UpdateUserException(e.getMessage());
		}
	}
	
	private CouchDbProperties buildCouchDbProperties() {
		CouchDbProperties properties = new CouchDbProperties();
		properties.setDbName(dbName);
		properties.setHost(dbHost);
		properties.setPort(5984);
		properties.setCreateDbIfNotExist(true);
		properties.setProtocol("http");
		return properties;
	}

}
