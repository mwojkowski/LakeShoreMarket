package com.LakeShore.DAO;

import com.LakeShore.Model.Customer;

import java.sql.*;
import java.util.*;

/**
 * Created by matthewwojkowski on 11/8/16.
 */
public class CustomerDAO {
    //******MySQL DATABASE CONNECTION DETAILS*****
    private String server = "jdbc:mysql://162.218.48.24:3306/Lakeshore";
    private String username = "LakeShore";
    private String password = "284028";

    Connection connection;

    private static Set<Customer> customers = new HashSet<Customer>();

    public CustomerDAO(){

    }//close CustomerDAO underloaded constructor


    //gets all customers that are currently active.
    public Set<Customer> getAllCustomers(){
        ResultSet temp;

        try{
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(server, username, password);

            String prequery = "Select * FROM Customers where Active = 1";
            PreparedStatement query = connection.prepareStatement(prequery);

            temp = query.executeQuery();

            while(temp.next()){
                customers.add(new Customer(temp.getInt("id"), temp.getString("FirstName"), temp.getString("LastName"), temp.getString("Address"), temp.getString("Phone"), temp.getString("City"), temp.getString("State"), temp.getString("Zip"), true));
            }//close while statement


            connection.close();


        }//close try statement
        catch(Exception ex){
            ex.printStackTrace();
        }//close catch statement



        return customers;
    }//close getAllCustomers
    
    
    //adds a customer to the database using just firstName and lastName.
    //Second query runs to get the last added user, so we can get the user's id
    public Customer addCustomer(String firstName, String lastName){
    	Customer temp = new Customer();
    	
    	try{
    		Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(server, username, password);

            String prequery = "INSERT INTO Customers (FirstName, LastName) VALUES (?, ?)";
            PreparedStatement query = connection.prepareStatement(prequery);
            query.setString(1, firstName);
            query.setString(2, lastName);


            query.execute();

            connection.close();
            temp.setFirstName(firstName);
            temp.setLastName(lastName);
            

        }//close try statement
        catch(Exception ex){
            ex.printStackTrace();
            
        }//close catch
    	try{
    		ResultSet tempr;
    		
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(server, username, password);

            String prequery = "Select id FROM Customers where FirstName = ? AND LastName = ? LIMIT 1";
            PreparedStatement query = connection.prepareStatement(prequery);
            query.setString(1, firstName);
            query.setString(2, lastName);

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
    }//closeaddCustomer


    //Adds a new customer to the database
    public boolean addCustomer(Customer x){
        try{
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(server, username, password);

            String prequery = "INSERT INTO Customers (FirstName, LastName, Address, Phone, City, State, Zip) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement query = connection.prepareStatement(prequery);
            query.setString(1, x.getFirstName());
            query.setString(2, x.getLastName());
            query.setString(3, x.getAddress());
            query.setString(4, x.getPhoneNumber());
            query.setString(5, x.getCity());
            query.setString(6, x.getState());
            query.setString(7, x.getZip());


            query.execute();

            connection.close();

        }//close try statement
        catch(Exception ex){
            ex.printStackTrace();
            return false;
        }//close catch

        return true;
    }//close addCustomer()

    //gets customer information based on their ID... will return single customer object
    public Customer getCustomerById(int id){
        Customer temp = new Customer();

        try {
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
            ResultSet results = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(server, username, password);
            String prequery = "SELECT * FROM Customers WHERE id=?";
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
                temp.setActive(results.getBoolean("Active"));

            }//close while statement

            connection.close();
        }//close try statement
        catch(Exception ex){
            System.out.print(ex.getMessage());
        }//close catch

        return temp;

    }//close getCustomerById()

    /*
     * Not really a good idea. Way too many variables at once.
     * 
     * //updates a customer based off of their ID
    public void updateCustomer(Customer x){
        try{
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(server, username, password);
            String prequery = "UPDATE Customers SET FirstName = ?, LastName = ?, Address = ?, Phone = ?, City = ?, State = ?, Zip = ? WHERE id = ?";
            PreparedStatement query = connection.prepareStatement(prequery);
            query.setString(1, x.getFirstName());
            query.setString(2, x.getLastName());
            query.setString(3, x.getAddress());
            query.setString(4, x.getPhoneNumber());
            query.setString(5, x.getCity());
            query.setString(6, x.getState());
            query.setString(7, x.getZip());
            query.setInt(8, x.getID());

            query.execute();

            connection.close();

        }//close try statement
        catch(Exception ex){
            ex.printStackTrace();
        }//close catch exception


    }//close updateCustomer()*/
    
    
    //Updates a customer's address
    public boolean updateCustomerAddress(int id, String address){
    	try{
    		Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(server, username, password);
            
                String prequery = "UPDATE Customers Set Address = ? WHERE id = ?";
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
    }//close updateCustomerAddress()
    
    public boolean updatePhoneNumber(int id, String phoneNumber){
    	try{
    		Class.forName("com.mysql.jdbc.Driver").newInstance();
    		
            connection = DriverManager.getConnection(server, username, password);
            
                String prequery = "UPDATE Customers Set Phone = ? WHERE id = ?";
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
            
                String prequery = "UPDATE Customers Set City = ? WHERE id = ?";
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
            
                String prequery = "UPDATE Customers Set State = ? WHERE id = ?";
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
            
                String prequery = "UPDATE Customers Set Zip = ? WHERE id = ?";
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
    

    //Sets a customer's account to inactive. Still usable for analytics
    public boolean deleteCustomer(int id){
        try{
        	
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(server, username, password);

            String prequery = "UPDATE Customers Set Active = 0 WHERE id = ?";
            PreparedStatement query = connection.prepareStatement(prequery);
            query.setInt(1, id);

            query.execute();

            connection.close();

        }//close try statement
        catch(Exception ex){
            ex.printStackTrace();
            return false;
        }//close Exception
        
        return true;
    }//close deleteCustomer*/
    
}//close class
