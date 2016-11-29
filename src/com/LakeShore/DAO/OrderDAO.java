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

            String prequery = "INSERT INTO Orders (CustomerID, Status) VALUES (?, ?)";
            PreparedStatement query = connection.prepareStatement(prequery);
            query.setInt(1, customerID);
            query.setString(2, "Cart");

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
    
    public void submitOrder(int id){
    	try{
        	
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(server, username, password);

            String prequery = "UPDATE Orders Set Status = 'Submitted' WHERE id = ?";
            PreparedStatement query = connection.prepareStatement(prequery);
            query.setInt(1, id);

            query.execute();

            connection.close();

        }//close try statement
        catch(Exception ex){
            ex.printStackTrace();
        }//close Exception
    	
    }//close submitOrder
    
    
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
    }//close cancelOrder
    
    public void deliverOrder(int id){
    	try{
        	
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(server, username, password);

            String prequery = "UPDATE Orders Set Status = 'Delivered' WHERE id = ?";
            PreparedStatement query = connection.prepareStatement(prequery);
            query.setInt(1, id);

            query.execute();

            connection.close();

        }//close try statement
        catch(Exception ex){
            ex.printStackTrace();
        }//close Exception
    }//close deliverOrder
    
    public Order lookupOrder(int id){
    	Order temp = new Order();
    	ResultSet x; ResultSet y;

        try{
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(server, username, password);

            String prequery = "SELECT CustomerId, Status FROM Orders WHERE id = ?";
            PreparedStatement query = connection.prepareStatement(prequery);
            query.setInt(1, id);

            x = query.executeQuery();

            while(x.next()){
                temp.setID(id);
                temp.setCustomerID(x.getInt("CustomerID"));
                temp.setStatus(x.getString("Status"));
            }//close while statement


            prequery = "SELECT PartnerID, ProductID, Quantity, Price FROM OrderItems WHERE OrderID = ?";
            query = connection.prepareStatement(prequery);
            query.setInt(1, id);
            
            y = query.executeQuery();
            while(y.next()){
            	temp.addOrderItem(id, y.getInt("PartnerID"), y.getInt("ProductID"), y.getDouble("Price"), y.getInt("Quantity"));
            }//close while statement
            
            connection.close();


        }//close try statement
        catch(Exception ex){
            ex.printStackTrace();
        }//close catch statement



        return temp;
    	
    }//close lookupOrder
	
	//Add Item to Order
	public void addItem(int orderID, int partnerID, int productID, int quantity, double price){
		try{
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(server, username, password);

            String prequery = "INSERT INTO OrderItems (OrderId, PartnerID, ProductID, Quantity, Price) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement query = connection.prepareStatement(prequery);
            query.setInt(1, orderID);
            query.setInt(2, partnerID);
            query.setInt(3, productID);
            query.setInt(4, quantity);
            query.setDouble(5, price);
            
            query.execute();       
            
            connection.close();
        }//close try statement
        catch(Exception ex){
            ex.printStackTrace();
        }//close catch statement
	}//close addItem
	//Remove Item from order
	
	public String checkStatus(int id){
		ResultSet x;
		String temp = "";
		try{
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
        	
            String prequery = "SELECT Status FROM Orders WHERE OrderID = ? LIMIT 1";
            PreparedStatement query = connection.prepareStatement(prequery);
            query.setInt(1, id);
            
            x = query.executeQuery();
            while(x.next()){
            	temp = x.getString("Status");
            }//close while statement
            
            connection.close();


        }//close try statement
        catch(Exception ex){
            ex.printStackTrace();
        }//close catch statement
		
		return temp;
	}//close checkStatus
    
	
	
    
}//close class
