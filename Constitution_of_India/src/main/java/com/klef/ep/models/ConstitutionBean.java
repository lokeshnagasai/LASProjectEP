package com.klef.ep.models;

import javax.ejb.*;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;

import com.klef.ep.services.ConstitutionService;

@ManagedBean(name = "conBean",eager = true)
public class ConstitutionBean 
{
    
	private String response;
	private int ArticleNo;
    private String AbtArticle;
    private String Category;
    private String ArticleAmendment;

   
   @EJB(lookup = "java:global/Constitution_of_India/ConstitutionServiceImpl!com.klef.ep.services.ConstitutionService")
   ConstitutionService constitutionService;
   
     
   public int getArticleNo() {
	return ArticleNo;
}

public void setArticleNo(int articleNo) {
	ArticleNo = articleNo;
}

public String getAbtArticle() {
	return AbtArticle;
}

public void setAbtArticle(String abtArticle) {
	AbtArticle = abtArticle;
}

public String getCategory() {
	return Category;
}

public void setCategory(String category) {
	Category = category;
}

public String getArticleAmendment() {
	return ArticleAmendment;
}

public void setArticleAmendment(String articleAmendment) {
	ArticleAmendment = articleAmendment;
}

public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
   
  public void insertConstitution()
  {
    try
    {
      Constitution con = new Constitution();
      con.setArticleno(ArticleNo);
      con.setAbtarticle(AbtArticle);
      con.setCategory(Category);
      con.setArticleamendment(ArticleAmendment);
      response = constitutionService.insertConstitution(con);
    }
    
    catch(Exception e)
    {
      response=e.getMessage();
    }
  }
  
  public void updateConstitution()
	{
		try
		{
			Constitution con = new Constitution();
			con.setArticleno(ArticleNo);
		    con.setAbtarticle(AbtArticle);
		    con.setCategory(Category);
		    con.setArticleamendment(ArticleAmendment);
		      
			response=constitutionService.updateConstitution(con, ArticleNo);
		}
		catch(Exception e)
		{
			response=e.getMessage();
		}
	}
	public void viewallConstitutions()
	{
		try
		{
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}