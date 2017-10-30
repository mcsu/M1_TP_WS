package com.efrei.wstp1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.efrei.domain.Car;
import com.efrei.domain.Person;
import com.efrei.domain.Vehicule;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
   
    		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");

		EntityManager entityManager = emf.createEntityManager();
		
		EntityTransaction tx = entityManager.getTransaction();
		
    	try{
    		
			tx.begin();
			
			Person p = new Person();
			p.setName("Tintin");
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date beginDate = dateFormat.parse("23/09/2015");
			p.setDate(beginDate);
			
		
			Vehicule v3 = new Vehicule();
			v3.setPlateNumber("AA11AA");
			
			
			
			
			
		
		
			
			entityManager.persist(v3);
			tx.commit();			
		
		}catch(Exception e){
			tx.rollback();
		}
		
	}
}
