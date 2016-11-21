package com.LakeShore.service;

import com.LakeShore.service.workflow.CustomerActivity;
import com.LakeShore.service.representation.CustomerRepresentation;

import javax.ws.rs.Path;import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.HeaderParam;
import java.util.Set;


/**
 * Created by matthewwojkowski on 11/8/16.
 */

@Path("/CustomerService")
public class CustomerResource implements CustomerService {
	
    @GET
    //@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Customers/")
    public Set<CustomerRepresentation> getCustomers(){
    	System.out.println("GET Request for all Customers.....");
        CustomerActivity custActivity = new CustomerActivity();
        return custActivity.getCustomers();
    }//close getCustomers()
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Customers/{id}")
    public CustomerRepresentation getCustomerById(@PathParam("id") String id){
    	System.out.println("GET Request for Customer with id: " + id + ".....");
    	CustomerActivity custActivity = new CustomerActivity();
    	return custActivity.getCustomerById(Integer.valueOf(id));
    }//close getCustomerById()
    
    
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/Customers/")
	public CustomerRepresentation createCustomer(@HeaderParam("FirstName") String firstName, @HeaderParam("LastName") String lastName){
    	
    	CustomerActivity custActivity = new CustomerActivity();
    	return custActivity.createCustomer(firstName, lastName);
    	
    }//close addCustomer
    
    
    //PUT Request to update a user's address based on the parameter given in the header
    @PUT
    @Path("/Customers/address/")
    public void updateCustomerAddress(@HeaderParam("id") String id, @HeaderParam("Address") String address){
    	System.out.println("PUT Request for user id: " + id + ". Update address to: " + address + "....");
    	CustomerActivity custActivity = new CustomerActivity();
    	
    	custActivity.updateCustomerAddress(id,  address);
    	System.out.println("SUCCESS");
    	
    }//close updateCustomerAddress()
    
    @PUT
    @Path("/Customers/phone/")
    public void updatePhoneNumber(@HeaderParam("id") String id, @HeaderParam("Phone") String phone){
    	System.out.println("PUT Request for user id: " + id + ".Update phone number to: " + phone + "........");
    	CustomerActivity custActivity = new CustomerActivity();
    	custActivity.updatePhoneNumber(id, phone);
    }//close updatePhoneNUmber
    
    @PUT
    @Path("/Customers/city/")
    public void updateCity(@HeaderParam("id") String id, @HeaderParam("City") String city){
    	System.out.println("PUT Request for user id: " + id + ". Update city to: " + city + "........");
    	CustomerActivity custActivity = new CustomerActivity();
    	custActivity.updateCity(id, city);
    	System.out.println("SUCCESS");
    }//close updateCity()
    
    @PUT
    @Path("/Customers/state/")
    public void updateState(@HeaderParam("id") String id, @HeaderParam("State") String state){
    	System.out.println("PUT Request for user id: " + id + ". Update state to: " + state + "........");
    	CustomerActivity custActivity = new CustomerActivity();
    	custActivity.updateState(id, state);
    	System.out.println("SUCCESS");
    }//close updateState
    
    @PUT
    @Path("/Customers/zip/")
    public void updateZip(@HeaderParam("id") String id, @HeaderParam("Zip") String zip){
    	System.out.println("PUT Request for user id: " + id + ". Update zip code to: " + zip + "........");
    	CustomerActivity custActivity = new CustomerActivity();
    	custActivity.updateZip(id, zip);
    	System.out.println("SUCCESS");
    }//close updateZip()
    
    
    //DELETE Request to update the user's active status to 'false'
    @DELETE
    @Path("/Customers/{id}")
    public void deleteCustomer(@PathParam("id") String id){
    	System.out.println("DELETE Request to delete user with id: " + id + ".........");
    	CustomerActivity custActivity = new CustomerActivity();
    
    	custActivity.deleteCustomer(id);
    	System.out.println("SUCCESS");
    }//close deleteCustomer()
    
    
}//close CustomerResource class
