package org.bgi.Metier;

import java.text.SimpleDateFormat;
import java.util.List;

import org.bgi.dao.LogicielsRepository;
import org.bgi.dao.MachineRepository;
import org.bgi.dao.UtilisateurRepository;
import org.bgi.entities.Logiciels;
import org.bgi.entities.Machine;
import org.bgi.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.fabric.xmlrpc.base.Data;

import scala.annotation.meta.setter;

@Service
public class UtilisateurMetier {

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private MachineRepository machineRepository;

	public Utilisateur saveUTIL(Utilisateur e) {

		// e.setDateL(new java.util.Date());

		return utilisateurRepository.save(e);
	}

	public List<Utilisateur> listUtilisateur() {
		// TODO Auto-generated method stub
		return utilisateurRepository.findAll();
	}

	public boolean DeleteUtilisateur(Long numU) {
		System.out.println("----------------delete -------------------" + numU);
		Utilisateur u = utilisateurRepository.findOne(numU);
		if (u != null) {
			System.out.println("------------------------------------------------------+>" + u.toString());
			utilisateurRepository.delete(u);
			return true;
		} else
			return false;
	}

	public boolean UpdateUtilisateur(Utilisateur logiciel) {
		Utilisateur LO = utilisateurRepository.findOne(logiciel.getNumU());
		System.out.println("-----------------UPDATE--------------------------->:" + logiciel.toString());

		LO.setDroitU(logiciel.getDroitU());
		LO.setNomU(logiciel.getNomU());
		LO.setPrenomU(logiciel.getPrenomU());

		utilisateurRepository.save(LO);
		return true;
	}

	public boolean installer_user_machine(Long obj1, Long obj2) {
		System.out.println(obj1 + "*****************************************************");
		System.out.println(obj2 + "000000000000000000000000000000000000000000000000000000000");

		Utilisateur LO = utilisateurRepository.findOne(obj1);

		Machine MO = machineRepository.findOne(obj2);

		if (LO.getMachines().contains(MO) || MO.getLogiciels().contains(LO)) {
			return false;
		} else {
			LO.getMachines().add(MO);

			MO.getUtilisateurs().add(LO);
			MO.setDateUtilisateurMachine(new java.util.Date());
			utilisateurRepository.save(LO);
			machineRepository.save(MO);

			return true;
		}
	}

}
