package com.LakeShore.service.representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import java.util.*;


import com.LakeShore.Model.Order;
import com.LakeShore.Model.OrderItem;
import com.LakeShore.Model.Link;


@XmlRootElement(name = "Order")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="")
public class OrderRepresentation extends AbstractRepresentation{

	private int id;
	private String status;
	private Set<OrderItem> items = new HashSet<OrderItem>();
	
	
	public OrderRepresentation(){
		
	}//underloaded constructor
	
	public void setID(int x){
		this.id = x;
	}
	
	
	public int getID(){
		return id;
	}
	public void setStatus(String x){
		this.status = x;
	}//close setStatus
	
	public String getStatus(){
		return status;
	}
	
	public void addOrderItem(int cid, int partnerID, int productID, double price, int quantity){
		items.add(new OrderItem(id, cid, partnerID, productID, price, quantity));
	}//close addOrderItem
	
	public void addOrderITem(OrderItem x){
		items.add(x);
	}
	
	public void addItems(Set<OrderItem> x){
		for(OrderItem i : x){
			items.add(i);
		}
	}//close addItems()
	
	
	
	
}//close class
