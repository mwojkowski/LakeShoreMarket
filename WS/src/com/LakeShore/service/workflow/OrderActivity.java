package com.LakeShore.service.workflow;

import com.LakeShore.Manager.OrderManager;
import com.LakeShore.service.representation.OrderRepresentation;
import com.LakeShore.service.representation.ProductRepresentation;
import com.LakeShore.Model.Link;
import com.LakeShore.Model.Order;

import com.LakeShore.Utilities.*;

import java.util.*;

public class OrderActivity {
	private static OrderManager oManager = new OrderManager();
	
	
	public OrderActivity(){
		
	}//close underloaded constructor
	
	public Set<OrderRepresentation> getCustomerOrders(String customerID){
		Set<Order> orders = new HashSet<Order>();
		
		Set<OrderRepresentation> orderReps = new HashSet<OrderRepresentation>();
		
		orders = oManager.getCustomerOrders(Integer.valueOf(customerID));
		
		Iterator<Order> oIt = orders.iterator();
		while(oIt.hasNext()){
			OrderRepresentation orderRep = new OrderRepresentation();
			Order tempOrder = (Order)oIt.next();
			orderRep.setID(tempOrder.getID());
			orderRep.setStatus(tempOrder.getStatus());
			orderRep.addItems(tempOrder.getItems());
			
			//setLinks(orderRep);
			
			orderReps.add(orderRep);
			
		}//close while loop
		
		return orderReps;
		
	}
	
	public OrderRepresentation createOrder(String customerID){
		Order temp = new Order();
		
		OrderRepresentation ordTemp = new OrderRepresentation();
		
		temp = oManager.createOrder(Integer.valueOf(customerID));
		
		ordTemp.setID(temp.getID());
		
		return ordTemp;
	}//close CreateOrder
	
	//This method makes an order official. 
	//Therefore, we need to notify the partner and charge the customers card.
	public boolean submitOrder(String id){
		try{
			oManager.submitOrder(Integer.valueOf(id));
		}
		catch(Exception e){
			return false;
		}//close catch
		
		Notifier notifier = new Notifier();//notify partner of new order...
		notifier.notifyPartner(Integer.valueOf(id));
		
		TransactionProcessor processor = new TransactionProcessor();//charge the credit card...
		processor.chargeCreditCard("1234-5678-9012-3456", Integer.valueOf(id));
		return true;
	}//close submitOrder
	
	public boolean processOrder(String id){
		return oManager.processOrder(Integer.valueOf(id));
	}//close processOrder
	
	public boolean shipOrder(String id){
		
		
		Notifier notifier = new Notifier();
		notifier.orderFulfillment(Integer.valueOf(id));
		
		return oManager.shipOrder(Integer.valueOf(id));
	}//close shipOrder
	
	public boolean deliverOrder(String id){
		return oManager.deliverOrder(Integer.valueOf(id));
	}//close deliverOrder
	
	public boolean cancelOrder(String id){
		return oManager.cancelOrder(Integer.valueOf(id));
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
	
	public boolean removeItem(String orderID, String productID){
		return oManager.removeItem(Integer.valueOf(orderID), Integer.valueOf(orderID));
	}//close removeItem
	
	public boolean addItem(String orderID, String partnerID, String productID, String quantity, String price){
		return oManager.addItem(Integer.valueOf(orderID), Integer.valueOf(partnerID), Integer.valueOf(productID), Integer.valueOf(quantity), Double.valueOf(price));
	}//close addItem
	
	public String checkStatus(String id){
		return oManager.getStatus(Integer.valueOf(id));
	}
	
	public boolean buyItemNow(String customerID, String productID, String partnerID){
		return oManager.buyItemNow(Integer.valueOf(customerID), Integer.valueOf(productID), Integer.valueOf(partnerID));
	}

	private void setLinks(OrderRepresentation temp){
    	temp.addLinks(new Link("Cancel", "@DELETE", "http://localhost:8081/Orders/", "http://localhost:8081/API/Products/Order/" + temp.getID()));
    }//close setLinks
	
}//close class
