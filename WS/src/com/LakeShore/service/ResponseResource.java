package com.LakeShore.service;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.LakeShore.service.representation.CustomerRepresentation;
import com.LakeShore.service.representation.PartnerRepresentation;
import com.LakeShore.service.representation.ResponseRepresentation;
import com.LakeShore.service.workflow.CustomerActivity;
import com.LakeShore.service.workflow.PartnerActivity;
import com.LakeShore.service.workflow.ResponseActivity;

import javax.ws.rs.HeaderParam;
import java.util.Set;


@Path("/API/")
public class ResponseResource implements ResponseService{
	
	
	/*
	 * 
	 * (non-Javadoc)
	 * @see com.LakeShore.service.ResponseService#sayHi()
	 * 
	 * CUSTOMER API METHODS
	 */
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Customers/")
    public ResponseRepresentation getCustomers(){
    	System.out.println("GET Request for all Customers.....");
    	ResponseActivity respAct = new ResponseActivity();
    	
    	ResponseRepresentation temp = new ResponseRepresentation();
    	temp.addCustomers(respAct.getCustomers());
    	
    	
    	return temp;
    }//close getCustomers()
	
	@GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Customers/{id}")
    public ResponseRepresentation getCustomerById(@PathParam("id") String id){
    	System.out.println("GET Request for Customer with id: " + id + ".....");
    	ResponseActivity respActivity = new ResponseActivity();
    	return respActivity.getCustomerById(id);
    }//close getCustomerById()
	
	@PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/Customers/")
	public ResponseRepresentation createCustomer(@HeaderParam("FirstName") String firstName, @HeaderParam("LastName") String lastName){
    	System.out.println("POST Request to create a new Customer........");
    	ResponseActivity respActivity = new ResponseActivity();
    	
    	return respActivity.addCustomer(firstName, lastName);
    }//close addCustomer
	
	//POST Request to update a user's address based on the parameter given in the header
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Customers/address/")
    public ResponseRepresentation updateCustomerAddress(@HeaderParam("id") String id, @HeaderParam("Address") String address){
    	System.out.println("PUT Request for user id: " + id + ". Update address to: " + address + "....");
    	ResponseActivity respActivity = new ResponseActivity();
    	
    	return respActivity.updateAddress(id, address);
    }//close updateCustomerAddress()
    
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Customers/Phone/")
    public ResponseRepresentation updatePhoneNumber(@HeaderParam("id") String id, @HeaderParam("PhoneNumber") String phoneNumber){
    	System.out.println("PUT Request for user id: " + id + ". Update phone number to: " + phoneNumber + "....");
    	ResponseActivity respActivity = new ResponseActivity();
    	
    	return respActivity.updatePhoneNumber(id, phoneNumber);
    }//close updateCustomerAddress()
    
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Customers/City/")
    public ResponseRepresentation updateCity(@HeaderParam("id") String id, @HeaderParam("City") String city){
    	System.out.println("PUT Request for user id: " + id + ". Update address to: " + city + "....");
    	ResponseActivity respActivity = new ResponseActivity();
    	
    	return respActivity.updateCity(id, city);
    }//close updateCustomerAddress()
    
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Customers/State/")
    public ResponseRepresentation updateState(@HeaderParam("id") String id, @HeaderParam("State") String state){
    	System.out.println("PUT Request for user id: " + id + ". Update state to: " + state + "....");
    	ResponseActivity respActivity = new ResponseActivity();
    	
    	return respActivity.updateState(id, state);
    }//close updateCustomerAddress()
    
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Customers/Zip/")
    public ResponseRepresentation updateZip(@HeaderParam("id") String id, @HeaderParam("Zip") String zip){
    	System.out.println("PUT Request for user id: " + id + ". Update zip code to: " + zip + "....");
    	ResponseActivity respActivity = new ResponseActivity();
    	
    	return respActivity.updateAddress(id, zip);
    }//close updateCustomerAddress()
    
    @DELETE
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Customers/{id}")
    public ResponseRepresentation deleteCustomer(@PathParam("id") String id){
    	System.out.println("PUT Request to delete user with id: " + id + "........");
    	ResponseActivity respActivity = new ResponseActivity();
    	
    	return respActivity.deleteCustomer(id);
    }//close updateCustomerAddress()
    
    
    
    /*
     * 
     * 
     * PARTNER API METHODS
     * 
     * 
     */
    
