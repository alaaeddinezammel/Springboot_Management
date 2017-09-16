package org.bgi.service;

import java.util.List;

import org.bgi.Metier.MaintenanceMetier;
import org.bgi.entities.Maintenances;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MAINTrestService {
	@Autowired
	private MaintenanceMetier maintenanceMetier;
	@Secured(value={"ROLE_ADMIN"})

	@RequestMapping(value = "/save_maint", method = RequestMethod.POST)
	public Maintenances saveMAINT(@RequestBody Maintenances e) {
		return maintenanceMetier.saveMAINT(e);
	}
	@Secured(value={"ROLE_ADMIN","ROLE_DIRECTION"})
	@RequestMapping(value = "/MAINTS", method = RequestMethod.GET)
	public List<Maintenances> listMAINTt() {
		return maintenanceMetier.listMAINTt();
	}
	@Secured(value={"ROLE_ADMIN"})

	@RequestMapping(value = "/DeleteMaint", method = RequestMethod.DELETE)
	public void DeleteMAINT(@RequestParam Long numMaintenance) {
		maintenanceMetier.DeleteMAINT(numMaintenance);
	}
	@Secured(value={"ROLE_ADMIN"})

	@RequestMapping(value = "/updateMaint", method = RequestMethod.PUT)
	public boolean UpdateMAINT(@RequestBody Maintenances emplacmenet) {
		return maintenanceMetier.UpdateMAINT(emplacmenet);
	}

}
