package com.klef.ep.models;

import java.util.List;

import javax.ejb.*;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Id;

import com.klef.ep.services.CitizenService;

@ManagedBean(name = "ctznBean",eager = true)
public class CitizenBean 
{
    
	private String response;
	private String ICmobileno;
    private int ICaadhaar;
    private String ICemail;
    private String ICpwd;
	 private String ICname;
    private String ICgender;
    private String ICstate;
	  
    
    public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getICmobileno() {
		return ICmobileno;
	}

	public void setICmobileno(String iCmobileno) {
		ICmobileno = iCmobileno;
	}

	public int getICaadhaar() {
		return ICaadhaar;
	}

	public void setICaadhaar(int iCaadhaar) {
		ICaadhaar = iCaadhaar;
	}

	public String getICemail() {
		return ICemail;
	}

	public void setICemail(String iCemail) {
		ICemail = iCemail;
	}

	public String getICpwd() {
		return ICpwd;
	}

	public void setICpwd(String iCpwd) {
		ICpwd = iCpwd;
	}

	public String getICname() {
		return ICname;
	}

	public void setICname(String iCname) {
		ICname = iCname;
	}

	public String getICgender() {
		return ICgender;
	}

	public void setICgender(String iCgender) {
		ICgender = iCgender;
	}

	public String getICstate() {
		return ICstate;
	}

	public void setICstate(String iCstate) {
		ICstate = iCstate;
	}
	@EJB(lookup = "java:global/Constitution_of_India/CitizenServiceImpl!com.klef.ep.services.CitizenService")
    CitizenService citizenService;
    
   
	 public void insertcitizen()
	  {
	    try
	    {
	      Citizen ctzn = new Citizen();
	      ctzn.setICAadhaar(ICaadhaar);
	      ctzn.setICEmail(ICemail);;
	     ctzn.setICGender(ICgender);
	     ctzn.setICMobileNo(ICmobileno);
	     ctzn.setICName(ICname);
	     ctzn.setICPwd(ICpwd);
	     ctzn.setICState(ICstate);
	     response =citizenService.insertCitizen(ctzn);
	    }
	    catch(Exception e)
	    {
	      response=e.getMessage();
	    }
	  }
  
  public void updatecitizen()
	{
		try
		{
			 Citizen ctzn = new Citizen();
			 ctzn.setICAadhaar(ICaadhaar);
		      ctzn.setICEmail(ICemail);;
		     ctzn.setICGender(ICgender);
		     ctzn.setICMobileNo(ICmobileno);
		     ctzn.setICName(ICname);
		     ctzn.setICPwd(ICpwd);
		     ctzn.setICState(ICstate);
			response=citizenService.updateCitizen(ctzn, ICaadhaar);
		}
		catch(Exception e)
		{
			response=e.getMessage();
		}
	}
	public void deletecitizen()
	{
		try
		{
			response=citizenService.deleteCitizen(ICaadhaar);
		}
		catch(Exception e)
		{
			response=e.getMessage();
		}
	}
	public List<Citizen> viewallCitizens()
	{
		List<Citizen> lc = null;
		try
		{
			
      lc = citizenService.viewallcitizens();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	      return lc;

	}

public String checkcitizen()
{
	String page = null;

   try
   {
	   Citizen ctzn=new Citizen();
		 ctzn.setICAadhaar(ICaadhaar);
	      ctzn.setICEmail(ICemail);;
	     ctzn.setICGender(ICgender);
	     ctzn.setICMobileNo(ICmobileno);
	     ctzn.setICName(ICname);
	     ctzn.setICPwd(ICpwd);
	     ctzn.setICState(ICstate);
	   	Citizen c=citizenService.checkcitizenlogin(ctzn);
		
		if(c!=null)
	    {
	  	  //System.out.println("Login Success");
			
			page = "indiancitizendashboard.jsf";
	    }
	    else
	    {
	  	  //System.out.println("Login Failed");
	    
	    	page = "indiancitizenlogin.jsf";
	    }		   
   }
   catch(Exception e)
   {
	   System.out.println(e);
   }
   return page;
    
}
   
	
}