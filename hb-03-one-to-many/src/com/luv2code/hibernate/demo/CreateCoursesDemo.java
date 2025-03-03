package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		// create session factory
		
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Instructor.class)
									 .addAnnotatedClass(InstructorDetail.class)
									 .addAnnotatedClass(Course.class)
									 .buildSessionFactory();
		
		// create session
		
		Session session = factory.getCurrentSession();
		
		try 
		{			
			
			// start a transaction
			
			session.beginTransaction();
			
			// get the instructor from db
			
			int theId = 3;
			
			Instructor tempInstructor = session.get(Instructor.class, theId);			
			
			// create some courses
			 
			Course tempCourse1 = new Course("Air BNB ball- the ultimate guide for balling in the air");
			
			Course tempCourse2 = new Course("The PINK Pinball - Master class");
			
			// add courses to instructor
			
			tempInstructor.add(tempCourse1);    
			
			tempInstructor.add(tempCourse2);
			
			
			// save the courses
			
			session.save(tempCourse1);
			
			session.save(tempCourse2);
			
			//commit transaction
			
			session.getTransaction().commit();
			
			System.out.println("commiting the transaction is done!!! ");
			
		} 
		finally 
		{
			// add clean up code
			
			session.close();
			
			factory.close();
		
		}
		
		
	}
}
