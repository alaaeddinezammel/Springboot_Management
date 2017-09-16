package org.bgi.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.bgi.Metier.LogicielMetier;
import org.bgi.Metier.MachineMetier;
import org.bgi.entities.Logiciels;
import org.bgi.entities.Machine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogicielRestService {
	@Autowired
	private LogicielMetier logicielMetier;

	@Secured(value = { "ROLE_ADMIN" })

	@RequestMapping(value = "/save_log-machine", method = RequestMethod.PUT)
	public boolean installer_logiciel_machine(@RequestParam Long obj1, @RequestParam Long obj2) {
		System.out.println("objeteeeeeeeeeeeee1" + obj1 + "obj22222222" + obj2);
		return logicielMetier.installer_logiciel_machine(obj1, obj2);
	}

	@Secured(value = { "ROLE_ADMIN" })

	@RequestMapping(value = "/updateLogiciel", method = RequestMethod.PUT)
	public boolean UpdateLogiciel(@RequestBody Logiciels logiciel) {
		return logicielMetier.UpdateLogiciel(logiciel);
	}

	@Secured(value = { "ROLE_ADMIN" })

	@RequestMapping(value = "/DeleteLogiciel", method = RequestMethod.DELETE)
	public void DeleteLog(@RequestParam Long numL) {

		logicielMetier.DeleteLog(numL);
		System.out.println("chayyyyyyyyyyyyyyyy--yyyyyyyy");
	}

	@Secured(value = { "ROLE_ADMIN" })

	@RequestMapping(value = "/save_log", method = RequestMethod.POST)

	public Logiciels saveLog(@RequestBody Logiciels e) {
		return logicielMetier.saveLog(e);
	}

	@Secured(value = { "ROLE_ADMIN", "ROLE_DIRECTION" })
	@RequestMapping(value = "/logiciels", method = RequestMethod.GET)
	public List<Logiciels> listLogiciels() {
		return logicielMetier.listLogiciels();
	}

}
