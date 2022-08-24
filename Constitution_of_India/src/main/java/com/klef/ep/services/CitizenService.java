package com.klef.ep.services;

import java.util.*;

import javax.ejb.Remote;

import com.klef.ep.models.Citizen;

@Remote
public interface CitizenService
{
	  public String insertCitizen(Citizen ctzn);
	   public String updateCitizen(Citizen ctzn,int ICAadhaar);
	   public String deleteCitizen(int ICAadhaar);
	   public List<Citizen> viewallcitizens();
	   public Citizen checkcitizenlogin(Citizen ctzn);
}
