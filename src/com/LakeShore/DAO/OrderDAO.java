package com.LakeShore.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import com.LakeShore.Model.Customer;
import com.LakeShore.Model.Order;
import com.mysql.jdbc.Statement;

public class OrderDAO {

	//******MySQL DATABASE CONNECTION DETAILS*****
    private String server = "jdbc:mysql://162.218.48.24:3306/Lakeshore";
    private String username = "LakeShore";
    private String password = "284028";

    Connection connection;

    private static Set<Order> orders = new HashSet<Order>();
    
    public OrderDAO(){
    	
    }//close underloaded constructor
    
    
    
    public Order createOrder(int customerID){
    	Order newOrder = new Order();
    	ResultSet temp;
    	try{
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(server, username, password);

            String prequery = "INSERT INTO Orders (CustomerID) VALUES (?)";
            PreparedStatement query = connection.prepareStatement(prequery);
            query.setInt(1, customerID);

            query.execute();

            prequery = "SELECT MAX(id) as id, Status FROM Orders WHERE CustomerID = ? LIMIT 1";
            query = connection.prepareStatement(prequery);
            query.setInt(1, customerID);
            
            temp = query.executeQuery();
            
            while(temp.next()){
            	newOrder.setID(temp.getInt("id"));
            	
            	newOrder.setStatus(temp.getString("Status"));
            }//close while statement
            
            connection.close();


        }//close try statement
        catch(Exception ex){
            ex.printStackTrace();
        }//close catch statement
    	
    	return newOrder;
    }//close createOrder
    
    //Sets the order status to Processing when a partner receives the order
    public void processOrder(int id){
    	try{
        	
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(server, username, password);

            String prequery = "UPDATE Orders Set Status = 'Processing' WHERE id = ?";
            PreparedStatement query = connection.prepareStatement(prequery);
            query.setInt(1, id);

            query.execute();

            connection.close();

        }//close try statement
        catch(Exception ex){
            ex.printStackTrace();
        }//close Exception
    	
    }//close processOrder
	
	//OrderShipped
    public void shipOrder(int id){
    	try{
        	
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(server, username, password);

            String prequery = "UPDATE Orders Set Status = 'Shipped' WHERE id = ?";
            PreparedStatement query = connection.prepareStatement(prequery);
            query.setInt(1, id);

            query.execute();

            connection.close();

        }//close try statement
        catch(Exception ex){
            ex.printStackTrace();
        }//close Exception
    }//close shipOrder()
	
	//OrderCancelled
    public void cancelOrder(int id){
    	try{
        	
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(server, username, password);

            String prequery = "UPDATE Orders Set Status = 'Cancelled' WHERE id = ?";
            PreparedStatement query = connection.prepareStatement(prequery);
            query.setInt(1, id);

            query.execute();

            connection.close();

        }//close try statement
        catch(Exception ex){
            ex.printStackTrace();
        }//close Exception
    }
	
	//Add Item to Order
	
	//Remove Item from order
	
	//Look Up Order
	
	
    
}//close class
