package org.bgi.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ecrans implements Serializable {
	

	public Long getNumEcran() {
		return numEcran;
	}

	public void setNumEcran(Long numEcran) {
		this.numEcran = numEcran;
	}

	public Long getTailleEcran() {
		return tailleEcran;
	}

	public void setTailleEcran(Long tailleEcran) {
		this.tailleEcran = tailleEcran;
	}
	@JsonIgnore
	public Collection<Machine> getMachines() {
		return machines;
	}

	public void setMachines(Collection<Machine> machines) {
		this.machines = machines;
	}

	public Garantie getGarantie2() {
		return garantie2;
	}

	public void setGarantie2(Garantie garantie2) {
		this.garantie2 = garantie2;
	}

	public Marque getMarque1() {
		return marque1;
	}

	public void setMarque1(Marque marque1) {
		this.marque1 = marque1;
	}

	public Fournisseur getFournisseur2() {
		return fournisseur2;
	}

	public void setFournisseur2(Fournisseur fournisseur2) {
		this.fournisseur2 = fournisseur2;
	}

	public Ecrans(Long numEcran, Long tailleEcran, Collection<Machine> machines, Garantie garantie2, Marque marque1,
			Fournisseur fournisseur2) {
		super();
		this.numEcran = numEcran;
		this.tailleEcran = tailleEcran;
		this.machines = machines;
		this.garantie2 = garantie2;
		this.marque1 = marque1;
		this.fournisseur2 = fournisseur2;
	}

	public Ecrans() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numEcran;
	
	
	private Long tailleEcran;

	
	
	@OneToMany(mappedBy="ecran", cascade = CascadeType.ALL)
	private Collection<Machine> machines;

	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="NUM_GARENTIE")
	private Garantie garantie2;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="NUM_MARQUE")
	private Marque marque1;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="NUM_FOURNISSEUR")
	private Fournisseur fournisseur2;
	
}
