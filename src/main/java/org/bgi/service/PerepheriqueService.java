package org.bgi.service;

import java.util.List;

import org.bgi.Metier.PerepheriqueMetier;
import org.bgi.entities.Perepherique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PerepheriqueService {

	@Autowired
	private PerepheriqueMetier perepheriqueMetier;
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value = "/save_per-machine", method = RequestMethod.PUT)
	public boolean installer_Perepherique_machine(@RequestParam Long obj1, @RequestParam Long obj2) {
		return perepheriqueMetier.installer_Perepherique_machine(obj1, obj2);
	}
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value = "/save_per", method = RequestMethod.POST)
	public Perepherique savePER(@RequestBody Perepherique e) {
		return perepheriqueMetier.savePER(e);
	}
	
	
	@Secured(value={"ROLE_ADMIN","ROLE_DIRECTION"})
	@RequestMapping(value = "/Perepheriques", method = RequestMethod.GET)
	public List<Perepherique> listPerepherique() {
		return perepheriqueMetier.listPerepherique();
	}
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value = "/DeletePer", method = RequestMethod.DELETE)
	public void DeletePER(@RequestParam Long numMateriel) {
		perepheriqueMetier.DeletePER(numMateriel);
	}
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value = "/updatePer", method = RequestMethod.PUT)
	public boolean UpdatePerepherique(@RequestBody Perepherique perepherique) {
		return perepheriqueMetier.UpdatePerepherique(perepherique);
	}

}
