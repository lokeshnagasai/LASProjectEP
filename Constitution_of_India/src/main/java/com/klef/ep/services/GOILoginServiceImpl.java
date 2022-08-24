package com.klef.ep.services;

import javax.ejb.*;
import javax.persistence.*;
import com.klef.ep.models.GOILogin;


@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class GOILoginServiceImpl implements GOILoginService 
{

  @Override
  public GOILogin checkgoilogin(GOILogin GL) 
  {
      System.out.println("I am in Check Government Login Method");  
      EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
      EntityManager entityManager = entityManagerFactory.createEntityManager();
      
      
      entityManager.getTransaction().begin();
      Query qry=entityManager.createQuery("select GL from GOILogin GL where GID=? and  GPWD=?");
      qry.setParameter(1, GL.getGID());
      //qry.setParameter(2, GL.getGEMPNAME());
      qry.setParameter(2, GL.getGPWD());
      GOILogin GL1 = null;
      
      if (qry.getResultList().size()==1) 
      {
        GL1 = (GOILogin) qry.getSingleResult();
      }
      
      entityManager.getTransaction().commit();
      
      entityManager.close();
      entityManagerFactory.close();
      
      return GL1;
      
  }

}