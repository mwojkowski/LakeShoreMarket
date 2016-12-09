package com.LakeShore.Manager;

import com.LakeShore.DAO.SessionDAO;
import com.LakeShore.Model.Session;

import java.util.*;

public class SessionManager {
	
	public static SessionDAO dao = new SessionDAO();
	
	public SessionManager(){
		
	}
	
	public Session login(String username, String password){
		return dao.getSession(username, password);
	}//close login

}//close class
