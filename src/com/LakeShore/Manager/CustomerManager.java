package com.LakeShore.Manager;

import com.LakeShore.DAO.*;
import com.LakeShore.Model.Customer;

import java.util.*;

/**
 * Created by matthewwojkowski on 11/8/16.
 */
public class CustomerManager {
    public static CustomerDAO dao = new CustomerDAO();

    public CustomerManager(){

    }//close underloaded Constructor


    public Customer addCustomer(String firstName, String lastName){
        Customer x = dao.addCustomer(firstName, lastName);
        
        return x;
    }//close class

    public Set<Customer> getAllCustomers(){

        return dao.getAllCustomers();
    }//close getAllCustomers()

    public Customer getCustomerById(int id){

        return dao.getCustomerById(id);
    }//close getCustomerById()
    
    public boolean updateCustomerAddress(int id, String address){
    	return dao.updateCustomerAddress(id, address);
    	
    }//close updateCustomer Address
    
    public boolean updatePhoneNumber(int id, String phoneNumber){
    	return dao.updatePhoneNumber(id,  phoneNumber);
    }//close updatePhoneNumber()
    
    public boolean updateCity(int id, String city){
    	return dao.updateCity(id, city);
    }//close updateCity()
    
    public boolean updateState(int id, String state){
    	return dao.updateState(id, state);
    }//close updateState()
    
    public boolean updateZip(int id, String zip){
    	return dao.updateZip(id, zip);
    }//close updateZip()
    
    public boolean deleteCustomer(int id){
    	return dao.deleteCustomer(id);
    }//close deleteCustomer


}//class
