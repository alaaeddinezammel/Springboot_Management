package org.bgi.Metier;

import java.text.SimpleDateFormat;
import java.util.List;

import org.bgi.dao.EmplacementsRepostiory;
import org.bgi.dao.FournisseurRepository;
import org.bgi.dao.MaintenanceDAO;
import org.bgi.entities.Emplacements;
import org.bgi.entities.Logiciels;
import org.bgi.entities.Machine;
import org.bgi.entities.Maintenances;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.fabric.xmlrpc.base.Data;

import scala.annotation.meta.setter;

@Service
public class MaintenanceMetier {

	@Autowired
	private MaintenanceDAO maintenanceDAO;

	public Maintenances saveMAINT(Maintenances e) {

		// e.setDateL(new java.util.Date());

		return maintenanceDAO.save(e);
	}

	public List<Maintenances> listMAINTt() {
		// TODO Auto-generated method stub
		return maintenanceDAO.findAll();
	}

	public boolean DeleteMAINT(Long numMaintenance) {
		System.out.println("----------------delete -------------------" + numMaintenance);
		Maintenances u = maintenanceDAO.findOne(numMaintenance);
		if (u != null) {
			System.out.println("------------------------------------------------------+>" + u.toString());
			maintenanceDAO.delete(u);
			return true;
		} else
			return false;
	}

	public boolean UpdateMAINT(Maintenances emplacmenet) {
		Maintenances LO = maintenanceDAO.findOne(emplacmenet.getNumMaintenance());
		System.out.println("-----------------UPDATE--------------------------->:" + LO.toString());

		LO.setCommentaire(emplacmenet.getCommentaire());
		LO.setDateDebutMaint(emplacmenet.getDateDebutMaint());
		LO.setDateFinMaint(emplacmenet.getDateFinMaint());

		maintenanceDAO.save(LO);
		return true;
	}

}
