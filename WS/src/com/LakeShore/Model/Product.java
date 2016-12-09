package com.LakeShore.Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
	private int id;
    private String name;
    private String description;
    private int sellerID;
    private int quantity;
    private double price;
    private boolean active;

    public Product(){
    	
    }
    
    public Product(int id, String name, String description){
    	this.id = id;
        this.name = name;
        this.description = description;

    }//close overloaded Constructor

    public Product(int id, String name, String description, int sellerID, int quantity, double price){
    	this.id = id; this.name = name; 
    	this.description = description; 
    	this.sellerID = sellerID; 
    	this.quantity = quantity;
    	this.price = price;
    }//close overloaded constructor
    
    public int getID(){ return id;  }
    
    public void setID(int x){	this.id = x;	}

    public String getName(){    return name;    }

    public String getDescription(){ return description; }

    public void setName(String x){  this.name = x;   }

    public void setDescription(String x){   this.description = x;   }
    
    public void setSellerID(int id){	this.id = id;	}
    
    public int getSellerID(){	return sellerID;	}
    
    public void setQuantity(int x){	this.quantity = x;	}
    
    public int getQuantity(){	return quantity;	}
    
    public void setPrice(double x)	{	this.price = x;	}
    
    public double getPrice(){	return price;	}
    
    public boolean getStatus(){	return active;}
    
    public void setStatus(boolean x){	this.active = x;	}

}//close class
