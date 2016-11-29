package com.LakeShore.Manager;

import com.LakeShore.DAO.*;
import com.LakeShore.Model.Order;
import com.LakeShore.Model.OrderItem;

import java.util.*;


public class OrderManager {
	public static OrderDAO dao = new OrderDAO();
	
	public OrderManager(){
		
	}//close underloaded constructor
	
	
	//passes the new order up to the OrderResource class
	public Order createOrder(int customerID){
		Order tempOrder = new Order();
		
		tempOrder = dao.createOrder(customerID);
		
		return tempOrder;
	}//close createOrder
	
	public void submitOrder(int id){
		dao.submitOrder(id);
	}
	
	//OrderProcessing
	public void processOrder(int id){
		dao.processOrder(id);
	}//close processOrder
	
	//OrderShipped
	public void shipOrder(int id){
		dao.shipOrder(id);
	}//close shipOrder
	
	//OrderDelivered
	public void deliverOrder(int id){
		dao.deliverOrder(id);
	}//close deliverOrder()
	
	//OrderCancelled
	public void cancelOrder(int id){
		dao.cancelOrder(id);
	}//close cancelOrder()
	
	//Add Item to Order
	
	//Remove Item from order
	
	//Look Up Order
	public Order lookupOrder(int id){
		Order temp = new Order();
		
		temp = dao.lookupOrder(id);
		
		return temp;
	}//close lookupOrder()
	
	public void addItem(int orderID, int partnerID, int productID, int quantity, double price){
		dao.addItem(orderID, partnerID, productID, quantity, price);
	}//close addItem
	
}
