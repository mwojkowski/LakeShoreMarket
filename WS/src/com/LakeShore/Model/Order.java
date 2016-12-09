package com.LakeShore.Model;

import javax.xml.bind.annotation.XmlRootElement;

import java.util.*;



@XmlRootElement
public class Order {
	private int id;
	private String status;
	private int customerID;
	public Set<OrderItem> items = new HashSet<OrderItem>();
	
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
	
	public String getStatus(){
		return status;
	}
	
	public void addOrderItem(int cid, int partnerID, int productID, double price, int quantity){
		items.add(new OrderItem(id, cid, partnerID, productID, price, quantity));
	}//close addOrderItem
	
	public Set<OrderItem> getItems(){
		return items;
	}
	
	public void setCustomerID(int id){	this.customerID = id;	}
	
	public int getCustomerID(){	return customerID;	}
	

}//close class
