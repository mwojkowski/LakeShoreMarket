package com.LakeShore.service.representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



/**
 * Created by matthewwojkowski on 11/8/16.
 */
@XmlRootElement(name = "Partner")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="")
public class PartnerRepresentation {
	
	public PartnerRepresentation(){
		
	}//close underloaded constructor
	private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String city;
    private String state;
    private String zip;
    private String company;
    
    
    public int getID(){ return id ; }

    public void setID(int id){
        this.id = id;
    }

    public String getFirstName(){   return firstName;   }

    public String getLastName(){    return lastName;    }

    public String getAddress(){     return address;     }

    public String getPhoneNumber(){ return phoneNumber; }

    public String getCity(){    return city;    }

    public String getState(){   return state;   }

    public String getZip(){ return zip; }

    public void setFirstName(String x){   this.firstName = x;    }

    public void setLastName(String x){  this.lastName = x;  }

    public void setAddress(String x){   this.address = x;   }

    public void setPhoneNumber(String x){   this.phoneNumber = x; }

    public void setCity(String x){  this.city = x;  }

    public void setState(String x){ this.state = x; }

    public void setZip(String x){   this.zip = x;    }

    public String getCompany(){ return company; }

    public void setCompany(String x){   this.company = x; }

	

}//close PartnerRepresentation class
