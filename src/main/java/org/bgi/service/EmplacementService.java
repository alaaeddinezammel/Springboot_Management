package org.bgi.service;

import java.util.List;

import org.bgi.Metier.EmplacementMetier;
import org.bgi.Metier.FournisseurMetier;
import org.bgi.entities.Emplacements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmplacementService {

	@Autowired
	private EmplacementMetier emplacementMetier;
	@Secured(value={"ROLE_ADMIN"})

	@RequestMapping(value = "/save_EMP", method = RequestMethod.POST)
	public Emplacements saveEmpl(@RequestBody Emplacements e) {
		return emplacementMetier.saveEmpl(e);
	}
	@Secured(value={"ROLE_ADMIN","ROLE_DIRECTION"})
	@RequestMapping(value = "/Emplacmenet", method = RequestMethod.GET)
	public List<Emplacements> listEmplacement() {
		return emplacementMetier.listEmplacement();
	}
	@Secured(value={"ROLE_ADMIN"})

	@RequestMapping(value = "/DeleteEmp", method = RequestMethod.DELETE)
	public void  DeleteEMP(@RequestParam Long numEmplacement) {
		 emplacementMetier.DeleteEMP(numEmplacement);
	}
	@Secured(value={"ROLE_ADMIN"})

	@RequestMapping(value = "/updateEmplacmenet", method = RequestMethod.PUT)
	public boolean UpdateEmplacmeent(@RequestBody Emplacements emplacmenet) {
		return emplacementMetier.UpdateEmplacmeent(emplacmenet);
	}

}
