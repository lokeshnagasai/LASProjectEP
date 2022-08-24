package com.klef.ep.services;

import java.util.List;

import javax.ejb.*;
import javax.persistence.*;

import com.klef.ep.models.Constitution;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ConstitutionServiceImpl implements ConstitutionService
{

	

	@Override
	public String insertConstitution(Constitution con) {
		 EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		    EntityManager entityManager = entityManagerFactory.createEntityManager();
		    
		    
		    entityManager.getTransaction().begin();
		    entityManager.persist(con);
		    entityManager.getTransaction().commit();
		    
		    entityManager.close();
		    entityManagerFactory.close();
		    
		    return "Object Inserted Successfully";
	}

	
	@Override
	public String updateConstitution(Constitution con,int atlno) 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
	    EntityManager entityManager = entityManagerFactory.createEntityManager();
	    
	    
	    entityManager.getTransaction().begin();
	    Constitution c = entityManager.find(Constitution.class,atlno);
	    
	    c.setArticleno(con.getArticleno());
	    c.setAbtarticle(con.getAbtarticle());
	    c.setCategory(con.getCategory());
	    c.setArticleamendment(con.getArticleamendment());
	    
	    entityManager.getTransaction().commit();
	    entityManager.close();
	    entityManagerFactory.close();
	    
	    return "Object Updated Successfully";
	}

	@Override
	public List<Constitution> viewallConstitutions() 
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
	    EntityManager entityManager = entityManagerFactory.createEntityManager();
	    
	    
	    entityManager.getTransaction().begin();
	    Query qry=entityManager.createQuery("select con from Constitution con");
	    List<Constitution> atllist=qry.getResultList();
	    entityManager.getTransaction().commit();
	    
	    entityManager.close();
	    entityManagerFactory.close();
	    
	    return atllist;
		
	}
   
}
