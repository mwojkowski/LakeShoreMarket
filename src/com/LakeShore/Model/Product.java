package com.LakeShore.Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
	private int id;
    private String name;
    private String description;

    public Product(){
    	
    }
    
    public Product(int id, String name, String description){
    	this.id = id;
        this.name = name;
        this.description = description;

    }//close overloaded Constructor

    public int getID(){ return id;  }
    
    public void setID(int x){	this.id = x;	}

    public String getName(){    return name;    }

    public String getDescription(){ return description; }

    public void setName(String x){  this.name = x;   }

    public void setDescription(String x){   this.description = x;   }

}
