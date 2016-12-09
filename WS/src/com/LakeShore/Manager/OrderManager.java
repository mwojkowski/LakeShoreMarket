package com.LakeShore.Manager;

import com.LakeShore.DAO.*;
import com.LakeShore.Model.Order;
import com.LakeShore.Model.OrderItem;

import java.util.*;


public class OrderManager {
	public static OrderDAO dao = new OrderDAO();
	
	public OrderManager(){
		
	}//close underloaded constructor
	
	public Set<Order> getCustomerOrders(int customerID){
		return dao.getCustomerOrders(customerID);
	}
	
	//passes the new order up to the OrderResource class
	public Order createOrder(int customerID){
		Order tempOrder = new Order();
		
		tempOrder = dao.createOrder(customerID);
		
		return tempOrder;
	}//close createOrder
	
	public boolean submitOrder(int id){
		return dao.submitOrder(id);
	}
	
	//OrderProcessing
	public boolean processOrder(int id){
		return dao.processOrder(id);
	}//close processOrder
	
	//OrderShipped
	public boolean shipOrder(int id){
		return dao.shipOrder(id);
	}//close shipOrder
	
	//OrderDelivered
	public boolean deliverOrder(int id){
		return dao.deliverOrder(id);
	}//close deliverOrder()
	
	//OrderCancelled
	public boolean cancelOrder(int id){
		return dao.cancelOrder(id);
	}//close cancelOrder()
	
	//Add Item to Order
	
	//Remove Item from order
	
	//Look Up Order
	public Order lookupOrder(int id){
		Order temp = new Order();
		
		temp = dao.lookupOrder(id);
		
		return temp;
	}//close lookupOrder()
	
	public boolean removeItem(int orderID, int productID){
		return dao.removeItem(productID, orderID);
	}
	
	public boolean addItem(int orderID, int partnerID, int productID, int quantity, double price){
		return dao.addItem(orderID, partnerID, productID, quantity, price);
	}//close addItem
	
	public String getStatus(int id){
		return dao.checkStatus(id);
	}
	
	public boolean buyItemNow(int customerID, int productID, int partnerID){
		return dao.buyItemNow(customerID, productID, partnerID);
	}
	
}//close class
