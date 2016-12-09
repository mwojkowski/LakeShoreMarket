package com.LakeShore.service.workflow;

import com.LakeShore.Manager.CustomerManager;
import com.LakeShore.Manager.SessionManager;
import com.LakeShore.service.representation.SessionRepresentation;

import com.LakeShore.Model.Session;

public class SessionActivity {
	private static SessionManager sManager = new SessionManager();
	
	
	public SessionActivity(){
	
	}//underloaded constructor
	
	public SessionRepresentation login(String username, String password){
		Session temp = sManager.login(username, password);
		
		SessionRepresentation tempRep = new SessionRepresentation();
		
		tempRep.setID(temp.getID());
		tempRep.setUsername(temp.getUsername());
		tempRep.setAuthorization(temp.getAuthorized());
		tempRep.setType(temp.getType());
		
		return tempRep;
	}//close login
	
	

}//close SessionActivity()
