package com.efrei.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

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
		
		List list = em.createNativeQuery("SELECT * FROM vehicule",Vehicule.class).getResultList();
		
		List<Vehicule> listVehicule = new ArrayList<Vehicule>();
		for (Iterator<Vehicule> it = list.iterator(); it.hasNext();){
			
			listVehicule.add((Vehicule) it.next());
		}
		
		return listVehicule;
	}
	
	public boolean rent(String plateNumber) {
		boolean re = false;
		//TODO 
		List list = em.createNativeQuery("SELECT v FROM vehicule WHERE v.id = :plateNumber").setParameter("plateNumber", plateNumber).getResultList();
	
		for (Iterator it = list.iterator(); it.hasNext();){
			re = true;
			Vehicule vehicule= (Vehicule) it.next();}
		return re;
	}
}
