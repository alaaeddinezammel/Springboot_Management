package org.bgi.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Logiciels implements Serializable  {
	


	public Long getNumL() {
		return numL;
	}

	public void setNumL(Long numL) {
		this.numL = numL;
	}
	


	public String getNomL() {
		return nomL;
	}


	public void setNomL(String nomL) {
		this.nomL = nomL;
	}


	public String getTypeL() {
		return typeL;
	}


	public void setTypeL(String typeL) {
		this.typeL = typeL;
	}


	public Long getLicenceL() {
		return licenceL;
	}


	public void setLicenceL(Long licenceL) {
		this.licenceL = licenceL;
	}


	public Long getVersionL() {
		return versionL;
	}


	public void setVersionL(Long versionL) {
		this.versionL = versionL;
	}


	public String getEditeurL() {
		return editeurL;
	}


	public void setEditeurL(String editeurL) {
		this.editeurL = editeurL;
	}


	public Long getNumSerl() {
		return numSerl;
	}


	public void setNumSerl(Long numSerl) {
		this.numSerl = numSerl;
	}


	public java.util.Date getDateL() {
		return dateL;
	}


	public void setDateL(java.util.Date dateL) {
		this.dateL = dateL;
	}

	
	public Collection<Machine> getMachines() {
		return machines;
	}


	public void setMachines(Collection<Machine> machines) {
		this.machines = machines;
	}




	public Logiciels() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numL;
	
	private String nomL;

	private String typeL;
	
	
	private Long licenceL;
	
	private Long versionL;
	
	private String editeurL;
	
	private Long numSerl;
	
	private java.util.Date dateL;
	
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="installer")
	@JsonIgnoreProperties("logiciels")
	private Collection<Machine> machines;


	





	public Logiciels(String nomL, String typeL, Long licenceL, Long versionL, String editeurL, Long numSerl,
			Date dateL) {
		super();
		this.nomL = nomL;
		this.typeL = typeL;
		this.licenceL = licenceL;
		this.versionL = versionL;
		this.editeurL = editeurL;
		this.numSerl = numSerl;
		this.dateL = dateL;
	}
	
	
	

}
