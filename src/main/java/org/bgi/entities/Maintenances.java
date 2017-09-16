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
public class Maintenances implements Serializable {

	public Long getNumMaintenance() {
		return numMaintenance;
	}

	public void setNumMaintenance(Long numMaintenance) {
		this.numMaintenance = numMaintenance;
	}

	public java.util.Date getDateDebutMaint() {
		return dateDebutMaint;
	}

	public void setDateDebutMaint(java.util.Date dateDebutMaint) {
		this.dateDebutMaint = dateDebutMaint;
	}

	public java.util.Date getDateFinMaint() {
		return dateFinMaint;
	}

	public void setDateFinMaint(java.util.Date dateFinMaint) {
		this.dateFinMaint = dateFinMaint;
	}

	public String getCommentaire() {
		return Commentaire;
	}

	public void setCommentaire(String commentaire) {
		Commentaire = commentaire;
	}
	@JsonIgnore
	public Collection<Machine> getMachines() {
		return machines;
	}

	public void setMachines(Collection<Machine> machines) {
		this.machines = machines;
	}

	public Maintenances(Long numMaintenance, Date dateDebutMaint, Date dateFinMaint, String commentaire,
			Collection<Machine> machines) {
		super();
		this.numMaintenance = numMaintenance;
		this.dateDebutMaint = dateDebutMaint;
		this.dateFinMaint = dateFinMaint;
		this.Commentaire = commentaire;
		this.machines = machines;
	}

	public Maintenances() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numMaintenance;
	
	private java.util.Date dateDebutMaint;

	
	private java.util.Date dateFinMaint;

	
	private String Commentaire;

	@OneToMany(mappedBy="maintenance", cascade = CascadeType.ALL)
	private Collection<Machine> machines;
	
}
