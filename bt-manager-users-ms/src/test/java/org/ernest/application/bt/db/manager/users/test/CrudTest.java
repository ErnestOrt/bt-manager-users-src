package org.ernest.application.bt.db.manager.users.test;

import java.util.UUID;

import org.ernest.applications.bt.db.manager.users.ct.UpdateAddBikeInput;
import org.ernest.applications.bt.db.manager.users.ct.UpdateAddstageCompletedInput;
import org.ernest.applications.bt.db.manager.users.ct.UpdateDescriptionInput;
import org.ernest.applications.bt.db.manager.users.ct.UpdateJoinStageInput;
import org.ernest.applications.bt.db.manager.users.ct.UpdateNameInput;
import org.ernest.applications.bt.db.manager.users.ct.UpdateRemoveBikeInput;
import org.ernest.applications.bt.db.manager.users.ct.UpdateStatisticsInput;
import org.ernest.applications.bt.db.manager.users.ct.UpdateUnjoinStageInput;
import org.ernest.applications.bt.db.manager.users.ct.entities.Bike;
import org.ernest.applications.bt.db.manager.users.ct.entities.Statistics;
import org.ernest.applications.bt.db.manager.users.ct.entities.User;
import org.ernest.applications.bt.db.manager.users.ms.Application;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest({"server.port=0"})
public class CrudTest {
	
	@Value("${local.server.port}")
	String port;
	
	String userIdCreated;
	
	@Before
	public void setUp(){
		userIdCreated = new RestTemplate().getForObject("http://localhost:"+port+"/create", String.class);
		Assert.assertEquals(userIdCreated, new RestTemplate().getForObject("http://localhost:"+port+"/retrieve/"+userIdCreated, User.class).get_id());
	}
	
	@After
	public void cleanUp(){
		new RestTemplate().getForObject("http://localhost:"+port+"/delete/"+userIdCreated, String.class);
		userIdCreated = null;
	}
	
	@Test
	public void updateUserName(){
		UpdateNameInput updateNameInput = new UpdateNameInput();
		updateNameInput.setUserId(userIdCreated);
		updateNameInput.setName("New Name");
		
		new RestTemplate().postForObject("http://localhost:"+port+"/update/name", updateNameInput, String.class);
		Assert.assertEquals(updateNameInput.getName(), new RestTemplate().getForObject("http://localhost:"+port+"/retrieve/"+userIdCreated, User.class).getName());
		
	}
	
	@Test
	public void updateUserDescription(){
		UpdateDescriptionInput updateDescriptionInput = new UpdateDescriptionInput();
		updateDescriptionInput.setUserId(userIdCreated);
		updateDescriptionInput.setDescription("New Description");
		
		new RestTemplate().postForObject("http://localhost:"+port+"/update/description", updateDescriptionInput, String.class);
		Assert.assertEquals(updateDescriptionInput.getDescription(), new RestTemplate().getForObject("http://localhost:"+port+"/retrieve/"+userIdCreated, User.class).getDescription());
	}
	
	@Test
	public void updateUserStatistics(){
		UpdateStatisticsInput updateStatisticsInput = new UpdateStatisticsInput();
		updateStatisticsInput.setUserId(userIdCreated);
		Statistics statistics = new Statistics();
		statistics.setBtt(4);
		statistics.setFlat(6);
		statistics.setMontain(7);
		statistics.setResistence(4);
		statistics.setRoad(8);
		statistics.setSprint(3);
		updateStatisticsInput.setStatistics(statistics);
		
		new RestTemplate().postForObject("http://localhost:"+port+"/update/statistics", updateStatisticsInput, String.class);
		Assert.assertEquals(updateStatisticsInput.getStatistics().getMontain(), new RestTemplate().getForObject("http://localhost:"+port+"/retrieve/"+userIdCreated, User.class).getStatistics().getMontain());
	}
	
	@Test
	public void updateUserBike(){
		UpdateAddBikeInput updateAddBikeInput = new UpdateAddBikeInput();
		updateAddBikeInput.setUserId(userIdCreated);
		Bike bike = new Bike();
		bike.setName("Bike Name");
		bike.setId(UUID.randomUUID().toString());
		updateAddBikeInput.setBike(bike);
		
		new RestTemplate().postForObject("http://localhost:"+port+"/update/addbike", updateAddBikeInput, String.class);
		Assert.assertEquals(bike.getId(), new RestTemplate().getForObject("http://localhost:"+port+"/retrieve/"+userIdCreated, User.class).getBikesList().get(0).getId());
		
		UpdateRemoveBikeInput updateRemoveBikeInput = new UpdateRemoveBikeInput();
		updateRemoveBikeInput.setUserId(userIdCreated);
		updateRemoveBikeInput.setBikeId(bike.getId());
		
		new RestTemplate().postForObject("http://localhost:"+port+"/update/removebike", updateRemoveBikeInput, String.class);
		Assert.assertEquals(0, new RestTemplate().getForObject("http://localhost:"+port+"/retrieve/"+userIdCreated, User.class).getBikesList().size());
	}
	
	@Test
	public void updateStageCompleted(){
		UpdateAddstageCompletedInput updateAddstageCompletedInput = new UpdateAddstageCompletedInput();
		updateAddstageCompletedInput.setUserId(userIdCreated);
		updateAddstageCompletedInput.setStageId(UUID.randomUUID().toString());
		
		new RestTemplate().postForObject("http://localhost:"+port+"/update/addstagecompleted", updateAddstageCompletedInput, String.class);
		Assert.assertTrue(new RestTemplate().getForObject("http://localhost:"+port+"/retrieve/"+userIdCreated, User.class).getStagesIdsCompleted().contains(updateAddstageCompletedInput.getStageId()));
		
	}
	
	@Test
	public void updateStage(){
		UpdateJoinStageInput updateJoinStageInput = new UpdateJoinStageInput();
		updateJoinStageInput.setUserId(userIdCreated);
		updateJoinStageInput.setStageId(UUID.randomUUID().toString());
		
		new RestTemplate().postForObject("http://localhost:"+port+"/update/joinstage", updateJoinStageInput, String.class);
		Assert.assertTrue(new RestTemplate().getForObject("http://localhost:"+port+"/retrieve/"+userIdCreated, User.class).getStagesIdsJoined().contains(updateJoinStageInput.getStageId()));
		
		UpdateUnjoinStageInput updateUnjoinStageInput = new UpdateUnjoinStageInput();
		updateUnjoinStageInput.setUserId(userIdCreated);
		updateUnjoinStageInput.setStageId(UUID.randomUUID().toString());
		
		new RestTemplate().postForObject("http://localhost:"+port+"/update/unjoinstage", updateUnjoinStageInput, String.class);
		Assert.assertTrue(!new RestTemplate().getForObject("http://localhost:"+port+"/retrieve/"+userIdCreated, User.class).getStagesIdsJoined().contains(updateUnjoinStageInput.getStageId()));
	}
}