package com.mongodbrest.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.services.customsearch.model.*;
import com.mongodbrest.models.SNresult;
import com.mongodbrest.services.GoogleService;



@RestController
@RequestMapping(GoogleController.Google_BASE_URI)
public class GoogleController {

	public static final String Google_BASE_URI ="customse";

	@Autowired
	private GoogleService gService;
	

	@RequestMapping(value="/data", produces = MediaType.APPLICATION_JSON_UTF8_VALUE,method= RequestMethod.GET)
	public List<SNresult> getData()
	{
		List<Result> resL= gService.searchedResults("").subList(0, 3);//(x,y is exclusive)
		List<SNresult> gGlist = new ArrayList<>();
		
		for (Result result : resL) {
			gGlist.add(new SNresult(result.getCacheId(), result.getTitle(), result.getLink()));
		}
		return gGlist;
		
	}
	
	@RequestMapping(value="/exclu", produces = MediaType.APPLICATION_JSON_UTF8_VALUE,method= RequestMethod.GET)
	public List<Result> getExcluTerm()
	{
		return gService.searchedResults("b");
		
	}
	
	@RequestMapping(value="/dateRestrict", produces = MediaType.APPLICATION_JSON_UTF8_VALUE,method= RequestMethod.GET)
	public List<Result> getDateRst()
	{
		return gService.searchedResults("c");
		
	}
}




	
	