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
	
	//OrderProcessing
	
	//OrderShipped
	
	//OrderReceived
	
	//OrderCancelled
	
	//Add Item to Order
	
	//Remove Item from order
	
	//Look Up Order
	
}
