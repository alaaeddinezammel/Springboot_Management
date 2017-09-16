package org.bgi.Metier;

import java.text.SimpleDateFormat;
import java.util.List;

import org.bgi.dao.GarentiRepository;
import org.bgi.dao.LogicielsRepository;
import org.bgi.entities.Garantie;
import org.bgi.entities.Logiciels;
import org.bgi.entities.Machine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.fabric.xmlrpc.base.Data;

import scala.annotation.meta.setter;
@Service
public class GarentieMetier {

	@Autowired
	private GarentiRepository garentiRepository;
	
	public Garantie savegar(Garantie e) {


		//e.setDateL(new java.util.Date());
		
		return garentiRepository.save(e);
	}

	
	public List<Garantie> listGaranties() {
		// TODO Auto-generated method stub
		return garentiRepository.findAll();
	}
	
	
	
	
	public boolean Deletegar(Long numGarentie){
		Garantie u=garentiRepository.findOne(numGarentie);
		if(u != null){
System.out.println("------------------------------------------------------+>"+u.toString());
garentiRepository.delete(u);
		return true;
		} else
			return false ;
	}
	
	
	
	
	

	public boolean UpdateGarentie(Garantie garantie) {
Garantie LO=garentiRepository.findOne(garantie.getNumGarentie());
System.out.println("-----------------UPDATE--------------------------->:"+LO.toString());
		
		
LO.setDateDebutGarentie(garantie.getDateDebutGarentie());
LO.setDureeGarentie(garantie.getDureeGarentie());
LO.setTypeGarentie(garantie.getTypeGarentie());


garentiRepository.save(LO);
		return true;
	}

	
}
