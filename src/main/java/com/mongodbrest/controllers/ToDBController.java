package com.mongodbrest.controllers;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import com.mongodbrest.daoservices.AlertService;
import com.mongodbrest.daoservices.InstanceService;
import com.mongodbrest.models.*;
import com.mongodbrest.repositories.*; 

/**
 * @author amine
 *
 */

@RestController
@RequestMapping("/it")
public class ToDBController {
	 private static final Logger log = LoggerFactory.getLogger(ToDBController.class);
	
	@Autowired
	  private InstanceService instServ;
	@Autowired
	  private AlertService alertServ;
	
  /**
	   * Create Instance 
	 * @param InstanceMap
	 * @return Map<String,Object>
	 */
	@RequestMapping(method = RequestMethod.POST)
	  public void createInstance(@RequestBody Map<String, Object> InstanceMap){
	    
		Instance instance = new Instance(Double.parseDouble(InstanceMap.get("instance_id").toString()),InstanceMap.get("descI").toString());
		instServ.saveInstance(instance);
		
	  }
	  
	   @RequestMapping(method = RequestMethod.GET,value="twlist")
	  public ResponseEntity<Alert> insertFromListSN(){
		
		  Alert alert = new Alert(new ObjectId(),"surf");
		  alertServ.saveTwAlert(alert);
	
	 	return new ResponseEntity<Alert>(alert, HttpStatus.CREATED);
	  }
	  
	  @RequestMapping(method = RequestMethod.DELETE,value="/{alertId}")
	  public ResponseEntity<String> deleteAlert(@PathVariable("alertId") String alertId){  
		
		alertServ.deleteAlert(alertId);
		    
		
	    return new ResponseEntity<String>("Alert deleted successfully", HttpStatus.NO_CONTENT);
	  }
	  
	 @RequestMapping(method = RequestMethod.GET,value="/{InstanceId}",produces = MediaType.APPLICATION_JSON_VALUE)
	  public @ResponseBody ResponseEntity<List<Alert>> ShowAlertsByInstance(@PathVariable("InstanceId") String InstanceId ){  
		
		 List<Alert> alerts = alertServ.findAlertsByInstanceId(new ObjectId(InstanceId));
		
		return new ResponseEntity<List<Alert>>(alerts, HttpStatus.OK);
	  }
	
	 /*
	  *  get Posts from FB and store them to MongoDB
	  * 
	  */
	 @RequestMapping(method = RequestMethod.GET,value="fbList")
	  public ResponseEntity<Alert> insertFromFBList(){
		
		 Alert a1 = new Alert(new ObjectId(),"Visit Morocco2");
	     alertServ.saveFBAlert(a1);
	     
	     return new ResponseEntity<Alert>(a1, HttpStatus.CREATED);
	  
	  }
	  
	 /*
	  *  get Posts from Google custom search and store them to MongoDB
	  * 
	  */
	 @RequestMapping(method = RequestMethod.GET,value="cseList")
	  public ResponseEntity<Alert> insertCSEList(){
		
		 Alert a1 = new Alert(new ObjectId(),"Spain alert");
	     alertServ.saveGgAlert(a1);
	     
	     return new ResponseEntity<Alert>(a1, HttpStatus.CREATED);
	  
	  }
	
	 @RequestMapping(method = RequestMethod.GET,value="t")
	  public void tstB(){
		
		 System.out.println(alertServ.issetAlert("Visit Morocco2"));
	     
	    // return new ResponseEntity<Alert>(a1, HttpStatus.CREATED);
	  
	  }
	 
	 @RequestMapping(method = RequestMethod.DELETE,value="delInst/{InstId}")
	  public ResponseEntity<String> dropAlerts(@PathVariable("InstId") String InstId){  
		instServ.removeInstance(new ObjectId(InstId));
			    
	    return new ResponseEntity<String>("Alerts deleted successfully", HttpStatus.NO_CONTENT);
	  }
}






