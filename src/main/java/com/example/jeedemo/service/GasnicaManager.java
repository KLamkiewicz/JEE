package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Gasnica;
import com.example.jeedemo.domain.Producent;

@Stateless
public class GasnicaManager {
	
	@PersistenceContext
	EntityManager em;
	
	public void addGasnica(Gasnica gasnica) {
		gasnica.setId(null);
		em.persist(gasnica);
	}
	
	public void addProducentToGasnica(Long gasnicaId, Long producentId){
		Gasnica gasnica = em.find(Gasnica.class, gasnicaId);
		Producent producent = em.find(Producent.class, producentId);
		gasnica.setProducent(producent);
	}
	
	@SuppressWarnings("unchecked")
	public List<Gasnica> getAllGasnice(){
		return em.createNamedQuery("gasnica.getAllGasnice").getResultList();
	}

}