    @GET
    //@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Partners/")
    public ResponseRepresentation getPartners(){
    	System.out.println("GET Request for all Partners.....");
        ResponseActivity respActivity = new ResponseActivity();
        return respActivity.getPartners();
    }//close getPartners()
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Partners/{id}")
    public ResponseRepresentation getPartnerById(@PathParam("id") String id){
    	System.out.println("GET Request to find partner by id: " + id + "........");
    	ResponseActivity respActivity = new ResponseActivity();
    	return respActivity.getPartnerById(id);
    }//close getPartnerById()
    
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Partners/")
    public ResponseRepresentation createPartner(@HeaderParam("FirstName") String firstName, @HeaderParam("LastName") String lastName,
    		@HeaderParam("Company") String company){
    	System.out.println("PUT Request to create a partner with FirstName: " + firstName + ", LastName: " + lastName +" for company: " + company +"........");
    	ResponseActivity respActivity = new ResponseActivity();
    	return respActivity.createPartner(firstName, lastName, company);
    }//close createPartner()
    
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Partners/Address/{id}")
    public ResponseRepresentation updatePartnerAddress(@PathParam("id") String id, @HeaderParam("Address") String address){
    	System.out.println("POST Request to update address to: " + address + " with id: " + id + "........");
    	ResponseActivity respActivity = new ResponseActivity();
    	
    	return respActivity.updatePartnerAddress(id, address);
    }//close updateAddress
    
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Partners/PhoneNumber/{id}")
    public ResponseRepresentation updatePartnerPhoneNumber(@PathParam("id") String id, @HeaderParam("PhoneNumber") String phoneNumber){
    	System.out.println("POST Request to update phone to: " + phoneNumber + " with id: " + id + "........");
    	ResponseActivity respActivity = new ResponseActivity();
    	
    	return respActivity.updatePartnerPhoneNumber(id, phoneNumber);
    }//close updatePartnerPhoneNumber
    
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Partners/City/{id}")
    public ResponseRepresentation updatePartnerCity(@PathParam("id") String id, @HeaderParam("City") String city){
    	System.out.println("POST Request to update city to: " + city + " with id: " + id + "........");
    	ResponseActivity respActivity = new ResponseActivity();
    	
    	return respActivity.updatePartnerCity(id, city);
    }//close updatePartnerPhoneNumber
    
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Partners/State/{id}")
    public ResponseRepresentation updatePartnerState(@PathParam("id") String id, @HeaderParam("State") String state){
    	System.out.println("POST Request to update state to: " + state + " with id: " + id + "........");
    	ResponseActivity respActivity = new ResponseActivity();
    	
    	return respActivity.updatePartnerState(id, state);
    }//close updatePartnerPhoneNumber
    
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Partners/Zip/{id}")
    public ResponseRepresentation updatePartnerZip(@PathParam("id") String id, @HeaderParam("Zip") String zip){
    	System.out.println("POST Request to update zip to: " + zip + " with id: " + id + "........");
    	ResponseActivity respActivity = new ResponseActivity();
    	
    	return respActivity.updatePartnerZip(id, zip);
    }//close updatePartnerPhoneNumber
	
