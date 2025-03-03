package com.luv2code.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course 
{
	
	// define our fields
	
	// define our constructor 
	
	// annotate the fields
	
	// define getters and setters 
	
	// define toString method
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@ManyToOne( cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;
	
	
	
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id")
	private List<Review> reviews;
	
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH} )
	@JoinTable(name = "course_student",
			   joinColumns = @JoinColumn(name="course_id"),
			   inverseJoinColumns = @JoinColumn(name="student_id"))
	private List<Student> students;
	
	
	public Course()
	{
		
	}

	public Course(String title)
	{
		
		this.title = title;
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	
	// add convenience method for the review
	
	public void addReview(Review theReview)
	{
		
		if(reviews == null)
		{
			reviews = new ArrayList<>();
		}
		
		
		reviews.add(theReview);
		
	}

	
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	


	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
	// add a convenience method for adding studnet
	
	public void addStudent(Student theStudent)
	{
		if(  students == null   )
		{
			
			students = new ArrayList<>();
			
		}
		
		students.add(theStudent);
		
	}
	
	
	@Override
	public String toString()
	{
	
		return "Course [id=" + id + ", title=" + title + "]";
	
	}
	
	
	
}
