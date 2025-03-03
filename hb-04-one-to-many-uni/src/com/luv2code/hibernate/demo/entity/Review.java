package com.luv2code.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class Review 
{
	// deifne fields
	
	// define constructors
	
	// define getters and setters 
	
	// define toString method 
	
	// annotate fields 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name ="comment")
	private String comment;
	
	public Review()
	{
		
	}

	public Review(String comment) 
	{
		this.comment = comment;
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString()
	{
		return "Review [id=" + id + ", comment=" + comment + "]";
	}
	
	
	
	

}
