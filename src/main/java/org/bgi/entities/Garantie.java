package org.bgi.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Garantie implements Serializable {
	public Long getNumGarentie() {
		return numGarentie;
	}

	public void setNumGarentie(Long numGarentie) {
		this.numGarentie = numGarentie;
	}

	public java.util.Date getDateDebutGarentie() {
		return dateDebutGarentie;
	}

	public void setDateDebutGarentie(java.util.Date dateDebutGarentie) {
		this.dateDebutGarentie = dateDebutGarentie;
	}

	public String getDureeGarentie() {
		return dureeGarentie;
	}

	public void setDureeGarentie(String dureeGarentie) {
		this.dureeGarentie = dureeGarentie;
	}

	public String getTypeGarentie() {
		return TypeGarentie;
	}

	public void setTypeGarentie(String typeGarentie) {
		TypeGarentie = typeGarentie;
	}
	@JsonIgnore
	public Collection<Machine> getMachines() {
		return machines;
	}
	
	public void setMachines(Collection<Machine> machines) {
		this.machines = machines;
	}
	@JsonIgnore
	public Collection<Perepherique> getPerepherique() {
		return perepherique;
	}

	public void setPerepherique(Collection<Perepherique> perepherique) {
		this.perepherique = perepherique;
	}
	@JsonIgnore
	public Collection<Ecrans> getEcran() {
		return ecran;
	}

	public void setEcran(Collection<Ecrans> ecran) {
		this.ecran = ecran;
	}

	public Garantie(Long numGarentie, Date dateDebutGarentie, String dureeGarentie, String typeGarentie,
			Collection<Machine> machines, Collection<Perepherique> perepherique, Collection<Ecrans> ecran) {
		super();
		this.numGarentie = numGarentie;
		this.dateDebutGarentie = dateDebutGarentie;
		this.dureeGarentie = dureeGarentie;
		TypeGarentie = typeGarentie;
		this.machines = machines;
		this.perepherique = perepherique;
		this.ecran = ecran;
	}

	public Garantie() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numGarentie;
	
	
	private java.util.Date dateDebutGarentie;
	
	private String dureeGarentie;
	
	
	private String TypeGarentie;

	
	@OneToMany(mappedBy="garantie", cascade = CascadeType.ALL)
	private Collection<Machine> machines;

	@OneToMany(mappedBy="garantie1", cascade = CascadeType.ALL)
	private Collection<Perepherique> perepherique;

	@OneToMany(mappedBy="garantie2", cascade = CascadeType.ALL)
	private Collection<Ecrans> ecran;
}
