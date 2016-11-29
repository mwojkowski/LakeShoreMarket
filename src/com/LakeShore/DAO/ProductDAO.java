package com.LakeShore.DAO;

import com.LakeShore.Model.Product;

import java.sql.*;
import java.util.*;

public class ProductDAO {
	
	//******MySQL DATABASE CONNECTION DETAILS*****
    private String server = "jdbc:mysql://162.218.48.24:3306/Lakeshore";
    private String username = "LakeShore";
    private String password = "284028";

    Connection connection;

    private static Set<Product> products = new HashSet<Product>();

    public ProductDAO(){

    }//close CustomerDAO underloaded constructor


    //gets all customers that are currently active.
    public Set<Product> getAllProducts(){
        ResultSet temp;

        try{
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(server, username, password);

            String prequery = "Select * FROM Products";
            PreparedStatement query = connection.prepareStatement(prequery);

            temp = query.executeQuery();

            while(temp.next()){
                products.add(new Product(temp.getInt("id"), temp.getString("Name"), temp.getString("Description")));
                
            }//close while statement


            connection.close();


        }//close try statement
        catch(Exception ex){
            ex.printStackTrace();
        }//close catch statement



        return products;
    }//close getAllCustomers
    
    
    //adds a customer to the database using just firstName and lastName.
    //Second query runs to get the last added user, so we can get the user's id
    public Product addProduct(String name, String description, int sellerID){
    	Product temp = new Product();
    	
    	try{
    		Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(server, username, password);

            String prequery = "INSERT INTO Products (Name, Description, SellerID) VALUES (?, ?, ?)";
            PreparedStatement query = connection.prepareStatement(prequery);
            query.setString(1, name);
            query.setString(2, description);
            query.setInt(3, sellerID);


            query.execute();

            connection.close();
            temp.setName(name);
            temp.setDescription(description);
            

        }//close try statement
        catch(Exception ex){
            ex.printStackTrace();
            
        }//close catch
    	try{
    		ResultSet tempr;
    		
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(server, username, password);

            String prequery = "Select id FROM Products where Name = ? AND Description = ? LIMIT 1";
            PreparedStatement query = connection.prepareStatement(prequery);
            query.setString(1, name);
            query.setString(2, description);

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


    

    //gets customer information based on their ID... will return single customer object
    public Product getProductById(int id){
        Product temp = new Product();

        try {
            ResultSet results = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(server, username, password);
            String prequery = "SELECT * FROM Products WHERE id=?";
            PreparedStatement query = connection.prepareStatement(prequery);
            query.setInt(1, id);

            results = query.executeQuery();

            while(results.next()){
                temp.setID(results.getInt("id"));
                temp.setName(results.getString("Name"));
                temp.setDescription(results.getString("Description"));

            }//close while statement

            connection.close();
        }//close try statement
        catch(Exception ex){
            System.out.print(ex.getMessage());
        }//close catch

        return temp;

    }//close getProductById()
    
    
    
    public Product getProductByName(String name){
        Product temp = new Product();

        try {
            ResultSet results = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(server, username, password);
            String prequery = "SELECT * FROM Products WHERE Name=?";
            PreparedStatement query = connection.prepareStatement(prequery);
            query.setString(1, name);

            results = query.executeQuery();

            while(results.next()){
                temp.setID(results.getInt("id"));
                temp.setName(results.getString("Name"));
                temp.setDescription(results.getString("Description"));

            }//close while statement

            connection.close();
        }//close try statement
        catch(Exception ex){
            System.out.print(ex.getMessage());
        }//close catch

        return temp;

    }//close getProductById()


    
    public void updateName(int id, String name){
    	try{
    		Class.forName("com.mysql.jdbc.Driver").newInstance();
    		
            connection = DriverManager.getConnection(server, username, password);
            
                String prequery = "UPDATE Products Set Name = ? WHERE id = ?";
                PreparedStatement query = connection.prepareStatement(prequery);
                query.setString(1, name);
                query.setInt(2, id);
                
                
                query.execute();

                connection.close();

            }//close try statement
            catch(Exception ex){
                ex.printStackTrace();
            }//close Exception
    }//close updatePhoneNumber
    
    
    public void updateDescription(int id, String description){
    	try{
    		Class.forName("com.mysql.jdbc.Driver").newInstance();
    		
            connection = DriverManager.getConnection(server, username, password);
            
                String prequery = "UPDATE Products Set Description = ? WHERE id = ?";
                PreparedStatement query = connection.prepareStatement(prequery);
                query.setString(1, description);
                query.setInt(2, id);
                
                
                query.execute();

                connection.close();

            }//close try statement
            catch(Exception ex){
                ex.printStackTrace();
            }//close Exception
    }//close updatePhoneNumber
    
    

    //Removes an item from the 
    public void deleteProduct(int id){
        try{
        	
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(server, username, password);

            String prequery = "DELETE FROM Products WHERE id = ?";
            PreparedStatement query = connection.prepareStatement(prequery);
            query.setInt(1, id);

            query.execute();

            connection.close();

        }//close try statement
        catch(Exception ex){
            ex.printStackTrace();
        }//close Exception


    }//close deleteCustomer*/

}
