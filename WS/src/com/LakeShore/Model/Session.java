package com.LakeShore.Model;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Created by matthewwojkowski on 11/8/16.
 */
@XmlRootElement
public class Session {
	private int id;
	private String username;
	private String firstName;
	private String authorized;
	private String type;
	
	public Session(){
		
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
	
	public String getAuthorized(){
		return authorized;
	}
	
	public void setAuthorized(String x){
		this.authorized = x;
	}
	
	public String getType(){
		return type;
	}
	public void setType(String type){
		this.type = type;
	}
	
	

}//close class
