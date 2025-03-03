package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCoursesAndStudentsDemo
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
									 .addAnnotatedClass(Review.class)
									 .addAnnotatedClass(Student.class)
									 .buildSessionFactory();
		
		// create session
		
		Session session = factory.getCurrentSession();
		
		try 
		{			
			
			// start a transaction
			
			session.beginTransaction();
			
			
			// create a course 
			Course tempCourse = new Course("Patrick videos : good knowledge gaining");
		
			System.out.println("\n Saving the course ");			
			
			session.save(tempCourse);
			
			System.out.println("Saved Course is :"+tempCourse);
			
			// create students
			
			Student tempStudent1 = new Student("Vijaya", "Gummadi", "vijay@Luv2code.com");
			
			Student tempStudent2 = new Student("Donald", "Trump", "Trump@Luv2code.com");
			
			Student tempStudent3 = new Student("Berny", "Sanders", "Sanders@Luv2code.com");
			
			
			// add the studnets to the course 
			
			tempCourse.addStudent(tempStudent1);  tempCourse.addStudent(tempStudent2);
			
			tempCourse.addStudent(tempStudent3);
			
			// save the studnets
			
			System.out.println("Saving the students");
			
			session.save(tempStudent1);	session.save(tempStudent2);
			
			session.save(tempStudent3);
			
			
			System.out.println("Saved Students : "+tempCourse.getStudents());
			
			
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
