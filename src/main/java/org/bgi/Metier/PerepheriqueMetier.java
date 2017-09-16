package org.bgi.Metier;

import java.text.SimpleDateFormat;
import java.util.List;

import org.bgi.dao.FournisseurRepository;
import org.bgi.dao.GarentiRepository;
import org.bgi.dao.LogicielsRepository;
import org.bgi.dao.MachineRepository;
import org.bgi.dao.PerepheriqueRepository;
import org.bgi.entities.Fournisseur;
import org.bgi.entities.Garantie;
import org.bgi.entities.Logiciels;
import org.bgi.entities.Machine;
import org.bgi.entities.Perepherique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.fabric.xmlrpc.base.Data;

import scala.annotation.meta.setter;

@Service
public class PerepheriqueMetier {

	@Autowired
	private PerepheriqueRepository perepheriqueRepository;
	@Autowired
	private FournisseurRepository fournisseurRepository;
	@Autowired
	private GarentiRepository garentiRepository;
	@Autowired
	private MachineRepository machineRepository;

	public Perepherique savePER(Perepherique e) {

		// e.setDateL(new java.util.Date());

		return perepheriqueRepository.save(e);
	}

	public List<Perepherique> listPerepherique() {
		// TODO Auto-generated method stub
		return perepheriqueRepository.findAll();
	}

	public boolean DeletePER(Long numMateriel) {
		System.out.println("----------------delete -------------------" + numMateriel);
		Perepherique u = perepheriqueRepository.findOne(numMateriel);
		if (u != null) {
			System.out.println("------------------------------------------------------+>" + u.toString());
			perepheriqueRepository.delete(u);
			return true;
		} else
			return false;
	}

	public boolean UpdatePerepherique(Perepherique perepherique) {
		Perepherique LO = perepheriqueRepository.findOne(perepherique.getNumMateriel());

		LO.setEtatMateriel(perepherique.getEtatMateriel());
		LO.setNomMatriel(perepherique.getNomMatriel());
		LO.setTypeP(perepherique.getTypeP());
		LO.setAdrIPMateriel(perepherique.getAdrIPMateriel());

		Fournisseur u1 = fournisseurRepository.findOne(perepherique.getFournisseur1().getNumF());

		LO.setFournisseur1(u1);

		Garantie gr1 = garentiRepository.findOne(perepherique.getGarantie1().getNumGarentie());
		LO.setGarantie1(gr1);

		perepheriqueRepository.save(LO);
		return true;
	}

	public boolean installer_Perepherique_machine(Long obj1, Long obj2) {
		System.out.println(obj1 + "*****************************************************");
		System.out.println(obj2 + "0000000000000000--000000000000000000");

		Perepherique LO = perepheriqueRepository.findOne(obj1);

		Machine MO = machineRepository.findOne(obj2);

		if (LO.getMachines().contains(MO) || MO.getLogiciels().contains(LO)) {
			return false;
		} else {
			LO.getMachines().add(MO);

			MO.getPerepheriques().add(LO);
			MO.setDateperepheriquei(new java.util.Date());
			perepheriqueRepository.save(LO);
			machineRepository.save(MO);

			return true;
		}

	}
}