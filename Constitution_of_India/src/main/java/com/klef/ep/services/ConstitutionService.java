package com.klef.ep.services;

import java.util.*;

import javax.ejb.Remote;

import com.klef.ep.models.Constitution;

@Remote
public interface ConstitutionService
{
	  public String insertConstitution(Constitution con);
	   public String updateConstitution(Constitution con,int atlno);
	   public List<Constitution> viewallConstitutions();
}
