package com.LakeShore.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.HeaderParam;

import com.LakeShore.service.representation.SessionRepresentation;
import com.LakeShore.service.workflow.SessionActivity;


@Path("/Sessions/")
public class SessionResource implements SessionService {
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Login/")
    public SessionRepresentation login(@HeaderParam("Username")String username, @HeaderParam("Password")String password){
    	System.out.println("GET Request to authenticate customer with username: " + username + "........");
    	SessionActivity sessActivity = new SessionActivity();
    	
    	return sessActivity.login(username, password);
    }//close getCustomers()

}
