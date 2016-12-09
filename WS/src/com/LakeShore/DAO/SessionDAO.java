package com.LakeShore.DAO;

import com.LakeShore.Model.Customer;
import com.LakeShore.Model.Session;

import java.sql.*;
import java.util.*;

public class SessionDAO {
	//******MySQL DATABASE CONNECTION DETAILS*****
    private String server = "jdbc:mysql://162.218.48.24:3306/Lakeshore";
    private String username = "LakeShore";
    private String password = "284028";

    Connection connection;

	
	public SessionDAO(){
		
	}


    //gets all customers that are currently active.
    public Session getSession(String cUsername, String cPassword){
        ResultSet temp;
        Session session = new Session();

        try{
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(server, username, password);

            String prequery = "Select * FROM CustomerLogins where Username = ?";
            PreparedStatement query = connection.prepareStatement(prequery);
            query.setString(1, cUsername);

            temp = query.executeQuery();

            while(temp.next()){
                session.setID(temp.getInt("ID"));
                session.setUsername(temp.getString("Username"));
                if(cPassword.equals(temp.getString("Password"))){
                	session.setAuthorized("Authorized");
                }
                else{
                	session.setAuthorized("No");
                }
                session.setType("Customer");
            }//close while statement


            connection.close();


        }//close try statement
        catch(Exception ex){
            ex.printStackTrace();
        }//close catch statement



        return session;
    }//close getAllCustomers
    
    public boolean registerUser(int id, String username, String password){
    	
    	return true;
    }
	

}//close class
