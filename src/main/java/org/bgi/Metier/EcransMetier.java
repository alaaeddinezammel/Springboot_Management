package org.bgi.Metier;

import java.text.SimpleDateFormat;
import java.util.List;

import org.bgi.dao.DDUR;
import org.bgi.dao.EcranRepository;
import org.bgi.dao.EmplacementsRepostiory;
import org.bgi.dao.FournisseurRepository;
import org.bgi.dao.GarentiRepository;
import org.bgi.dao.MarqueRepository;
import org.bgi.entities.Ecrans;
import org.bgi.entities.Emplacements;
import org.bgi.entities.Fournisseur;
import org.bgi.entities.Garantie;
import org.bgi.entities.Logiciels;
import org.bgi.entities.Machine;
import org.bgi.entities.Marque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.fabric.xmlrpc.base.Data;

import scala.annotation.meta.setter;

@Service
public class EcransMetier {

	@Autowired
	private EcranRepository ecranRepository;

	@Autowired
	private FournisseurRepository fournisseurRepository;
	@Autowired
	private GarentiRepository garentiRepository;

	@Autowired
	private MarqueRepository marqueRepository;

	public Ecrans savedd(Ecrans e) {

		// e.setDateL(new java.util.Date());

		return ecranRepository.save(e);
	}

	public List<Ecrans> listeECC() {
		// TODO Auto-generated method stub
		return ecranRepository.findAll();
	}

	public boolean DeleteECRAN(Long numEcran) {
		System.out.println("----------------delete -------------------" + numEcran);
		Ecrans u = ecranRepository.findOne(numEcran);
		if (u != null) {
			System.out.println("------------------------------------------------------+>" + u.toString());
			ecranRepository.delete(u);
			return true;
		} else
			return false;
	}

	public boolean UpdateEcrans(Ecrans emplacmenet) {
		Ecrans LO = ecranRepository.findOne(emplacmenet.getNumEcran());
		System.out.println("-----------------UPDATE--------------------------->:" + LO.toString());

		LO.setTailleEcran(emplacmenet.getTailleEcran());

		Fournisseur u1 = fournisseurRepository.findOne(emplacmenet.getFournisseur2().getNumF());

		LO.setFournisseur2(u1);

		Garantie gr1 = garentiRepository.findOne(emplacmenet.getGarantie2().getNumGarentie());
		LO.setGarantie2(gr1);

		Marque mr1 = marqueRepository.findOne(emplacmenet.getMarque1().getNumMarque());
		LO.setMarque1(mr1);

		ecranRepository.save(LO);
		return true;
	}

}
