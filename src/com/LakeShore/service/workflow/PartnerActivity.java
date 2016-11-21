package com.LakeShore.service.workflow;


import com.LakeShore.Manager.PartnerManager;
import com.LakeShore.service.representation.PartnerRepresentation;
import com.LakeShore.Model.Partner;

import java.util.*;

public class PartnerActivity {	
	private static PartnerManager pManager = new PartnerManager();
	
	public PartnerActivity(){
		
	}//close underloaded constructur
	
	public Set<PartnerRepresentation> getPartners(){
        System.out.println("GET request for all Partners......");
        Set<Partner> Partners = new HashSet<Partner>();

        Set<PartnerRepresentation> PartnerRepresentations = new HashSet<PartnerRepresentation>();

        Partners = pManager.getAllPartners();
        Iterator<Partner> cIterator = Partners.iterator();
        while(cIterator.hasNext()){
            Partner temp = (Partner)cIterator.next();
            PartnerRepresentation partRepTemp = new PartnerRepresentation();
            partRepTemp.setID(temp.getID());
            partRepTemp.setFirstName(temp.getFirstName());
            partRepTemp.setLastName(temp.getLastName());
            partRepTemp.setAddress(temp.getAddress());
            partRepTemp.setPhoneNumber(temp.getPhoneNumber());
            partRepTemp.setCity(temp.getCity());
            partRepTemp.setState(temp.getState());
            partRepTemp.setZip(temp.getZip());
            partRepTemp.setCompany(temp.getCompany());

            PartnerRepresentations.add(partRepTemp);
        }//close while loop

        return PartnerRepresentations;
    }//close getPartners()
    

    public PartnerRepresentation getPartnerById(int id){
        Partner temp = pManager.getPartnerById(id);

        PartnerRepresentation partRep = new PartnerRepresentation();
        partRep.setID(temp.getID());
        partRep.setFirstName(temp.getFirstName());
        partRep.setLastName(temp.getLastName());
        partRep.setAddress(temp.getAddress());
        partRep.setPhoneNumber(temp.getPhoneNumber());
        partRep.setCity(temp.getCity());
        partRep.setState(temp.getState());
        partRep.setZip(temp.getZip());
        partRep.setCompany(temp.getCompany());

        return partRep;

    }//close getPartnerById()

    public PartnerRepresentation createPartner(String firstName, String lastName, String company){
        Partner part = pManager.addPartner(firstName, lastName, company);

        PartnerRepresentation partRep = new PartnerRepresentation();
        
        
        partRep.setID(part.getID());
        partRep.setFirstName(part.getFirstName());
        partRep.setLastName(part.getLastName());

        return partRep;
    }//close createPartner

    public void updatePartnerAddress(String id, String address){
    	pManager.updatePartnerAddress(Integer.valueOf(id), address);    
    }//close updatePartnerAddress()
    
    public void updatePhoneNumber(String id, String phoneNumber){
    	pManager.updatePhoneNumber(Integer.valueOf(id), phoneNumber);
    }//close updatePhoneNumber()
    
    public void updateCity(String id, String city){
    	pManager.updateCity(Integer.valueOf(id), city);
    }//close updateCity()
    
    public void updateState(String id, String state){
    	pManager.updateState(Integer.valueOf(id), state);
    }//close updateState()
    
    public void updateZip(String id, String zip){
    	pManager.updateZip(Integer.valueOf(id), zip);
    }//close updateZip()
    
	
}
