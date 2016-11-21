package com.LakeShore.Model;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * Created by matthewwojkowski on 11/8/16.
 */
@XmlRootElement
public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String city;
    private String state;
    private String zip;
    private boolean active;

    public Customer(){

    }//close underloaded constructor

    public Customer(String firstName, String lastName, String address, String phoneNumber, String city, String state, String zip, boolean active){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.active = active;
    }//close Customer.Customer


    public Customer(int id, String firstName, String lastName, String address, String phoneNumber, String city, String state, String zip, boolean active){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.active = active;
    }//close Customer.Customer

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

    public void setActive(boolean x){   this.active = x;}

    public boolean getActive(){
        return active;
    }//close getActive()


}//class
