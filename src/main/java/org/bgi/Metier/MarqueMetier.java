package org.bgi.Metier;

import java.text.SimpleDateFormat;
import java.util.List;

import org.bgi.dao.EmplacementsRepostiory;
import org.bgi.dao.FournisseurRepository;
import org.bgi.dao.MaintenanceDAO;
import org.bgi.dao.MarqueRepository;
import org.bgi.entities.Emplacements;
import org.bgi.entities.Logiciels;
import org.bgi.entities.Machine;
import org.bgi.entities.Maintenances;
import org.bgi.entities.Marque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.fabric.xmlrpc.base.Data;

import scala.annotation.meta.setter;

@Service
public class MarqueMetier {

	@Autowired
	private MarqueRepository marqueRepository;

	public Marque saveMArque(Marque e) {

		// e.setDateL(new java.util.Date());

		return marqueRepository.save(e);
	}

	public List<Marque> listMarque() {
		// TODO Auto-generated method stub
		return marqueRepository.findAll();
	}

	public boolean DeleteMarque(Long numMarque) {
		System.out.println("----------------delete -------------------" + numMarque);
		Marque u = marqueRepository.findOne(numMarque);
		if (u != null) {
			System.out.println("------------------------------------------------------+>" + u.toString());
			marqueRepository.delete(u);
			return true;
		} else
			return false;
	}

	public boolean UpdateMarque(Marque emplacmenet) {
		Marque LO = marqueRepository.findOne(emplacmenet.getNumMarque());
		System.out.println("-----------------UPDATE--------------------------->:" + LO.toString());

		LO.setNomMarque(emplacmenet.getNomMarque());

		marqueRepository.save(LO);
		return true;
	}

}
