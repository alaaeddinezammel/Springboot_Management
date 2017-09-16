package org.bgi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.bgi.Metier.UtilisateurMetier;
import org.bgi.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userService {

	@Autowired
	private UtilisateurMetier utilisateurMetier;

	
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value = "/save_uSER", method = RequestMethod.POST)
	public Utilisateur saveUTIL(@RequestBody Utilisateur e) {
		return utilisateurMetier.saveUTIL(e);
	}

	
	@Secured(value={"ROLE_ADMIN","ROLE_DIRECTION"})
	@RequestMapping(value = "/Users", method = RequestMethod.GET)
	public List<Utilisateur> listUtilisateur() {
		return utilisateurMetier.listUtilisateur();
	}

	
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value = "/DeleteUser", method = RequestMethod.DELETE)
	public void DeleteUtilisateur(@RequestParam Long numU) {
		utilisateurMetier.DeleteUtilisateur(numU);
	}

	
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
	public boolean UpdateUtilisateur(@RequestBody Utilisateur logiciel) {
		return utilisateurMetier.UpdateUtilisateur(logiciel);
	}
	
	
	
	@Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value = "/save_user-machine", method = RequestMethod.PUT)
	public boolean installer_user_machine(@RequestParam Long obj1, @RequestParam Long obj2) {
		return utilisateurMetier.installer_user_machine(obj1, obj2);
	}

	

	
	
	@Secured(value={"ROLE_ADMIN","ROLE_DIRECTION"})
	@RequestMapping(value = "/getLogedUser")
	public Map<String, Object> getLogedUser(HttpServletRequest httpServletRequest) {
		HttpSession httpSession = httpServletRequest.getSession();
		SecurityContext securityContext = (SecurityContext) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
		String username = securityContext.getAuthentication().getName();
		List<String> roles = new ArrayList<>();
		for (GrantedAuthority ga : securityContext.getAuthentication().getAuthorities()) {

			roles.add(ga.getAuthority());
		}
		Map<String, Object> params = new HashMap<>();
		params.put("username", username);
		params.put("roles", roles);

		return params;
	}

}
