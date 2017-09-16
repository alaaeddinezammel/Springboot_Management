package org.bgi.Metier;

import java.text.SimpleDateFormat;
import java.util.List;

import org.bgi.dao.LogicielsRepository;
import org.bgi.dao.MachineRepository;
import org.bgi.entities.Logiciels;
import org.bgi.entities.Machine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.fabric.xmlrpc.base.Data;

import scala.annotation.meta.setter;

@Service
public class LogicielMetier {

	@Autowired
	private LogicielsRepository logicielsRepository;
	@Autowired
	private MachineRepository machineRepository;



	public Logiciels saveLog(Logiciels e) {

		// e.setDateL(new java.util.Date());

		return logicielsRepository.save(e);
	}

	public List<Logiciels> listLogiciels() {
		// TODO Auto-generated method stub
		return logicielsRepository.findAll();
	}

	public boolean DeleteLog(Long numL) {
		System.out.println("----------------delete -------------------" + numL);
		Logiciels u = logicielsRepository.findOne(numL);
		if (u != null) {
			System.out.println("------------------------------------------------------+>" + u.toString());
			logicielsRepository.delete(u);
			return true;
		} else
			return false;
	}

	public boolean UpdateLogiciel(Logiciels logiciel) {
		Logiciels LO = logicielsRepository.findOne(logiciel.getNumL());
		System.out.println("-----------------UPDATE--------------------------->:" + logiciel.toString());

		LO.setDateL(logiciel.getDateL());
		LO.setEditeurL(logiciel.getEditeurL());
		LO.setLicenceL(logiciel.getLicenceL());
		LO.setNomL(logiciel.getNomL());
		LO.setNumSerl(logiciel.getNumSerl());
		LO.setTypeL(logiciel.getTypeL());
		LO.setVersionL(logiciel.getVersionL());

		logicielsRepository.save(LO);
		return true;
	}

	public boolean installer_logiciel_machine(Long obj1, Long obj2) {
		System.out.println(obj1 + "*****************************************************");
		System.out.println(obj2 + "000000000000000000000000000000000000000000000000000000000");

		Logiciels LO = logicielsRepository.findOne(obj1);

		Machine MO = machineRepository.findOne(obj2);

		if (LO.getMachines().contains(MO) || MO.getLogiciels().contains(LO)) {
			return false;
		} else {
			LO.getMachines().add(MO);

			MO.getLogiciels().add(LO);
			MO.setDatelogicieli(new java.util.Date());

			logicielsRepository.save(LO);
			machineRepository.save(MO);

			return true;
		}
	}

}
