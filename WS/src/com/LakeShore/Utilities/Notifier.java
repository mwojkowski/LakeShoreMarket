package com.LakeShore.Utilities;

public class Notifier {
	
	public Notifier(){
		
	}//close underloaded Constructor

	public void notifyPartner(int orderID){
		System.out.println("A 'New Order' notificaiton has been sent to partners pertaining to orderID: " + orderID + "........");
	}//close notifyPartner
	
	public void orderFulfillment(int orderID){
		System.out.println("A 'Order Shipped' notification has been sent to the customer with Order Id: " + orderID + "........");
	}//close orderFulfillment
	
	
}//close class
