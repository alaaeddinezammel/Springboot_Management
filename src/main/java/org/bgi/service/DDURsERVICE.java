package org.bgi.service;

import java.util.List;

import org.bgi.Metier.ddurMetier;
import org.bgi.dao.CarteVIDRepository;
import org.bgi.dao.DDUR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DDURsERVICE {

	@Autowired
	private ddurMetier ddurMetier;
	@Secured(value={"ROLE_ADMIN"})

	@RequestMapping(value = "/save_DD", method = RequestMethod.POST)
	public org.bgi.entities.DDUR savedd(@RequestBody org.bgi.entities.DDUR e) {
		return ddurMetier.savedd(e);
	}
	@Secured(value={"ROLE_ADMIN","ROLE_DIRECTION"})
	@RequestMapping(value = "/getDD", method = RequestMethod.GET)
	public List<org.bgi.entities.DDUR> listDDR() {
		return ddurMetier.listDDR();
	}
	@Secured(value={"ROLE_ADMIN"})

	@RequestMapping(value = "/DeleteDD", method = RequestMethod.DELETE)
	public void DeleteDD(@RequestParam Long numDD) {
		ddurMetier.DeleteDD(numDD);
	}
	@Secured(value={"ROLE_ADMIN"})

	@RequestMapping(value = "/updateDD", method = RequestMethod.PUT)
	public boolean UpdateDDUR(@RequestBody org.bgi.entities.DDUR emplacmenet) {
		return ddurMetier.UpdateDDUR(emplacmenet);
	}

}
