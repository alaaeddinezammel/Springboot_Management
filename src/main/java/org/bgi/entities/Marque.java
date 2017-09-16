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
public class Marque implements Serializable {
	public Long getNumMarque() {
		return numMarque;
	}


	public void setNumMarque(Long numMarque) {
		this.numMarque = numMarque;
	}


	public String getNomMarque() {
		return nomMarque;
	}


	public void setNomMarque(String nomMarque) {
		this.nomMarque = nomMarque;
	}

	@JsonIgnore
	public Collection<Machine> getMachines() {
		return machines;
	}


	public void setMachines(Collection<Machine> machines) {
		this.machines = machines;
	}

	@JsonIgnore
	public Collection<Ecrans> getEcran() {
		return ecran;
	}


	public void setEcran(Collection<Ecrans> ecran) {
		this.ecran = ecran;
	}


	public Marque(Long numMarque, String nomMarque, Collection<Machine> machines, Collection<Ecrans> ecran) {
		super();
		this.numMarque = numMarque;
		this.nomMarque = nomMarque;
		this.machines = machines;
		this.ecran = ecran;
	}


	public Marque() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numMarque;

	private String  nomMarque;

	
	
	@OneToMany(mappedBy="marque", cascade = CascadeType.ALL)
	private Collection<Machine> machines;
	
	
	@OneToMany(mappedBy="marque1", cascade = CascadeType.ALL)
	private Collection<Ecrans> ecran;
}
