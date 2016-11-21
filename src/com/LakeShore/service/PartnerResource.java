package com.LakeShore.service;

import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.LakeShore.service.representation.PartnerRepresentation;
import com.LakeShore.service.workflow.PartnerActivity;

@Path("/PartnerService")
public class PartnerResource implements PartnerService {

	@GET
    //@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Partners/")
    public Set<PartnerRepresentation> getPartners(){
    	System.out.println("GET Request for all Partners.....");
        PartnerActivity custActivity = new PartnerActivity();
        return custActivity.getPartners();
    }//close getPartners()
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Partners/{id}")
    public PartnerRepresentation getPartnerById(@PathParam("id") String id){
    	System.out.println("GET Request for Partner with id: " + id + ".....");
    	PartnerActivity custActivity = new PartnerActivity();
    	return custActivity.getPartnerById(Integer.valueOf(id));
    }//close getPartnerById()
    
    
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/Partners/")
	public PartnerRepresentation createPartner(@HeaderParam("FirstName") String firstName, @HeaderParam("LastName") String lastName,
			@HeaderParam("Company") String company){
    	
    	PartnerActivity custActivity = new PartnerActivity();
    	return custActivity.createPartner(firstName, lastName, company);
    	
    }//close addPartner
    
    
    //PUT Request to update a user's address based on the parameter given in the header
    @PUT
    @Path("/Partners/address/")
    public void updatePartnerAddress(@HeaderParam("id") String id, @HeaderParam("Address") String address){
    	System.out.println("PUT Request for user id: " + id + ". Update address to: " + address + "....");
    	PartnerActivity custActivity = new PartnerActivity();
    	
    	custActivity.updatePartnerAddress(id,  address);
    	
    }//close updatePartnerAddress()
    
    @PUT
    @Path("/Partners/phone/")
    public void updatePhoneNumber(@HeaderParam("id") String id, @HeaderParam("Phone") String phone){
    	System.out.println("PUT Request for user id: " + id + ".Update phone number to: " + phone + "........");
    	PartnerActivity custActivity = new PartnerActivity();
    	custActivity.updatePhoneNumber(id, phone);
    }//close updatePhoneNUmber
    
    @PUT
    @Path("/Partners/city/")
    public void updateCity(@HeaderParam("id") String id, @HeaderParam("City") String city){
    	System.out.println("PUT Request for user id: " + id + ". Update city to: " + city + "........");
    	PartnerActivity custActivity = new PartnerActivity();
    	custActivity.updateCity(id, city);
    }//close updateCity()
    
    @PUT
    @Path("/Partners/state/")
    public void updateState(@HeaderParam("id") String id, @HeaderParam("State") String state){
    	System.out.println("PUT Request for user id: " + id + ". Update state to: " + state + "........");
    	PartnerActivity custActivity = new PartnerActivity();
    	custActivity.updateState(id, state);
    }//close updateState
    
    @PUT
    @Path("/Partners/zip/")
    public void updateZip(@HeaderParam("id") String id, @HeaderParam("Zip") String zip){
    	System.out.println("PUT Request for user id: " + id + ". Update zip code to: " + zip + "........");
    	PartnerActivity custActivity = new PartnerActivity();
    	custActivity.updateZip(id, zip);
    }//close updateZip()
    
    
    
	
}//close PartnerResource

