package org.bgi.Metier;

import java.text.SimpleDateFormat;
import java.util.List;

import org.bgi.dao.FournisseurRepository;
import org.bgi.entities.Fournisseur;
import org.bgi.entities.Logiciels;
import org.bgi.entities.Machine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.fabric.xmlrpc.base.Data;

import scala.annotation.meta.setter;
@Service
public class FournisseurMetier {

	@Autowired
	private FournisseurRepository fournisseurRepository;
	
	public Fournisseur saveF(Fournisseur e) {


		//e.setDateL(new java.util.Date());
		
		return fournisseurRepository.save(e);
	}

	
	public List<Fournisseur> listFournisseur() {
		// TODO Auto-generated method stub
		return fournisseurRepository.findAll();
	}
	
	
	
	
	public boolean DeleteFo(Long numF){
		System.out.println("----------------delete -------------------"+numF);
		Fournisseur u=fournisseurRepository.findOne(numF);
		if(u != null){
System.out.println("------------------------------------------------------+>"+u.toString());
fournisseurRepository.delete(u);
		return true;
		} else
			return false ;
	}
	
	
	
	
	

	public boolean UpdateFournisseur(Fournisseur fournisseur) {
		Fournisseur LO=fournisseurRepository.findOne(fournisseur.getNumF());
		System.out.println("-----------------UPDATE--------------------------->:"+LO.toString());
		
		
LO.setAdrF(fournisseur.getAdrF());
LO.setCodepF(fournisseur.getCodepF());
LO.setNomF(fournisseur.getNomF());

LO.setTelF(fournisseur.getTelF());


fournisseurRepository.save(LO);
		return true;
	}

	
}
