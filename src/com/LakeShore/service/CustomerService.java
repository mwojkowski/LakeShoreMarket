package com.LakeShore.service;

import com.LakeShore.service.representation.CustomerRepresentation;
import com.LakeShore.service.representation.CustomerRequest;

import javax.jws.WebService;

import java.util.Set;

/**
 * Created by matthewwojkowski on 11/8/16.
 */
public interface CustomerService {
    public Set<CustomerRepresentation> getCustomers();
    public CustomerRepresentation getCustomerById(String id);
    public CustomerRepresentation createCustomer(String firstName, String lastName);
    public void updateCustomerAddress(String id, String address);
    public void updatePhoneNumber(String id, String phoneNumber);
    public void updateCity(String id, String city);
    public void updateState(String id, String state);
    public void updateZip(String id, String zip);
    
    
    public void deleteCustomer(String id);
    
    
    //public CustomerRepresentation createCustomer(CustomerRequest cRequest);
}//close interface
