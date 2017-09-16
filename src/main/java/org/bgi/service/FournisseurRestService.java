package org.bgi.service;

import java.util.List;

import org.bgi.Metier.FournisseurMetier;
import org.bgi.entities.Fournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FournisseurRestService {
	@Autowired
	private FournisseurMetier fournisseurMetier;
	@Secured(value={"ROLE_ADMIN"})

	@RequestMapping(value = "/save_Fou", method = RequestMethod.POST)
	public Fournisseur saveF(@RequestBody Fournisseur e) {
		return fournisseurMetier.saveF(e);
	}
	@Secured(value={"ROLE_ADMIN","ROLE_DIRECTION"})
	@RequestMapping(value = "/Fournisseurs", method = RequestMethod.GET)
	public List<Fournisseur> listFournisseur() {
		return fournisseurMetier.listFournisseur();
	}
	@Secured(value={"ROLE_ADMIN"})

	@RequestMapping(value = "/DeleteFournisseur", method = RequestMethod.DELETE)
	public void  DeleteFo(@RequestParam Long numF) {
		 fournisseurMetier.DeleteFo(numF);
		System.out.println("-------$$$$$$$");
	}
	@Secured(value={"ROLE_ADMIN"})

	@RequestMapping(value = "/updateFournisseur", method = RequestMethod.PUT)
	public boolean UpdateFournisseur(@RequestBody Fournisseur fournisseur) {
		return fournisseurMetier.UpdateFournisseur(fournisseur);
	}

}
