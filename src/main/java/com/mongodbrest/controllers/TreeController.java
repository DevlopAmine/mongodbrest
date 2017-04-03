package com.mongodbrest.controllers;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongodbrest.models.*;
import com.mongodbrest.repositories.*; 

@RestController
@RequestMapping("/tree")
public class TreeController {
	@Autowired
	  private Repository treeRepository;

	  @RequestMapping(method = RequestMethod.POST)
	  public Map<String, Object> createTree(@RequestBody Map<String, Object> treeMap){
	    
		Tree tree = new Tree(treeMap.get("id").toString(), treeMap.get("name").toString(),
				  Integer.parseInt(treeMap.get("age").toString()));
		 treeRepository.saveTree(tree);
		  
		  
	    Map<String, Object> response = new LinkedHashMap<String, Object>();
	    response.put("message", "Tree created successfully");
	    response.put("Tree", tree);
	    return response;
	  }

	  @RequestMapping(method = RequestMethod.GET, value="/{treeId}")
	  public Tree getBookDetails(@PathVariable("treeId") String treeId){
	    return treeRepository.getTree(treeId);
	  }
	  
	  @RequestMapping(method = RequestMethod.PUT,value="/{treeId}")
	  public Map<String, Object> updateTree(@RequestBody Map<String, Object> treeMap,@PathVariable("treeId") String treeId){  
		Tree tree = new Tree(treeId, treeMap.get("name").toString(),
				  Integer.parseInt(treeMap.get("age").toString()));
		
		treeRepository.updateT(treeId, tree.getName(),tree.getAge());
		    
	    Map<String, Object> response = new LinkedHashMap<String, Object>();
	    response.put("message", "Tree updated successfully");
	    response.put("Tree",tree);
	    return response;
	  }
	  
	  @RequestMapping(method = RequestMethod.DELETE,value="/{treeId}")
	  public Map<String, Object> deleteTree(@PathVariable("treeId") String treeId){  
		
		treeRepository.deleteTree(treeId);
		    
	    Map<String, Object> response = new LinkedHashMap<String, Object>();
	    response.put("message", "Tree deleted successfully");
	   
	    return response;
	  }
	  
	  @RequestMapping(method = RequestMethod.GET,value="/all")
	  public Map<String, Object> getAllTrees(){
	    List<Tree> trees = treeRepository.getAllTrees();
	    
	    Map<String, Object> response = new LinkedHashMap<String, Object>();
	    response.put("totalTrees", trees.size());
	    response.put("trees", trees);
	    return response;
	  }
	  
	  @RequestMapping(method = RequestMethod.POST,value="embed")
	  public Map<String, Object> insertEmbed(@RequestBody Map<String, Object> treeMap){
	    List<String> tab = new ArrayList<>();tab.add("form1");tab.add("form2");
		
	    Tree tree = new Tree(treeMap.get("id").toString(), treeMap.get("name").toString(),
				  Integer.parseInt(treeMap.get("age").toString()));
		tree.setFormList(tab);
		 treeRepository.saveTree(tree);
		  
		  
	    Map<String, Object> response = new LinkedHashMap<String, Object>();
	    response.put("message", "Tree created successfully");
	    response.put("Tree", tree);
	    return response;
	  }
	  
	  @RequestMapping(method = RequestMethod.POST,value="reference")
	  public Map<String, Object> insertReference(@RequestBody Map<String, Object> treeMap){
	    List<String> tab = new ArrayList<>();tab.add("20 m");tab.add("30 m");
		
	    Tree tree = new Tree(treeMap.get("id").toString(), treeMap.get("name").toString(),
				  Integer.parseInt(treeMap.get("age").toString()));
		tree.setHeightL(tab);
		 treeRepository.saveTree(tree);
		  
		  
	    Map<String, Object> response = new LinkedHashMap<String, Object>();
	    response.put("message", "Tree created successfully");
	    response.put("Tree", tree);
	    return response;
	  }
	
}






