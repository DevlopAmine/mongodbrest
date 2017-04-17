package com.mongodbrest.models;

import java.util.List;


public class AlertSource {

	
	private String ids;
	private String text;
	private String link;
	private List<String> oblKeywords;
	private List<String> optKeywords;
	private List<String> forbidenKeywords;
	private List<String> srcAutorises;
	private List<String> srcBloques;
	private String langue;
	
	public 	AlertSource()
	{}
	public AlertSource(String id,String txt,String l)
	{
		this.ids=id;
		this.text=txt;
		this.link=l;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "AlertSource [ids=" + ids + ", link=" + link + "]";
	}
	public List<String> getOblKeywords() {
		return oblKeywords;
	}
	public void setOblKeywords(List<String> oblKeywords) {
		this.oblKeywords = oblKeywords;
	}
	public List<String> getOptKeywords() {
		return optKeywords;
	}
	public void setOptKeywords(List<String> optKeywords) {
		this.optKeywords = optKeywords;
	}
	public List<String> getForbidenKeywords() {
		return forbidenKeywords;
	}
	public void setForbidenKeywords(List<String> forbidenKeywords) {
		this.forbidenKeywords = forbidenKeywords;
	}
	public List<String> getSrcAutorises() {
		return srcAutorises;
	}
	public void setSrcAutorises(List<String> srcAutorises) {
		this.srcAutorises = srcAutorises;
	}
	public List<String> getSrcBloques() {
		return srcBloques;
	}
	public void setSrcBloques(List<String> srcBloques) {
		this.srcBloques = srcBloques;
	}
	public String getLangue() {
		return langue;
	}
	public void setLangue(String langue) {
		this.langue = langue;
	}
	
	
	
}
