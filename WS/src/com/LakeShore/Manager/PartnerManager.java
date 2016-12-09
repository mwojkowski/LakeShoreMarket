package com.LakeShore.Manager;

import com.LakeShore.DAO.*;
import com.LakeShore.Model.Partner;

import java.util.*;


public class PartnerManager {
	public static PartnerDAO dao = new PartnerDAO();

    public PartnerManager(){

    }//close underloaded Constructor


    public Partner addPartner(String firstName, String lastName, String company){
        Partner x = dao.addPartner(firstName, lastName, company);
        
        return x;
    }//close class

    public Set<Partner> getAllPartners(){

        return dao.getAllPartners();
    }//close getAllCustomers()

    public Partner getPartnerById(int id){

        return dao.getPartnerById(id);
    }//close getCustomerById()
    
    public boolean updatePartnerAddress(int id, String address){
    	return dao.updatePartnerAddress(id, address);
    	
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
    
    
}