    /*
     * 
     * 
     * PRODUCT API METHODS
     * 
     * 
     */
    
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Products/")
    public ResponseRepresentation createProduct(@HeaderParam("Name") String name, @HeaderParam("Description") String description,
    		@HeaderParam("Seller") String sellerID){
    	System.out.println("PUT Request to create a product with First Name: " + name + "........");
    	ResponseActivity respActivity = new ResponseActivity();
    	return respActivity.newProduct(name, description, sellerID);
    }//close createPartner()
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Products/{id}")
    public ResponseRepresentation getProductById(@PathParam("id") String id){
    	System.out.println("GET Request for product with id: " + id + ".....");
    	ResponseActivity respActivity = new ResponseActivity();
    	return respActivity.getProductById(id);
    }//close getCustomerById()
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Products/Product/")
    public ResponseRepresentation getProductByName(@HeaderParam("Name")String name){
    	System.out.println("GET Request for product with name: " + name + ".....");
    	ResponseActivity respActivity = new ResponseActivity();
    	return respActivity.getProductByName(name);
    }//close getProductByName()
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Products/")
    public ResponseRepresentation getProducts(){
    	System.out.println("GET Request for all products........");
    	ResponseActivity respActivity = new ResponseActivity();
    	return respActivity.getProducts();
    }//close getProductByName()
    
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Products/Name/{id}")
    public ResponseRepresentation updateName(@PathParam("id") String id, @HeaderParam("Name") String name){
    	System.out.println("POST Request: Update Name on " + id + " to; " + name + "........");
    	ResponseActivity respActivity = new ResponseActivity();
    	
    	return respActivity.updateName(id, name);
    }//close updateName
    
    
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Products/Description/{id}")
    public ResponseRepresentation updateDescription(@PathParam("id") String id, @HeaderParam("Description") String description){
    	System.out.println("POST Request: Update Description on " + id + " to; " + description + "........");
    	ResponseActivity respActivity = new ResponseActivity();
    	
    	return respActivity.updateDescription(id, description);
    }//close updateDescription
    
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Products/Quantity/{id}")
    public ResponseRepresentation updateQuantity(@PathParam("id") String id, @HeaderParam("Quantity") String quantity){
    	System.out.println("POST Request: Update Quantity on " + id + " to; " + quantity + "........");
    	ResponseActivity respActivity = new ResponseActivity();
    	
    	return respActivity.updateQuantity(id, quantity);
    }//close updateQuantity
    
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Products/Price/{id}")
    public ResponseRepresentation updatePrice(@PathParam("id") String id, @HeaderParam("Price") String price){
    	System.out.println("POST Request: Update Price on " + id + " to; " + price + "........");
    	ResponseActivity respActivity = new ResponseActivity();
    	
    	return respActivity.updatePrice(id, price);
    }//close updatePrice
    
    
    /*
     * 
     * 
     * ORDER API METHODS
     * 
     * String orderID, String PartnerID, String productID, String quantity, String Price
     */
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Orders/Customer/{id}")
    public ResponseRepresentation getCustomerOrders(@PathParam("id")String customerID){
    	System.out.println("GET Request to get orders for customer: " + customerID + "........");
    	ResponseActivity respActivity = new ResponseActivity();
    	
    	return respActivity.getCustomerOrders(customerID);
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Orders/")
    public ResponseRepresentation createOrder(@HeaderParam("CustomerID") String customerID){
    	System.out.println("PUT Request to create a new order.");
    	ResponseActivity respActivity = new ResponseActivity();
    	
    	return respActivity.createOrder(customerID);
    }//close createOrder
    
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Orders/Deliver/{id}")
    public ResponseRepresentation deliverOrder(@PathParam("id")String orderID){
    	System.out.println("POST Request to deliver order: " + orderID + "........");
    	ResponseActivity respActivity = new ResponseActivity();
    	
    	return respActivity.deliverOrder(orderID);
    }//close deliverOrder
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Orders/Status/{id}")
    public ResponseRepresentation checkStatus(@PathParam("id") String id){
    	System.out.println("Check Status on order with id: " + id + "........");
    	ResponseActivity respActivity = new ResponseActivity();
    	
    	return respActivity.checkStatus(id);
    }//close 
    
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Orders/Process/{id}")
    public ResponseRepresentation processOrder(@PathParam("id")String orderID){
    	System.out.println("POST Request to process order: " + orderID + "........");
    	ResponseActivity respActivity = new ResponseActivity();
    	
    	return respActivity.processOrder(orderID);
    }//close deliverOrder
    
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Orders/Ship/{id}")
    public ResponseRepresentation shipOrder(@PathParam("id")String orderID){
    	System.out.println("POST Request to deliver order: " + orderID + "........");
    	ResponseActivity respActivity = new ResponseActivity();
    	
    	return respActivity.shipOrder(orderID);
    }//close deliverOrder
    
    
    
    
    
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Orders/{id}")
    public ResponseRepresentation addItem(@PathParam("id") String orderID, @HeaderParam("PartnerID")String partnerID,
    		 @HeaderParam("productID")String productID, @HeaderParam("Quantity")String quantity, 
    		 @HeaderParam("Price")String price){
    	System.out.println("PUT Request to add item to order........");
    	ResponseActivity respActivity = new ResponseActivity();
    	
    	return respActivity.addItem(orderID, partnerID, productID, quantity, price);
    }//close addItem
    
    /*@DELETE
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Orders/{id}")
    public ResponseRepresentation removeItem(@PathParam("id") String orderID, @HeaderParam("ProductID")String productID){
    	System.out.println("DELETE Request to remove item from order........");
    	ResponseActivity respActivity = new ResponseActivity();
    	
    	return respActivity.removeItem(orderID, productID);
    }//close removeItem*/
    
    
    @DELETE
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Orders/{id}")
    public ResponseRepresentation cancelOrder(@PathParam("id") String id){
    	System.out.println("DELETE Request to cancel order with id: " + id + "........");
    	ResponseActivity respActivity = new ResponseActivity();
    	
    	return respActivity.cancelOrder(id);
    }//close cancelOrder()
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Orders/{id}")
    public ResponseRepresentation lookupOrder(@PathParam("id")String id){
    	System.out.println("GET Request to lookup order with id: " + id + "........");
    	ResponseActivity respActivity = new ResponseActivity();
    	
    	return respActivity.lookupOrder(id);
    }//close lookupOrder()
    
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Orders/Submit/{id}")
    public ResponseRepresentation submitOrder(@PathParam("id")String id){
    	System.out.println("POST Request to ship order with id: " + id + "........");
    	ResponseActivity respActivity = new ResponseActivity();
    	
    	return respActivity.submitOrder(id);
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Orders/Order/{ProductID}")
    public ResponseRepresentation buyItemNow(@PathParam("ProductID") String productID, @HeaderParam("PartnerID") String partnerID,
    		@HeaderParam("CustomerID") String customerID){
    	System.out.println("PUT Request to buy item: " + productID + "........");
    	ResponseActivity respActivity = new ResponseActivity();
    	
    	return respActivity.buyItemNow(customerID, productID, partnerID);
    }
    
    

}//close Response Resource
