package com.sarra.universitess.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sarra.universitess.dto.UniversiteDTO;
import com.sarra.universitess.entities.Universite;
import com.sarra.universitess.service.UniversiteService;

@RestController
@RequestMapping("/api")
@CrossOrigin

public class UniversiteRESTController {
	@Autowired
	UniversiteService universiteService;

	@RequestMapping(method = RequestMethod.GET)
	public List<UniversiteDTO> getAllUniversites() {
		return universiteService.getAllUniversites();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UniversiteDTO getUniversiteById(@PathVariable("id") Long id) {
		return universiteService.getUniversite(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public UniversiteDTO createUniversite(@RequestBody UniversiteDTO universiteDTO) {
		return universiteService.saveUniversite(universiteDTO);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public UniversiteDTO updateUniversite(@RequestBody UniversiteDTO universiteDTO) {
		return universiteService.updateUniversite(universiteDTO);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteUniversite(@PathVariable("id") Long id) {
		universiteService.deleteUniversiteById(id);
	}

	@RequestMapping(value = "/unisdom/{idDom}", method = RequestMethod.GET)
	public List<Universite> getUniverstesByDomId(@PathVariable("idDom") Long idDom) {
		return universiteService.findByDomaineIdDom(idDom);
	}

}
