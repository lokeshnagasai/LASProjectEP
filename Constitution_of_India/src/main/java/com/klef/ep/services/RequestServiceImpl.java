package com.klef.ep.services;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.klef.ep.models.Request;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class RequestServiceImpl implements RequestService
{
	@Override
	public String insertReqAmnd(Request req) {
		    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
		    EntityManager entityManager = entityManagerFactory.createEntityManager();
		    
		    
		    entityManager.getTransaction().begin();
		    entityManager.persist(req);
		    entityManager.getTransaction().commit();
		    
		    entityManager.close();
		    entityManagerFactory.close();
		    
		    return "Object Inserted Successfully";
	}
}
