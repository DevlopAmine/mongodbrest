package com.mongodbrest.daoservices;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.mongodbrest.models.Alert;
import com.mongodbrest.models.AlertSource;
import com.mongodbrest.models.Instance;
import com.mongodbrest.models.SNresult;
import com.mongodbrest.repositories.AlertRepository;

public class AlertServiceImpl implements AlertService {

	@Autowired 
	private AlertRepository alertRepo;
	@Autowired 
	MongoTemplate mongoTemplate;
	@Override
	public void saveTwAlert(Alert alert) {
		 RestTemplate restTemplate = new RestTemplate();
		  ResponseEntity<List<SNresult>> twResponse =
			        restTemplate.exchange("http://localhost:8080/svc/v1/tweets/messi",
			                    HttpMethod.GET, null, new ParameterizedTypeReference<List<SNresult>>() {
			            });
			List<SNresult> tweetL = twResponse.getBody();
			List<AlertSource> list = new ArrayList<AlertSource>();
			
			for (SNresult sNresult : tweetL) {
				System.out.println(sNresult.getText());
				
				 list.add(new AlertSource(sNresult.getIdR(),sNresult.getText(),sNresult.getUrl()));
			}
	      Instance i = new Instance();
		  i.setId(new ObjectId("58ecbbba3aefb11910025e16"));
	 
	    
		  alert.setInstance(i);
		  alert.setAlertsources(list);
	    alertRepo.save(alert);
		
	}

	@Override
	public void deleteAlert(String alertId) {
		alertRepo.delete(alertId);
		
	}

	@Override
	public List<Alert> findAlertsByInstanceId(ObjectId oId) {
		List<Alert> listA =  mongoTemplate.find(query(where("instance.$id").is(oId)),Alert.class);
		for (Alert a : listA) {
			System.out.println(a.getDescA() +"  "+a.getId());
			
		}
		return listA;
	}

	@Override
	public void saveFBAlert(Alert alert) {
		RestTemplate restTemplate = new RestTemplate();
		  ResponseEntity<List<SNresult>> FbResponse =
			        restTemplate.exchange("http://localhost:8080/svc/v1/fb/lower",
			                    HttpMethod.GET, null, new ParameterizedTypeReference<List<SNresult>>() {
			            });
			List<SNresult> fbL = FbResponse.getBody();
			List<AlertSource> list = new ArrayList<AlertSource>();
			
			for (SNresult sNresult : fbL) {
				System.out.println(sNresult.getText());
				
				 list.add(new AlertSource(sNresult.getIdR(),sNresult.getText(),sNresult.getUrl()));
			}
			
	      
	      Instance i = new Instance();
		  i.setId(new ObjectId("58eca4a13aefb10b44edfd25"));
	 
	    
		alert.setInstance(i);
		alert.setAlertsources(list);
	    alertRepo.save(alert);
		
	}

}
