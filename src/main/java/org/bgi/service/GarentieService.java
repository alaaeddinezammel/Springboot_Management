package org.bgi.service;

import java.util.List;

import org.bgi.Metier.GarentieMetier;
import org.bgi.Metier.LogicielMetier;
import org.bgi.entities.Garantie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GarentieService {
	@Autowired
	private GarentieMetier garentieMetier;
	@Secured(value={"ROLE_ADMIN"})

	@RequestMapping(value = "/save_GAR", method = RequestMethod.POST)
	public Garantie savegar(@RequestBody  Garantie e) {
		return garentieMetier.savegar(e);
	}
	@Secured(value={"ROLE_ADMIN","ROLE_DIRECTION"})
	@RequestMapping(value = "/Garentie", method = RequestMethod.GET)
	public List<Garantie> listGaranties() {
		return garentieMetier.listGaranties();
	}
	@Secured(value={"ROLE_ADMIN"})

	@RequestMapping(value = "/DeleteGar", method = RequestMethod.DELETE)
	public void  Deletegar(@RequestParam Long numGarentie) {
		 garentieMetier.Deletegar(numGarentie);
	}	@Secured(value={"ROLE_ADMIN"})

	@RequestMapping(value="/updateGAR",method=RequestMethod.PUT)
	public boolean UpdateGarentie(@RequestBody  Garantie garantie) {
		return garentieMetier.UpdateGarentie(garantie);
	}
	

	
}
