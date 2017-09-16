package org.bgi.Metier;

import java.text.SimpleDateFormat;
import java.util.List;

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
public class EmplacementMetier {

	@Autowired
	private EmplacementsRepostiory emplacementsRepostiory;
	
	public Emplacements saveEmpl(Emplacements e) {


		//e.setDateL(new java.util.Date());
		
		return emplacementsRepostiory.save(e);
	}

	
	public List<Emplacements> listEmplacement() {
		// TODO Auto-generated method stub
		return emplacementsRepostiory.findAll();
	}
	
	
	
	
	public boolean DeleteEMP(Long numEmplacement){
		System.out.println("----------------delete -------------------"+numEmplacement);
		Emplacements u=emplacementsRepostiory.findOne(numEmplacement);
		if(u != null){
System.out.println("------------------------------------------------------+>"+u.toString());
emplacementsRepostiory.delete(u);
		return true;
		} else
			return false ;
	}
	
	
	
	
	

	public boolean UpdateEmplacmeent(Emplacements emplacmenet) {
		Emplacements LO=emplacementsRepostiory.findOne(emplacmenet.getNumEmplacement());
		System.out.println("-----------------UPDATE--------------------------->:"+LO.toString());
		
		
LO.setNomEmplacement(emplacmenet.getNomEmplacement());
LO.setService(emplacmenet.getService());




emplacementsRepostiory.save(LO);
		return true;
	}

	
}
