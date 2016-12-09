package com.LakeShore.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import com.LakeShore.Model.Customer;
import com.LakeShore.Model.Order;
import com.LakeShore.Model.OrderItem;
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
    
    public Set<Order> getCustomerOrders(int customerID){
    	ResultSet temp;
    	
    	Order tempOrder = new Order();
    	try{
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(server, username, password);

            String prequery = "SELECT id FROM Orders WHERE CustomerID = ? ORDER BY id DESC";
            PreparedStatement query = connection.prepareStatement(prequery);
            query.setInt(1, customerID);
            
            temp = query.executeQuery();
            
            while(temp.next()){
            	orders.add(lookupOrder(temp.getInt("id")));
            }
            connection.close();


        }//close try statement
        catch(Exception ex){
            ex.printStackTrace();
        }//close catch statement
    	
    	return orders;
    }
    
    
    
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
    
    public boolean submitOrder(int id){
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
            return false;
        }//close Exception
    	return true;
    	
    }//close submitOrder
    
    
    //Sets the order status to Processing when a partner receives the order
    public boolean processOrder(int id){
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
            return false;
        }//close Exception
    	
    	return true;
    }//close processOrder
	
	//OrderShipped
    public boolean shipOrder(int id){
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
            return false;
        }//close Exception
    	return true;
    }//close shipOrder()
	
	//OrderCancelled
    public boolean cancelOrder(int id){
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
            return false;
        }//close Exception
    	return true;
    }//close cancelOrder
    
    public boolean deliverOrder(int id){
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
            return false;
        }//close Exception
    	return true;
    }//close deliverOrder
    
    public Order lookupOrder(int id){
    	Order temp = new Order();
    	ResultSet x; ResultSet y;

        try{
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(server, username, password);

            String prequery = "SELECT * FROM Orders WHERE id = ? LIMIT 1";
            PreparedStatement query = connection.prepareStatement(prequery);
            query.setInt(1, id);

            x = query.executeQuery();

            while(x.next()){
                temp.setID(x.getInt("id"));
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
    
    public boolean removeItem(int productID, int orderID){
    	try{
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(server, username, password);

            String prequery = "DELETE FROM OrderItems WHERE OrderID = ? AND productID = ?";
            PreparedStatement query = connection.prepareStatement(prequery);
            query.setInt(1, orderID);
            query.setInt(2, productID);
            
            query.execute();       
            
            connection.close();
        }//close try statement
        catch(Exception ex){
            ex.printStackTrace();
            return false;
        }//close catch statement
		return true;
    }//close removeItem
	
	//Add Item to Order
	public boolean addItem(int orderID, int partnerID, int productID, int quantity, double price){
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
            return false;
        }//close catch statement
		return true;
	}//close addItem
	
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
	
	public boolean buyItemNow(int customerID, int productID, int partnerID){
		ResultSet x;
		
		OrderItem temp = new OrderItem(); int orderID = 0;
		try{
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(server, username, password);
            
            
            //Get the price of the item purchased
            String prequery = "SELECT Price FROM Products WHERE SellerID = ? AND ID = ? LIMIT 1";
            PreparedStatement query = connection.prepareStatement(prequery);
            query.setInt(1, partnerID);
            query.setInt(2, productID);
            
            x = query.executeQuery();
            while(x.next()){
            	temp.setPrice(x.getDouble("Price"));
            }//close while statement

            
            //Generate order item
            prequery = "INSERT INTO Orders (CustomerID, Total, Status) VALUES (?, ?, ?)";
            query = connection.prepareStatement(prequery);
            query.setInt(1, customerID);
            query.setDouble(2, temp.getPrice());
            query.setString(3, "Submitted");

            query.execute();

            prequery = "SELECT id FROM Orders WHERE CustomerID = ? ORDER BY id DESC LIMIT 1";
            query = connection.prepareStatement(prequery);
            query.setInt(1, customerID);

            x = query.executeQuery();
            while(x.next()){
            	orderID = x.getInt("id");
            }//close while statement

            //Generate the order Item for the order
            prequery = "INSERT INTO OrderItems (OrderID, PartnerID, ProductID, Quantity, Price) VALUES (?, ?, ?, ?, ?)";
            query = connection.prepareStatement(prequery);
            query.setInt(1, orderID);
            query.setInt(2, partnerID);
            query.setInt(3, productID);
            query.setInt(4, 1);
            query.setDouble(5, temp.getPrice());
            
            query.execute();
            
            connection.close();


        }//close try statement
        catch(Exception ex){
            ex.printStackTrace();
            return false;
        }//close catch statement
		
		return true;
	}//close buyItemNow
    
	
	
    
}//close class
