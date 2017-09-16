package org.bgi.Metier;

import java.util.List;

import javax.persistence.PreRemove;

import org.bgi.dao.CarteVIDRepository;
import org.bgi.dao.DDUR;
import org.bgi.dao.EcranRepository;
import org.bgi.dao.EmplacementsRepostiory;
import org.bgi.dao.FournisseurRepository;
import org.bgi.dao.GarentiRepository;
import org.bgi.dao.LogicielsRepository;
import org.bgi.dao.MachineRepository;
import org.bgi.dao.MaintenanceDAO;
import org.bgi.dao.MarqueRepository;
import org.bgi.dao.PerepheriqueRepository;
import org.bgi.dao.UtilisateurRepository;
import org.bgi.entities.CarteVideo;
import org.bgi.entities.Ecrans;
import org.bgi.entities.Emplacements;
import org.bgi.entities.Fournisseur;
import org.bgi.entities.Garantie;
import org.bgi.entities.Logiciels;
import org.bgi.entities.Machine;
import org.bgi.entities.Maintenances;
import org.bgi.entities.Perepherique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MachineMetier {

	@Autowired
	private MachineRepository machinerepository;
	@Autowired
	private FournisseurRepository fournisseurRepository;
	@Autowired
	private GarentiRepository garentiRepository;
	@Autowired
	private MaintenanceDAO maintenanceDAO;
	@Autowired
	private EmplacementsRepostiory emplacementsRepostiory;

	@Autowired
	private CarteVIDRepository carteVIDRepository;

	@Autowired
	private EcranRepository ecranRepository;
	
	@Autowired
	private LogicielsRepository logicielsRepository;
	
	@Autowired
	private PerepheriqueRepository perepheriqueRepository;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Autowired
	private DDUR ddur;

	@Autowired
	private MarqueRepository marqueRepository;
	
	
	public Machine save(Machine e) {
		// TODO Auto-generated method stub
		return machinerepository.save(e);
	}

	public List<Machine> listMachines() {
		// TODO Auto-generated method stub
		return machinerepository.findAll();
	}

	public boolean DeleteMachine(Long numSerieMachine) {
		System.out.println("----------------delete -------------------" + numSerieMachine);
		Machine u = machinerepository.findOne(numSerieMachine);
		if (u != null) {
			System.out.println("------------------------------------------------------+>" + u.toString());
			machinerepository.delete(u);
			return true;
		} else
			return false;
	}

	
	
	//--------------------------------------------------------------//

	public boolean Delete1(Long numL,Long numMachine) {
		//System.out.println("----------------delete ---------"+m1.getNumMachine()+"----------");
		Machine u = machinerepository.findOne(numMachine);
		if (u != null) {
			System.out.println("-----------------------------numL:-------------------------+>" + numL+"numMachine:---------------*>"+numMachine);
		//	Logiciels v=logicielsRepository.findOne(numL);
			//System.out.println("------------------------------------------------------+>" + v.toString());
	machinerepository.deletel(numMachine, numL);
			return true;
		} else
			return false;
	}
	//------------------------------------------------------------------//
	public boolean Delete2(Long numU,Long numMachine) {
		//System.out.println("----------------delete ---------"+m1.getNumMachine()+"----------");
		
			//Logiciels v=logicielsRepository.findOne(numL);
			//System.out.println("------------------------------------------------------+>" + v.toString());
	machinerepository.deleteu(numMachine, numU);
			return true;
		
	}
	//------------------------------------------------------------------------------//
	public boolean Delete3(Long numMateriel,Long numMachine) {
		//System.out.println("----------------delete ---------"+m1.getNumMachine()+"----------");
		
			//System.out.println("------------------------------------------------------+>" + v.toString());
machinerepository.deletep(numMachine, numMateriel);
			return true;
		
	}
	
	
	
	
	public boolean UpdateMachine(Machine machinee) {
		Machine LO = machinerepository.findOne(machinee.getNumMachine());

		LO.setAdressIp(machinee.getAdressIp());
		LO.setAdressMac(machinee.getAdressMac());
		LO.setCarteMere(machinee.getCarteMere());
		LO.setCarteReseaux(machinee.getCarteReseaux());
		LO.setCarteSon(machinee.getCarteSon());
		LO.setDateAchat(machinee.getDateAchat());
		LO.setDateLivraison(machinee.getDateLivraison());
		LO.setPrixMachine(machinee.getPrixMachine());
		LO.setDateMiseEnService(machinee.getDateMiseEnService());
		LO.setTypeMachine(machinee.getTypeMachine());
		LO.setNomMachine(machinee.getNomMachine());
		LO.setProc(machinee.getProc());
		LO.setSocket(machinee.getSocket());

		LO.setMemoire(machinee.getMemoire());
		LO.setTypeMemoire(machinee.getTypeMemoire());

		Fournisseur u1 = fournisseurRepository.findOne(machinee.getFournisseur().getNumF());

		LO.setFournisseur(u1);

		Garantie gr1 = garentiRepository.findOne(machinee.getGarantie().getNumGarentie());
		LO.setGarantie(gr1);

		Emplacements empl1 = emplacementsRepostiory.findOne(machinee.getEmplacements().getNumEmplacement());
		LO.setEmplacements(empl1);

		CarteVideo crt = carteVIDRepository.findOne(machinee.getCarteVideo().getNumCarteVideo());
		LO.setCarteVideo(crt);

		Ecrans ecr = ecranRepository.findOne(machinee.getEcran().getNumEcran());
		LO.setEcran(ecr);

		machinerepository.save(LO);
		return true;
	}

}
