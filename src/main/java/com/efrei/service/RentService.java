package com.efrei.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.test.context.transaction.TransactionConfiguration;

import com.efrei.domain.Vehicule;

public class RentService {
	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;
	
	public RentService() {
		
		this.emf = Persistence.createEntityManagerFactory("manager1");
		this.em = emf.createEntityManager();
		this.tx = em.getTransaction();
	}
	
	
	
	public List<Vehicule> getVehicules(){
		
		List<Vehicule> list = em.createNativeQuery("SELECT * FROM vehicule where isrented = FALSE",Vehicule.class).getResultList();
		
		List<Vehicule> listVehicule = new ArrayList<Vehicule>();
		for (Iterator<Vehicule> it = list.iterator(); it.hasNext();){
			
			listVehicule.add(it.next());
		}
		
		return list;
	}
	
	public Vehicule getCar(String plateNumber) {	
		//boolean re = false;
		Vehicule result = new Vehicule();
		
		List list1 = em.createNativeQuery("SELECT id FROM vehicule WHERE plateNumber = ?1").setParameter(1, plateNumber).getResultList();
		
		long id = (long) list1.iterator().next();
	
		
		result = em.find(Vehicule.class, id);
		
		return  result;
	}
	

	public  void rent(String plateNumber) {
		Vehicule result = new Vehicule();
		List list1 = em.createNativeQuery("SELECT id FROM vehicule WHERE plateNumber = ?1").setParameter(1, plateNumber).getResultList();		
		long id = (long) list1.iterator().next();
		result = em.find(Vehicule.class, id);
		result.setRented(true);
		em.refresh(result);
		
		
	}
	
	
}
