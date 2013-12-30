package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Producent;

@Stateless
public class ProducentManager {

	@PersistenceContext
	EntityManager em;
	
	public void addProducent(Producent producent){
		producent.setId(null);
		em.persist(producent);
	}
	
	public List<Producent> getAllProducenci(){
		return em.createNamedQuery("producent.getProducenci").getResultList();
	}
}
