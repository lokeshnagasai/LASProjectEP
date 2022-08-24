package com.klef.ep.services;

import java.util.*;

import javax.ejb.Remote;

import com.klef.ep.models.Request;

@Remote
public interface RequestService
{
	  public String insertReqAmnd(Request req);
}
