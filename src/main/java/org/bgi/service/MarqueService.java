package org.bgi.service;

import java.util.List;

import org.bgi.Metier.MarqueMetier;
import org.bgi.entities.Marque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarqueService {

	@Autowired
	private MarqueMetier marqueMetier;
	@Secured(value={"ROLE_ADMIN"})

	@RequestMapping(value = "/save_marque", method = RequestMethod.POST)
	public Marque saveMArque(@RequestBody Marque e) {
		return marqueMetier.saveMArque(e);
	}
	@Secured(value={"ROLE_ADMIN","ROLE_DIRECTION"})
	@RequestMapping(value = "/MArqs", method = RequestMethod.GET)
	public List<Marque> listMarque() {
		return marqueMetier.listMarque();
	}
	@Secured(value={"ROLE_ADMIN"})

	@RequestMapping(value = "/DeleteMARQS", method = RequestMethod.DELETE)
	public void DeleteMarque(@RequestParam Long numMarque) {
		marqueMetier.DeleteMarque(numMarque);
	}
	@Secured(value={"ROLE_ADMIN"})

	@RequestMapping(value = "/updateMARQS", method = RequestMethod.PUT)
	public boolean UpdateMarque(@RequestBody Marque emplacmenet) {
		return marqueMetier.UpdateMarque(emplacmenet);
	}

}
