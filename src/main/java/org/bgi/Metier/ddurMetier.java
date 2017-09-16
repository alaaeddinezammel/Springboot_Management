package org.bgi.Metier;

import java.text.SimpleDateFormat;
import java.util.List;

import org.bgi.dao.DDUR;
import org.bgi.dao.EmplacementsRepostiory;
import org.bgi.dao.FournisseurRepository;
import org.bgi.entities.Emplacements;
import org.bgi.entities.Logiciels;
import org.bgi.entities.Machine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.fabric.xmlrpc.base.Data;

import scala.annotation.meta.setter;

@Service
public class ddurMetier {

	@Autowired
	private DDUR ddur;

	public org.bgi.entities.DDUR savedd(org.bgi.entities.DDUR e) {

		// e.setDateL(new java.util.Date());

		return ddur.save(e);
	}

	public List<org.bgi.entities.DDUR> listDDR() {
		// TODO Auto-generated method stub
		return ddur.findAll();
	}

	public boolean DeleteDD(Long numDD) {
		System.out.println("----------------delete -------------------" + numDD);
		org.bgi.entities.DDUR u = ddur.findOne(numDD);
		if (u != null) {
			System.out.println("------------------------------------------------------+>" + u.toString());
			ddur.delete(u);
			return true;
		} else
			return false;
	}

	public boolean UpdateDDUR(org.bgi.entities.DDUR emplacmenet) {
		org.bgi.entities.DDUR LO = ddur.findOne(emplacmenet.getNumDD());
		System.out.println("-----------------UPDATE--------------------------->:" + LO.toString());

		LO.setCapacite(emplacmenet.getCapacite());
		LO.setEtatDD(emplacmenet.getEtatDD());
		LO.setTypeDD(emplacmenet.getTypeDD());

		ddur.save(LO);
		return true;
	}

}
