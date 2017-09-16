package org.bgi.service;

import java.util.List;

import javax.persistence.PreRemove;

import org.bgi.Metier.MachineMetier;
import org.bgi.dao.MachineRepository;
import org.bgi.entities.Machine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MachineRestService {
	@Autowired

	private MachineMetier machinemetier;
	
	
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value = "/DeleteL",method = RequestMethod.DELETE)
	public boolean Delete1(@RequestParam Long numL,@RequestParam Long numMachine) {
		System.out.println("***************************"
				+ "************************"
				+ "*****************"
				+ "*******Delete1*********"
				+ "******************"
				+ "*************"
				+ "**************"
				+ numMachine
				+ "************"
				+numL+"-------------------------*****"
				);
		return machinemetier.Delete1(numL,numMachine);
	}
	
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value = "/DeleteU", method = RequestMethod.DELETE)
	public boolean Delete2(@RequestParam Long numU,@RequestParam Long numMachine) {
		System.out.println("***************************"
				+ "************************"
				+ "*****************"
				+ "*******Delete2*********"
				+ "******************"
				+ "*************"
				+ "**************"
				+ numMachine
				+ "************"
				+numU+"-------------------------*****"
				);
		return machinemetier.Delete2(numU,numMachine);
	}
	
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value = "/DeleteP", method = RequestMethod.DELETE)
	public boolean Delete3(@RequestParam Long numMateriel,@RequestParam Long numMachine) {
		return machinemetier.Delete3(numMateriel,numMachine);
	}
	
	

	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value = "/DeleteMachine", method = RequestMethod.DELETE)
	public void DeleteMachine(@RequestParam Long numMachine) {
		machinemetier.DeleteMachine(numMachine);
	}
	
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value = "/updateMachine", method = RequestMethod.PUT)
	public boolean UpdateMachine(@RequestBody Machine machinee) {
		return machinemetier.UpdateMachine(machinee);
	}
	
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value = "/save_machine", method = RequestMethod.POST)
	public Machine save(@RequestBody Machine e) {
		return machinemetier.save(e);
	}
	
	@Secured(value={"ROLE_ADMIN","ROLE_DIRECTION"})
	@RequestMapping(value = "/get_machines", method = RequestMethod.GET)
	public List<Machine> listMachines() {
		return machinemetier.listMachines();
	}
	
	

}
