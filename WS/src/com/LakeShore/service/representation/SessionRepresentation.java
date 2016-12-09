package com.LakeShore.service.representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@XmlRootElement(name = "Session")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="")
public class SessionRepresentation {
	private int id;
	private String username;
	private String firstName;
	private String authorized;
	private String type;
	
	public SessionRepresentation(){
		
	}
	public void setID(int x){
		this.id = x;
	}
	
	public int getID(){
		return id;
	}
	
	public void setUsername(String x){
		this.username = x;
	}
	
	public String getUsername(){
		return username;
	}
	
	public String isAuthorized(){
		return authorized;
	}
	
	public void setAuthorization(String x){
		this.authorized = x;
	}
	
	public String getType(){
		return type;
	}
	public void setType(String type){
		this.type = type;
	}
}
