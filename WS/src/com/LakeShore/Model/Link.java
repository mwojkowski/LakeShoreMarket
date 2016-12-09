package com.LakeShore.Model;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="Link")
public class Link {
	private String name;
	private String action;
	private String rel;
	private String href;
	private String mediaType;
	
	public Link(){
		
	}//underloaded constructor
	
	public Link(String name, String action, String rel, String href){
		
	}//close overloaded constructor
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public String getAction(){
		return action;
	}//close getAction
	
	public void setAction(String action){
		this.action = action;
	}//close setAction
	
	public String getURL(){
		return rel;
	}//close getURL
	
	public void setURL(String rel){
		this.rel = rel;
	}//close setURL
	
	public void setHREF(String href){
		this.href = href;
	}
	public String getHREF(){
		return href;
	}
	

}
