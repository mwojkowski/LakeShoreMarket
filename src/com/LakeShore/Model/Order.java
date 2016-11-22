package com.LakeShore.Model;

import javax.xml.bind.annotation.XmlRootElement;

import java.util.*;



@XmlRootElement
public class Order {
	private int id;
	private String status;
	private Set<OrderItem> items = new HashSet<OrderItem>();
	
	public Order(){
		
	}//underloaded constructor
	
	public void setID(int x){
		this.id = x;
	}
	
	public int getID(){
		return id;
	}//close getID()
	
	
	public void setStatus(String x){
		this.status = x;
	}//close setStatus
	
	
	public void addOrderItem(int cid, int partnerID, int productID, double price, int quantity){
		items.add(new OrderItem(id, cid, partnerID, productID, price, quantity));
	}//close addOrderItem
	
	

}//close class
