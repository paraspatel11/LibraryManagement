package ca.sheridancollege.dao;


import java.util.*;

import javax.persistence.Query;
import org.hibernate.*;
import org.hibernate.cfg.*;
import ca.sheridancollege.beans.*;


public class Dao {

	SessionFactory sessionFactory = new Configuration().
			configure("hibernate.cfg.xml").buildSessionFactory();


	public boolean addLocation(Location location) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(location);
		
		session.getTransaction().commit();
		session.close();
		
		if(location!=null)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
// *******************************************************************************8	
	
	public boolean addBook(Book book) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		session.save(book);
		
		session.getTransaction().commit();
		session.close();
		
		if(book!=null)
		{
			return true;
			
		}
		else
		{
			return false;
		}
		
	}
	
// *******************************************************************************8	

	public List<String> listOfLocation() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<String> locationList;
		Query query = session.createQuery("select locationName from Location");
		
		locationList= query.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		return locationList;
	}
	
// *******************************************************************************8	

	public void generateRecords() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
			Location location1 = new Location("Seneca College", "North York", "273846", "9:00-17:00");
			addLocation(location1);
			
			Book book1 = new Book("The History of Tom Jones", "Henry Fielding", "Comedy", "Seneca College");
			Book book2 = new Book("Pride and Prejudice", "Jane Austen", "Horror", "Seneca College");
			Book book3 = new Book("Le Rouge", "Stendhal", "Action", "Seneca College");
			
			addBook(book1);
			addBook(book2);
			addBook(book3);
			
//*******************************************************************************************************************************			
			Location location2 = new Location("Sheridan College", "Oakville", "12345", "12:00-21:00");
			addLocation(location2);

			Book book4 = new Book("Le Père", "Henry Fielding", "Comedy", "Sheridan College");
			Book book5 = new Book("David Copperfield", "Jane Austen", "Horror", "Sheridan College");
			Book book6 = new Book("Madame Bovary", "Stendhal", "Action", "Sheridan College");
			
			addBook(book4);
			addBook(book5);
			addBook(book6);
			
//*******************************************************************************************************************************			
			Location location3 = new Location("Humber College", "Toronto", "982236", "8:00-21:00");
			addLocation(location3);
			
			Book book7 = new Book("Moby-Dick", "Henry Fielding", "Comedy", "Humber College");
			Book book8 = new Book("Wuthering Heights", "Jane Austen", "Horror", "Humber College");
			Book book9 = new Book("Harry Potter", "JK Rowling", "Action", "Humber College");
			
			
			addBook(book7);
			addBook(book8);
			addBook(book9);
		
		
		
		session.getTransaction().commit();
		session.close();
	}

//*******************************************************************************************************************************			

	
	public List<Book> getBooks(String location){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<Book> bookList;
		
		Query query = session.createQuery("from Book where location =:location");
		query.setParameter("location", location);
		
		bookList= query.getResultList();
		
		
		session.getTransaction().commit();
		session.close();
		
		return bookList;
	}
//******************************************************************************8	
	public void deleteBookById(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Book book = (Book)session.get(Book.class, id);
		session.delete(book);
		
		session.getTransaction().commit();
		session.close();
	}
	
//******************************************************************************8	
	
	public List<Book> searchBookName(String search) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<Book> bookList;
		
		Query query = session.createQuery("from Book where bookName =:bookName");
		query.setParameter("bookName", search);
		
		bookList= query.getResultList();
		
		
		session.getTransaction().commit();
		session.close();
		
		return bookList;
	}
}
