package org.bgi.Metier;

import java.text.SimpleDateFormat;
import java.util.List;

import org.bgi.dao.CarteVIDRepository;
import org.bgi.dao.FournisseurRepository;
import org.bgi.entities.CarteVideo;
import org.bgi.entities.Fournisseur;
import org.bgi.entities.Logiciels;
import org.bgi.entities.Machine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.fabric.xmlrpc.base.Data;

import scala.annotation.meta.setter;
@Service
public class CarteVideoMetier {

	@Autowired
	private CarteVIDRepository carteVIDRepository;
	
	public CarteVideo saveCV(CarteVideo e) {


		//e.setDateL(new java.util.Date());
		
		return carteVIDRepository.save(e);
	}

	
	public List<CarteVideo> listCarteVideo() {
		// TODO Auto-generated method stub
		return carteVIDRepository.findAll();
	}
	
	
	
	
	public boolean DeleteCarteVideo(Long numCarteVideo){
		System.out.println("----------------delete -------------------"+numCarteVideo);
		CarteVideo u=carteVIDRepository.findOne(numCarteVideo);
		if(u != null){
System.out.println("------------------------------------------------------+>"+u.toString());
carteVIDRepository.delete(u);
		return true;
		} else
			return false ;
	}
	
	
	
	
	

	public boolean UpdatecarteVID(CarteVideo cart) {
		CarteVideo LO=carteVIDRepository.findOne(cart.getNumCarteVideo());
		System.out.println("-----------------UPDATE--------------------------->:"+LO.toString());
		
		
LO.setNomCarte(cart.getNomCarte());
LO.setTypeCarte(cart.getTypeCarte());


carteVIDRepository.save(LO);
		return true;
	}

	
}
