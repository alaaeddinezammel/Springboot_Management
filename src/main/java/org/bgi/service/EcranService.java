package org.bgi.service;

import java.util.List;

import org.bgi.Metier.EcransMetier;
import org.bgi.entities.Ecrans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EcranService {

	@Autowired
	private EcransMetier ecransMetier;
	@Secured(value={"ROLE_ADMIN"})

	@RequestMapping(value = "/save_ECC", method = RequestMethod.POST)
	public Ecrans savedd(@RequestBody Ecrans e) {
		return ecransMetier.savedd(e);
	}
	@Secured(value={"ROLE_ADMIN","ROLE_DIRECTION"})
	@RequestMapping(value = "/getECC", method = RequestMethod.GET)
	public List<Ecrans> listeECC() {
		return ecransMetier.listeECC();
	}
	@Secured(value={"ROLE_ADMIN"})

	@RequestMapping(value = "/DeleteECC", method = RequestMethod.DELETE)
	public void DeleteECRAN(@RequestParam Long numEcran) {
		ecransMetier.DeleteECRAN(numEcran);
	}
	@Secured(value={"ROLE_ADMIN"})

	@RequestMapping(value = "/updateECC", method = RequestMethod.PUT)
	public boolean UpdateEcrans(@RequestBody Ecrans emplacmenet) {
		return ecransMetier.UpdateEcrans(emplacmenet);
	}

}
