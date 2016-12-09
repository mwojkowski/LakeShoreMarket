package com.LakeShore.Model;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Partner{
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String city;
    private String state;
    private String zip;
    private String company;

    public Partner(String firstName, String lastName, String address, String phoneNumber, String city, String state, String zip, String company){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.company = company;
    }//close overloaded constructor
    public Partner(int id, String firstName, String lastName, String address, String phoneNumber, String city, String state, String zip, String company){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.company = company;
    }//close overloaded constructor
    
    public Partner(){
    	
    }//close underloaded constructor


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

    public void setCompany(String company){   this.company = company; }


}
