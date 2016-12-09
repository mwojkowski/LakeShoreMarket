package com.LakeShore.service.representation;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.LakeShore.Model.OrderItem;


@XmlRootElement(name = "Order")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class OrderRequest {

	private int id;
	private String status;
	private Set<OrderItem> items = new HashSet<OrderItem>();
	
	public OrderRequest(){
		
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
		
	}
	
}
