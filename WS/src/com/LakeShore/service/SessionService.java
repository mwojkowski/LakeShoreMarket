package com.LakeShore.service;

import com.LakeShore.service.representation.SessionRepresentation;

import javax.jws.WebService;



public interface SessionService {
	
	public SessionRepresentation login(String username, String password);

}
