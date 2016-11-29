package com.LakeShore.Model;

import javax.xml.bind.annotation.XmlRootElement;

import com.LakeShore.Model.*;

@XmlRootElement
public class OrderItem {
	private int orderID;//Links this tuple in the database to the order it belongs to
	private int partnerID;//Links this tuple to the partner that this product was bought from
	private int customerID;//Links this tuple to the customer that created this order
	private int productID;//Links to the product that is in the order
	private double price;//Price for the item purchased
	private int quantity;//quantity of the items ordered in this line
	
	public OrderItem(){
		
	}//close underloaded constructor
	
	
	public OrderItem(int oID, int customerID, int partnerID, int productID, double price, int quantity){
		this.customerID = customerID; this.partnerID = partnerID;
		this.orderID = oID; this.productID = productID;
		this.price = price; this.quantity = quantity;
		
	}//close overlaoded constructor
	
	//setters and getters
	
	public void setOrderID(int x){	this.orderID = x;	}
	
	public void setProductID(int x){	this.productID = x;	}
	
	public void setPartnerID(int x){	this.partnerID = x;	}
	
	public void setCustomerID(int x){	this.customerID = x;	}
	
	public void setPrice(double x){	this.price = x;	}
	
	public void setQuantity(int x){	this.quantity = x;	}
	
	
	public int getorderID(){	return orderID;	}
	
	public int getProductID(){	return productID;	}
	
	public int getPartnerID(){	return partnerID;	}
	
	public int getCustomerID(){	return customerID;	}
	
	public double getPrice(){	return price;	}
	
	public int getQuantity(){	return quantity;	}
	
	
	

}//close class OrderItem
