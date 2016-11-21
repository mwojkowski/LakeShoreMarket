package com.LakeShore.Model;


import java.util.*;

public class Order {
	private int id;
	private String status;
	private Set<OrderItem> items = new HashSet<OrderItem>();
	
	public Order(){
		
	}//underloaded constructor
	
	private void setID(int x){
		this.id = x;
	}
	private void setStatus(String x){
		this.status = x;
	}//close setStatus
	private void addOrderItem(int cid, int partnerID, int productID, double price, int quantity){
		items.add(new OrderItem(id, cid, partnerID, productID, price, quantity));
	}//close addOrderItem
	
	

}//close class
