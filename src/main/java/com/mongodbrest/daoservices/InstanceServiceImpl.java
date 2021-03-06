package com.mongodbrest.daoservices;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodbrest.models.Alert;
import com.mongodbrest.models.Instance;
import com.mongodbrest.repositories.InstanceRepository;

public class InstanceServiceImpl implements InstanceService{

	@Autowired
	  private InstanceRepository instanceRepository;
	@Autowired
	  private AlertService alertServ;
	@Autowired 
	MongoTemplate mongoTemplate;
	@Override
	public void saveInstance(Map<String, Object> InstanceMap) {
		
		Instance instance = new Instance(Double.parseDouble(InstanceMap.get("instance_id").toString()),InstanceMap.get("descI").toString());
		instance.setCustomer_id(new ObjectId(InstanceMap.get("customer_id").toString()));
		instanceRepository.save(instance);
		
	}
	
	
	/* (non-Javadoc)
	 * 
	 Remove Instance and then delete all alerts related to it 
	 */
	@Override
	public void removeInstance(ObjectId idI) {
		List <Alert> alertsRemoved = alertServ.findAlertsByInstanceId(idI);
		instanceRepository.delete(idI.toString());

		
		for (Alert alert : alertsRemoved) {
			alertServ.deleteAlert(alert.getId().toString());
		}
	}
	
	@Override
	public ObjectId  findInstanceId(String descI) {
		
		 Instance instance = mongoTemplate.findOne(query(where("descI").is(descI)),Instance.class,"instance");
		 System.err.println(instance.getId());
		 return instance.getId();
		
	}

	/* (non-Javadoc)
	 * 
	Find all instances By customer_id (FK)
	 */
	@Override
	public List<Instance> findInstancesByCustomerId(ObjectId oId) {
		List<Instance> listI =  mongoTemplate.find(query(where("customer_id").is(oId)),Instance.class,"instance");
		for (Instance i : listI) {
			System.out.println(i.getDescI() +"  "+i.getId());
			
		}
		return listI;
		
	}

}
