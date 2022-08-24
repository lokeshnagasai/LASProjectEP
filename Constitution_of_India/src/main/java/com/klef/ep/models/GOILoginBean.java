package com.klef.ep.models;

//import java.io.*;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
//import javax.servlet.http.*;

import com.klef.ep.services.GOILoginService;

@ManagedBean(name="goiBean",eager = true)
public class GOILoginBean 
{
   private int Gid;
   private String Gempname;
   private String Gpwd;

public int getGid() {
	return Gid;
}

public void setGid(int gid) {
	Gid = gid;
}

public String getGempname() {
	return Gempname;
}

public void setGempname(String gempname) {
	Gempname = gempname;
}

public String getGpwd() {
	return Gpwd;
}

public void setGpwd(String gpwd) {
	Gpwd = gpwd;
}

@EJB(lookup="java:global/Constitution_of_India/GOILoginServiceImpl!com.klef.ep.services.GOILoginService")
GOILoginService goiService;

public String checkgovtlogin()
{
  String page = null;

   try
   {
    GOILogin govt = new GOILogin();
    govt.setGID(Gid);
    govt.setGEMPNAME(Gempname);
    govt.setGPWD(Gpwd);
    
       
    GOILogin g = goiService.checkgoilogin(govt);
    if(g!=null)
      {
        //System.out.println("Login Success");
    
      page = "govtdashboard.jsf";
      }
      else
      {
        //System.out.println("Login Failed");
      
        page = "goilogin.jsf";
      }       
   }
   catch(Exception e)
   {
     System.out.println(e);
   }
   return page;
    
}
   
}