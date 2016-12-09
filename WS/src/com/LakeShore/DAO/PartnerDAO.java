package com.LakeShore.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

import com.LakeShore.Model.Partner;




public class PartnerDAO {
	 //******MySQL DATABASE CONNECTION DETAILS*****
    private String server = "jdbc:mysql://162.218.48.24:3306/Lakeshore";
    private String username = "LakeShore";
    private String password = "284028";

    Connection connection;

    private static Set<Partner> partners = new HashSet<Partner>();

    public PartnerDAO(){

    }//close PartnerDAO underloaded constructor


    //gets all partners.
    public Set<Partner> getAllPartners(){
        ResultSet temp;

        try{
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(server, username, password);

            String prequery = "Select * FROM Partners";
            PreparedStatement query = connection.prepareStatement(prequery);

            temp = query.executeQuery();

            while(temp.next()){
            	partners.add(new Partner(temp.getInt("id"), temp.getString("FirstName"), temp.getString("LastName"), 
                		temp.getString("Address"), temp.getString("Phone"), temp.getString("City"), temp.getString("State"), 
                		temp.getString("Zip"), temp.getString("Company")));
            }//close while statement


            connection.close();


        }//close try statement
        catch(Exception ex){
            ex.printStackTrace();
        }//close catch statement



        return partners;
    }//close getAllPartners
    
    
    //adds a partner to the database using just firstName, lastName, and Company.
    //Second query runs to get the last added user, so we can get the user's id
    public Partner addPartner(String firstName, String lastName, String company){
    	Partner temp = new Partner();
    	
    	try{
    		Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(server, username, password);

            String prequery = "INSERT INTO Partners (FirstName, LastName, Company) VALUES (?, ?, ?)";
            PreparedStatement query = connection.prepareStatement(prequery);
            query.setString(1, firstName);
            query.setString(2, lastName);
            query.setString(3, company);


            query.execute();

            connection.close();
            temp.setFirstName(firstName);
            temp.setLastName(lastName);
            temp.setCompany(company);
            

        }//close try statement
        catch(Exception ex){
            ex.printStackTrace();
            
        }//close catch
    	try{
    		ResultSet tempr;
    		
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(server, username, password);

            String prequery = "Select id FROM Partners where FirstName = ? AND LastName = ? AND Company = ? LIMIT 1";
            PreparedStatement query = connection.prepareStatement(prequery);
            query.setString(1, firstName);
            query.setString(2, lastName);
            query.setString(3, company);

            tempr = query.executeQuery();

            while(tempr.next()){
                temp.setID(tempr.getInt("id"));
            }//close while statement


            connection.close();


        }//close try statement
        catch(Exception ex){
            ex.printStackTrace();
        }//close catch statement
    	return temp;
    }//close addPartner


    //gets partner information based on their ID... will return single partner object
    public Partner getPartnerById(int id){
        Partner temp = new Partner();

        try {
            ResultSet results = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(server, username, password);
            String prequery = "SELECT * FROM Partners WHERE id = ?";
            PreparedStatement query = connection.prepareStatement(prequery);
            query.setInt(1, id);

            results = query.executeQuery();

            while(results.next()){
                temp.setID(results.getInt("id"));
                temp.setFirstName(results.getString("FirstName"));
                temp.setLastName(results.getString("LastName"));
                temp.setAddress(results.getString("Address"));
                temp.setPhoneNumber(results.getString("Phone"));
                temp.setCity(results.getString("City"));
                temp.setState(results.getString("State"));
                temp.setZip(results.getString("Zip"));
                temp.setCompany(results.getString("Company"));

            }//close while statement

            connection.close();
        }//close try statement
        catch(Exception ex){
            System.out.print(ex.getMessage());
        }//close catch

        return temp;

    }//close getPartnerById()
    
    //Updates a partners's address
    public boolean updatePartnerAddress(int id, String address){
    	try{
    		Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(server, username, password);
            
                String prequery = "UPDATE Partners Set Address = ? WHERE id = ?";
                PreparedStatement query = connection.prepareStatement(prequery);
                query.setString(1, address);
                query.setInt(2, id);
                
                
                query.execute();

                connection.close();

            }//close try statement
            catch(Exception ex){
                ex.printStackTrace();
                return false;
            }//close Exception
    	return true;

    }//close updatePartnerAddress()
    
    public boolean updatePhoneNumber(int id, String phoneNumber){
    	try{
    		Class.forName("com.mysql.jdbc.Driver").newInstance();
    		
            connection = DriverManager.getConnection(server, username, password);
            
                String prequery = "UPDATE Partners Set Phone = ? WHERE id = ?";
                PreparedStatement query = connection.prepareStatement(prequery);
                query.setString(1, phoneNumber);
                query.setInt(2, id);
                
                
                query.execute();

                connection.close();

            }//close try statement
            catch(Exception ex){
                ex.printStackTrace();
                return false;
            }//close Exception
    	return true;
    }//close updatePhoneNumber
    
    public boolean updateCity(int id, String city){
    	try{
    		Class.forName("com.mysql.jdbc.Driver").newInstance();
    		
            connection = DriverManager.getConnection(server, username, password);
            
                String prequery = "UPDATE Partners Set City = ? WHERE id = ?";
                PreparedStatement query = connection.prepareStatement(prequery);
                query.setString(1, city);
                query.setInt(2, id);
                
                
                query.execute();

                connection.close();

            }//close try statement
            catch(Exception ex){
                ex.printStackTrace();
                return false;
            }//close Exception
    	return true;
    }//close updatePhoneNumber
    
    public boolean updateState(int id, String state){
    	try{
    		Class.forName("com.mysql.jdbc.Driver").newInstance();
    		
            connection = DriverManager.getConnection(server, username, password);
            
                String prequery = "UPDATE Partners Set State = ? WHERE id = ?";
                PreparedStatement query = connection.prepareStatement(prequery);
                query.setString(1, state);
                query.setInt(2, id);
                
                
                query.execute();

                connection.close();

            }//close try statement
            catch(Exception ex){
                ex.printStackTrace();
                return false;
            }//close Exception
    	return true;
    }//close updateState
    
    public boolean updateZip(int id, String zip){
    	try{
    		Class.forName("com.mysql.jdbc.Driver").newInstance();
    		
            connection = DriverManager.getConnection(server, username, password);
            
                String prequery = "UPDATE Partners Set Zip = ? WHERE id = ?";
                PreparedStatement query = connection.prepareStatement(prequery);
                query.setString(1, zip);
                query.setInt(2, id);
                
                query.execute();

                connection.close();

            }//close try statement
            catch(Exception ex){
                ex.printStackTrace();
                return false;
            }//close Exception
    	return true;
    }//close updateZip()
    
    
    


}
