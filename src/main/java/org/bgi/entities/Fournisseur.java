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
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Fournisseur implements Serializable {
	
	public Long getNumF() {
		return numF;
	}


	public void setNumF(Long numF) {
		this.numF = numF;
	}


	public String getNomF() {
		return nomF;
	}


	public void setNomF(String nomF) {
		this.nomF = nomF;
	}


	public String getAdrF() {
		return adrF;
	}


	public void setAdrF(String adrF) {
		this.adrF = adrF;
	}


	public int getCodepF() {
		return codepF;
	}


	public void setCodepF(int codepF) {
		this.codepF = codepF;
	}


	public int getTelF() {
		return telF;
	}


	public void setTelF(int telF) {
		this.telF = telF;
	}

	@JsonIgnore
	public Collection<Machine> getMachines() {
		return machines;
	}

	@JsonSetter
	public void setMachines(Collection<Machine> machines) {
		this.machines = machines;
	}

	@JsonIgnore
	public Collection<Perepherique> getPerepherique() {
		return perepherique;
	}

@JsonSetter
	public void setPerepherique(Collection<Perepherique> perepherique) {
		this.perepherique = perepherique;
	}

	@JsonIgnore
	public Collection<Ecrans> getEcran() {
		return ecran;
	}

	@JsonSetter
	public void setEcran(Collection<Ecrans> ecran) {
		this.ecran = ecran;
	}


	public Fournisseur(Long numF, String nomF, String adrF, int codepF, int telF, Collection<Machine> machines,
			Collection<Perepherique> perepherique, Collection<Ecrans> ecran) {
		super();
		this.numF = numF;
		this.nomF = nomF;
		this.adrF = adrF;
		this.codepF = codepF;
		this.telF = telF;
		this.machines = machines;
		this.perepherique = perepherique;
		this.ecran = ecran;
	}


	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numF;
	
	private String nomF;

	private String adrF;
	
	private int  codepF;
	
	private int  telF;

	@OneToMany(mappedBy="fournisseur", cascade = CascadeType.ALL)

	private Collection<Machine> machines;


	@OneToMany(mappedBy="fournisseur1" , cascade = CascadeType.ALL)
	private Collection<Perepherique> perepherique;
	
	
	@OneToMany(mappedBy="fournisseur2", cascade = CascadeType.ALL)
	private Collection<Ecrans> ecran;
	
}
