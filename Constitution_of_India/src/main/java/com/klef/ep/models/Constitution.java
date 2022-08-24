package com.klef.ep.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="ListofArticles")
public class Constitution implements Serializable
{
		private static final long serialVersionUID = 1L;
	    @Id
	    @Column(name="article_number")
	    private int articleno;
	    
		@Column(name="about_article")
	    private String abtarticle;
	    
	    @Column(name="Category")
	    private String category;
	    
	    @Column(name="article_amendment")
	    private String articleamendment;

		public int getArticleno() {
			return articleno;
		}

		public void setArticleno(int articleno) {
			this.articleno = articleno;
		}

		public String getAbtarticle() {
			return abtarticle;
		}

		public void setAbtarticle(String abtarticle) {
			this.abtarticle = abtarticle;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public String getArticleamendment() {
			return articleamendment;
		}

		public void setArticleamendment(String articleamendment) {
			this.articleamendment = articleamendment;
		}
	   

}
