package com.example.jeedemo.web;import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Wlasciciel;
import com.example.jeedemo.service.WlascicielManager;

abstract

@SessionScoped
@Named("wlascicielBean")
public class WlascicielFormBean implements Serializable{

	private Wlasciciel wlasciciel = new Wlasciciel();
	private ListDataModel<Wlasciciel> wlasciciele = new ListDataModel<Wlasciciel>();
	
	@Inject
	WlascicielManager wm;
	
	// Actions
	public String addWlasciciel() {
		wm.addWlasciciel(wlasciciel);
		//return "showGasnice";
		return null;
	}
	
	public Wlasciciel getWlasciciel(){
		return wlasciciel;
	}
	
	public void setWlasciciel(Wlasciciel wlasciciel){
		this.wlasciciel = wlasciciel;
	}
	
	public ListDataModel<Wlasciciel> getAllWlasciciele(){
		wlasciciele.setWrappedData(wm.getAllWlasciciele());
		return wlasciciele;
	}
}
