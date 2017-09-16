package org.bgi.service;

import java.util.List;

import org.bgi.Metier.CarteVideoMetier;
import org.bgi.entities.CarteVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarteVideoService {

	@Autowired
	private CarteVideoMetier carteVideoMetier;

	@Secured(value = { "ROLE_ADMIN" })

	@RequestMapping(value = "/save_CV", method = RequestMethod.POST)
	public CarteVideo saveCV(@RequestBody CarteVideo e) {
		return carteVideoMetier.saveCV(e);
	}

	@Secured(value = { "ROLE_ADMIN", "ROLE_DIRECTION" })
	@RequestMapping(value = "/getCV", method = RequestMethod.GET)
	public List<CarteVideo> listCarteVideo() {
		return carteVideoMetier.listCarteVideo();
	}

	@Secured(value = { "ROLE_ADMIN" })

	@RequestMapping(value = "/DeleteCV", method = RequestMethod.DELETE)
	public void DeleteCarteVideo(@RequestParam Long numCarteVideo) {
		carteVideoMetier.DeleteCarteVideo(numCarteVideo);
	}

	@Secured(value = { "ROLE_ADMIN" })

	@RequestMapping(value = "/updateCV", method = RequestMethod.PUT)
	public boolean UpdatecarteVID(@RequestBody CarteVideo cart) {
		return carteVideoMetier.UpdatecarteVID(cart);
	}

}
