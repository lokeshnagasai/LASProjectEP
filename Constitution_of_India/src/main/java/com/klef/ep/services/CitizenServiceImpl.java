package com.klef.ep.services;

import java.util.List;

import javax.ejb.*;
import javax.persistence.*;

import com.klef.ep.models.Citizen;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class CitizenServiceImpl implements CitizenService
{

	

	@Override
	public String insertCitizen(Citizen ctzn) {
		    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		    EntityManager entityManager = entityManagerFactory.createEntityManager();
		    
		    
		    entityManager.getTransaction().begin();
		    entityManager.persist(ctzn);
		    entityManager.getTransaction().commit();
		    
		    entityManager.close();
		    entityManagerFactory.close();
		    
		    return "Object Inserted Successfully";
	}

	@Override
	public String deleteCitizen(int ICAadhaar) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
	    EntityManager entityManager = entityManagerFactory.createEntityManager();
	    
	    
	    entityManager.getTransaction().begin();
	    Citizen c=entityManager.find(Citizen.class,ICAadhaar);
	    entityManager.remove(c);
	    entityManager.getTransaction().commit();
	    
	    entityManager.close();
	    entityManagerFactory.close();
	    
	    return "Object deleted Successfully";
	}
	
	@Override
	public String updateCitizen(Citizen ctzn,int ICAadhaar) 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
	    EntityManager entityManager = entityManagerFactory.createEntityManager();
	    
	    
	    entityManager.getTransaction().begin();
	    Citizen c=entityManager.find(Citizen.class,ICAadhaar);
	    c.setICEmail(ctzn.getICEmail());
	    c.setICGender(ctzn.getICGender());
	    c.setICMobileNo(ctzn.getICMobileNo());
	    c.setICName(ctzn.getICMobileNo());
	    c.setICPwd(ctzn.getICPwd());
	    c.setICAadhaar(ctzn.getICAadhaar());
	    entityManager.getTransaction().commit();
	    
	    entityManager.close();
	    entityManagerFactory.close();
	    
	    return "Object Updated Successfully";
	}

	@Override
	public List<Citizen> viewallcitizens() 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
	    EntityManager entityManager = entityManagerFactory.createEntityManager();
	    
	    
	    entityManager.getTransaction().begin();
	    Query qry=entityManager.createQuery("select ctzn from Citizen ctzn");
	    List<Citizen> ctznlist=qry.getResultList();
	    entityManager.getTransaction().commit();
	    
	    entityManager.close();
	    entityManagerFactory.close();
	    
	    return ctznlist;
		
	}
	public Citizen checkcitizenlogin(Citizen ctzn)
	{
		 System.out.println("I am in Check citizen Login Method");	
		    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		    EntityManager entityManager = entityManagerFactory.createEntityManager();
		    
		    
		    entityManager.getTransaction().begin();
		    Query qry=entityManager.createQuery("select ctzn from Citizen ctzn where ICAadhaar=? and  ICPwd=?");
		    qry.setParameter(1,ctzn.getICAadhaar());
		    qry.setParameter(2,ctzn.getICPwd());
		    
		    Citizen ctzn1 = null;
		    
		    if (qry.getResultList().size()==1) 
		    {
		    	ctzn1 = (Citizen) qry.getSingleResult();
		    }
		    
		    entityManager.getTransaction().commit();
		    
		    entityManager.close();
		    entityManagerFactory.close();
		    
		    return ctzn1;
	}

	
   
}
