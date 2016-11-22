package com.LakeShore.service.workflow;

import com.LakeShore.Manager.OrderManager;
import com.LakeShore.service.representation.OrderRepresentation;
import com.LakeShore.Model.Order;

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

}//close class
