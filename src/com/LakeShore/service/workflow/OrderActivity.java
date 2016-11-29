package com.LakeShore.service.workflow;

import com.LakeShore.Manager.OrderManager;
import com.LakeShore.service.representation.OrderRepresentation;
import com.LakeShore.Model.Order;

import com.LakeShore.Utilities.*;

import java.util.*;

public class OrderActivity {
	private static OrderManager oManager = new OrderManager();
	
	
	public OrderActivity(){
		
	}//close underloaded constructor
	
	public OrderRepresentation createOrder(String customerID){
		Order temp = new Order();
		
		OrderRepresentation ordTemp = new OrderRepresentation();
		
		temp = oManager.createOrder(Integer.valueOf(customerID));
		
		ordTemp.setID(temp.getID());
		
		return ordTemp;
	}//close CreateOrder
	
	//This method makes an order official. 
	//Therefore, we need to notify the partner and charge the customers card.
	public void submitOrder(String id){
		oManager.submitOrder(Integer.valueOf(id));
		
		Notifier notifier = new Notifier();//notify partner of new order...
		notifier.notifyPartner(Integer.valueOf(id));
		
		TransactionProcessor processor = new TransactionProcessor();//charge the credit card...
		processor.chargeCreditCard("1234-5678-9012-3456", Integer.valueOf(id));
		
	}//close submitOrder
	
	public void processOrder(String id){
		oManager.processOrder(Integer.valueOf(id));
	}//close processOrder
	
	public void shipOrder(String id){
		oManager.shipOrder(Integer.valueOf(id));
		
		Notifier notifier = new Notifier();
		notifier.orderFulfillment(Integer.valueOf(id));
		
	}//close shipOrder
	
	public void deliverOrder(String id){
		oManager.deliverOrder(Integer.valueOf(id));
	}//close deliverOrder
	
	public void cancelOrder(String id){
		oManager.cancelOrder(Integer.valueOf(id));
	}//close cancelOrder
	
	//Add Item to Order
	
	//Remove Item from Order
	
	
	public OrderRepresentation lookupOrder(String id){
		Order temp = new Order();
		
		OrderRepresentation ordTemp = new OrderRepresentation();
		
		temp = oManager.lookupOrder(Integer.valueOf(id));
		
		ordTemp.setID(temp.getID());
		ordTemp.setStatus(temp.getStatus());
		ordTemp.addItems(temp.getItems());
		
		return ordTemp;
		
	}//close lookupOrder
	
	public void addItem(String orderID, String partnerID, String productID, String quantity, String price){
		oManager.addItem(Integer.valueOf(orderID), Integer.valueOf(partnerID), Integer.valueOf(productID), Integer.valueOf(quantity), Double.valueOf(price));
	}//close addItem

}//close class
