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
    
    public void updateCustomerAddress(int id, String address){
    	dao.updateCustomerAddress(id, address);
    	
    }//close updateCustomer Address
    
    public void updatePhoneNumber(int id, String phoneNumber){
    	dao.updatePhoneNumber(id,  phoneNumber);
    }//close updatePhoneNumber()
    
    public void updateCity(int id, String city){
    	dao.updateCity(id, city);
    }//close updateCity()
    
    public void updateState(int id, String state){
    	dao.updateState(id, state);
    }//close updateState()
    
    public void updateZip(int id, String zip){
    	dao.updateZip(id, zip);
    }//close updateZip()
    
    public void deleteCustomer(int id){
    	dao.deleteCustomer(id);
    }//close deleteCustomer


}//class
