package org.bgi.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Perepherique implements Serializable {

	

	public Long getNumMateriel() {
		return numMateriel;
	}

	public void setNumMateriel(Long numMateriel) {
		this.numMateriel = numMateriel;
	}

	public String getNomMatriel() {
		return nomMatriel;
	}

	public void setNomMatriel(String nomMatriel) {
		this.nomMatriel = nomMatriel;
	}

	public String getTypeP() {
		return typeP;
	}

	public void setTypeP(String typeP) {
		this.typeP = typeP;
	}

	public int getNumGarantie() {
		return numGarantie;
	}

	public void setNumGarantie(int numGarantie) {
		this.numGarantie = numGarantie;
	}

	public String getEtatMateriel() {
		return etatMateriel;
	}

	public void setEtatMateriel(String etatMateriel) {
		this.etatMateriel = etatMateriel;
	}

	public String getAdrIPMateriel() {
		return AdrIPMateriel;
	}

	public void setAdrIPMateriel(String adrIPMateriel) {
		AdrIPMateriel = adrIPMateriel;
	}

	public Collection<Machine> getMachines() {
		return machines;
	}

	public void setMachines(Collection<Machine> machines) {
		this.machines = machines;
	}

	public Fournisseur getFournisseur1() {
		return fournisseur1;
	}

	public void setFournisseur1(Fournisseur fournisseur1) {
		this.fournisseur1 = fournisseur1;
	}

	public Garantie getGarantie1() {
		return garantie1;
	}

	public void setGarantie1(Garantie garantie1) {
		this.garantie1 = garantie1;
	}

	public Perepherique(Long numMateriel, String nomMatriel, String typeP, int numGarantie, String etatMateriel,
			String adrIPMateriel, Collection<Machine> machines, Fournisseur fournisseur1, Garantie garantie1) {
		super();
		this.numMateriel = numMateriel;
		this.nomMatriel = nomMatriel;
		this.typeP = typeP;
		this.numGarantie = numGarantie;
		this.etatMateriel = etatMateriel;
		this.AdrIPMateriel = adrIPMateriel;
		this.machines = machines;
		this.fournisseur1 = fournisseur1;
		this.garantie1 = garantie1;
	}

	public Perepherique() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numMateriel;

	private String nomMatriel;

	private String typeP;

	private int numGarantie;

	private String etatMateriel;

	private String AdrIPMateriel;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "relier")
	@JsonIgnoreProperties("perepheriques")
	private Collection<Machine> machines;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "NUM_FOURNISSEUR")
	private Fournisseur fournisseur1;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "NUM_GARENTIE")
	private Garantie garantie1;

}
