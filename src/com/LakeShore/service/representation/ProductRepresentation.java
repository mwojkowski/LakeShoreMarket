package com.LakeShore.service.representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Product")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="")
public class ProductRepresentation {
	
	private int id;
    private String name;
    private String description;
    private int sellerID;
    private int quantity;
    private double price;
    private boolean active;
	
	public ProductRepresentation(){
		
	}
	
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
    
    public void setPrice(int x)	{	this.price = x;		}
    
    public double getPrice(){	return price;	}
    
    public boolean getStatus(){	return active;}
    
    public void setStatus(boolean x){	this.active = x;	}


}//close ProductRepresentation
