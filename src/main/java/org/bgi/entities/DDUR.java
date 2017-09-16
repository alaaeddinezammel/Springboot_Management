package org.bgi.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class DDUR implements Serializable {

	
	public Long getNumDD() {
		return numDD;
	}


	public void setNumDD(Long numDD) {
		this.numDD = numDD;
	}


	public String getCapacite() {
		return Capacite;
	}


	public void setCapacite(String capacite) {
		Capacite = capacite;
	}


	public String getTypeDD() {
		return typeDD;
	}


	public void setTypeDD(String typeDD) {
		this.typeDD = typeDD;
	}


	public String getEtatDD() {
		return EtatDD;
	}


	public void setEtatDD(String etatDD) {
		EtatDD = etatDD;
	}

	@JsonIgnore
	public Collection<Machine> getMachines() {
		return machines;
	}


	public void setMachines(Collection<Machine> machines) {
		this.machines = machines;
	}


	public DDUR(Long numDD, String capacite, String typeDD, String etatDD, Collection<Machine> machines) {
		super();
		this.numDD = numDD;
		Capacite = capacite;
		this.typeDD = typeDD;
		EtatDD = etatDD;
		this.machines = machines;
	}


	public DDUR() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numDD;
	
	private String Capacite;
	
	private String typeDD;
	
	private String EtatDD;
	
	
	@OneToMany(mappedBy="ddur", cascade = CascadeType.ALL)
	private Collection<Machine> machines;
	
	
}
