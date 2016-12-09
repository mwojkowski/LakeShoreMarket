package com.LakeShore.service.workflow;

import com.LakeShore.Manager.CustomerManager;
import com.LakeShore.service.representation.CustomerRepresentation;
import com.LakeShore.Model.Customer;

import java.util.*;

/**
 * Created by matthewwojkowski on 11/8/16.
 */
public class CustomerActivity {
    private static CustomerManager cManager = new CustomerManager();

    public CustomerActivity(){

    }

    public Set<CustomerRepresentation> getCustomers(){
        Set<Customer> customers = new HashSet<Customer>();

        Set<CustomerRepresentation> customerRepresentations = new HashSet<CustomerRepresentation>();

        customers = cManager.getAllCustomers();
        Iterator<Customer> cIterator = customers.iterator();
        while(cIterator.hasNext()){
            Customer temp = (Customer)cIterator.next();
            CustomerRepresentation cusRepTemp = new CustomerRepresentation();
            cusRepTemp.setID(temp.getID());
            cusRepTemp.setFirstName(temp.getFirstName());
            cusRepTemp.setLastName(temp.getLastName());
            cusRepTemp.setAddress(temp.getAddress());
            cusRepTemp.setPhoneNumber(temp.getPhoneNumber());
            cusRepTemp.setCity(temp.getCity());
            cusRepTemp.setState(temp.getState());
            cusRepTemp.setZip(temp.getZip());

            customerRepresentations.add(cusRepTemp);
        }//close while loop

        return customerRepresentations;
    }//close getCustomers()
    

    public CustomerRepresentation getCustomerById(int id){
        Customer temp = cManager.getCustomerById(id);

        CustomerRepresentation cusRep = new CustomerRepresentation();
        cusRep.setID(temp.getID());
        cusRep.setFirstName(temp.getFirstName());
        cusRep.setLastName(temp.getLastName());
        cusRep.setAddress(temp.getAddress());
        cusRep.setPhoneNumber(temp.getPhoneNumber());
        cusRep.setCity(temp.getCity());
        cusRep.setState(temp.getState());
        cusRep.setZip(temp.getZip());

        return cusRep;

    }//close getCustomerById()

    public CustomerRepresentation createCustomer(String firstName, String lastName){
        Customer cust = cManager.addCustomer(firstName, lastName);

        CustomerRepresentation custRep = new CustomerRepresentation();
        
        
        custRep.setID(cust.getID());
        custRep.setFirstName(cust.getFirstName());
        custRep.setLastName(cust.getLastName());

        return custRep;
    }//close createCustomer

    public boolean updateCustomerAddress(String id, String address){
    	return cManager.updateCustomerAddress(Integer.valueOf(id), address);    
    }//close updateCustomerAddress()
    
    public boolean updatePhoneNumber(String id, String phoneNumber){
    	return cManager.updatePhoneNumber(Integer.valueOf(id), phoneNumber);
    }//close updatePhoneNumber()
    
    public boolean updateCity(String id, String city){
    	return cManager.updateCity(Integer.valueOf(id), city);
    }//close updateCity()
    
    public boolean updateState(String id, String state){
    	return cManager.updateState(Integer.valueOf(id), state);
    }//close updateState()
    
    public boolean updateZip(String id, String zip){
    	return cManager.updateZip(Integer.valueOf(id), zip);
    }//close updateZip()
    
    public boolean deleteCustomer(String id){
    	return cManager.deleteCustomer(Integer.valueOf(id));
    }//close deleteCustomer()
    
    /*private void setLinks(CustomerRepresentation custRep){
    	
    }*/



}//class
