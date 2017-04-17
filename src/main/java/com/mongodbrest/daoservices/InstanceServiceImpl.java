package com.mongodbrest.daoservices;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import com.mongodbrest.models.Alert;
import com.mongodbrest.models.Instance;
import com.mongodbrest.repositories.InstanceRepository;

public class InstanceServiceImpl implements InstanceService{

	@Autowired
	  private InstanceRepository instanceRepository;
	@Autowired
	  private AlertService alertServ;
	@Override
	public void saveInstance(Instance instance) {
		instanceRepository.save(instance);
		
	}
	
	
	/* (non-Javadoc)
	 * @see com.mongodbrest.daoservices.InstanceService#removeInstance(org.bson.types.ObjectId)
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

}
