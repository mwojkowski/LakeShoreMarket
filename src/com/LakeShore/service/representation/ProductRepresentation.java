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
	
	public ProductRepresentation(){
		
	}
	
	public int getID(){ return id;  }
    
    public void setID(int x){	this.id = x;	}

    public String getName(){    return name;    }

    public String getDescription(){ return description; }

    public void setName(String x){  this.name = x;   }

    public void setDescription(String x){   this.description = x;   }


}//close ProductRepresentation
