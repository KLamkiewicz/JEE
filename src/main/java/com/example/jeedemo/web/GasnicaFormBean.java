package com.example.jeedemo.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Gasnica;
import com.example.jeedemo.domain.Producent;
import com.example.jeedemo.service.GasnicaManager;
import com.example.jeedemo.service.ProducentManager;

@SessionScoped
@Named("gasnicaBean")
public class GasnicaFormBean implements Serializable {

	private Gasnica gasnica = new Gasnica();
	private ListDataModel<Gasnica> gasnice = new ListDataModel<Gasnica>();
	
	private Long gasnicaId = (long) 1;
	private Long producentId;
	
	@Inject
	GasnicaManager gm;
	@Inject
	ProducentManager pm;
	
	public Gasnica getGasnica() {
		return gasnica;
	}
	
	public void setGasnica(Gasnica gasnica) {
		this.gasnica = gasnica;
	}
		
	// Actions
	public String addGasnica() {
		gm.addGasnica(gasnica);
		gm.addProducentToGasnica(gasnica.getId(), producentId);
		//return "showGasnice";
		return null;
	}
	
	public ListDataModel<Gasnica> getAllGasnice() {
		gasnice.setWrappedData(gm.getAllGasnice());
		return gasnice;
	}

	public Long getGasnicaId() {
		return gasnicaId;
	}

	public void setGasnicaId(Long gasnicaId) {
		this.gasnicaId = gasnicaId;
	}

	public Long getProducentId() {
		return producentId;
	}

	public void setProducentId(Long producentId) {
		this.producentId = producentId;
	}
	
	public List<Producent> getAllProducenci(){
		return pm.getAllProducenci();
	}

}
