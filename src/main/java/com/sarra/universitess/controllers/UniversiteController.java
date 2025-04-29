package com.sarra.universitess.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;

import com.sarra.universitess.dto.UniversiteDTO;
import com.sarra.universitess.entities.Domaine;
import com.sarra.universitess.entities.Universite;
import com.sarra.universitess.service.UniversiteService;

import jakarta.validation.Valid;

@Controller
public class UniversiteController {

    @Autowired
    UniversiteService universiteService;

    /*@GetMapping("/accessDenied")
    public String error() {
    	return "accessDenied";
    }*/
    
    @RequestMapping("/ListeUniversites")
    public String listeUniversites(ModelMap modelMap,
        @RequestParam(name = "page", defaultValue = "0") int page,
        @RequestParam(name = "size", defaultValue = "2") int size) 
    {
        Page<Universite> unis = universiteService.getAllUniversitesParPage(page, size);
        modelMap.addAttribute("universites", unis);
        modelMap.addAttribute("pages", new int[unis.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        return "listeUniversites";
    }


    @RequestMapping("/showCreate")
    public String showCreate(ModelMap modelMap) {
    	List<Domaine> doms = universiteService.getAllDomaines();
		modelMap.addAttribute("universite", new Universite());
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("domaines", doms);
        return "formUniversite";
    }

    @RequestMapping("/saveUniversite")
    public String saveUniversite(@Valid UniversiteDTO universite, BindingResult bindingResult,
    						@RequestParam (name="page",defaultValue = "0") int page,
    						@RequestParam (name="size",defaultValue = "2") int size)
    {
    	int currentPage;
    	boolean isNew = false;
    	if (bindingResult.hasErrors()) return "formUniversite";
    	
    	if (universite.getIdUniversite()==null) 
    		isNew=true;

	    universiteService.saveUniversite(universite);
	    if (isNew) 
	    {
	    	Page<Universite> unis = universiteService.getAllUniversitesParPage(page, size);
	    	currentPage = unis.getTotalPages()-1;
	    }
	    else 
	    currentPage=page;

	    return ("redirect:/ListeUniversites?page="+currentPage+"&size="+size);
    }

    @RequestMapping("/supprimerUniversite")
    public String supprimerUniversite(@RequestParam("id") Long id,
                                      ModelMap modelMap,
                                      @RequestParam(name="page", defaultValue = "0") int page,
                                      @RequestParam(name="size", defaultValue = "2") int size) {
        
        universiteService.deleteUniversiteById(id);
        
        Page<Universite> universites = universiteService.getAllUniversitesParPage(page, size);
        modelMap.addAttribute("universites", universites);
        modelMap.addAttribute("pages", new int[universites.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        
        return "listeUniversites";
    }


    @RequestMapping("/modifierUniversite")
    public String editerUniversite(@RequestParam("id") Long id, ModelMap modelMap,
    		@RequestParam(name="page", defaultValue = "0") int page,
            @RequestParam(name="size", defaultValue = "2") int size) 
    {
        UniversiteDTO u = universiteService.getUniversite(id);
        List<Domaine> doms = universiteService.getAllDomaines();
        modelMap.addAttribute("universite", u);
        modelMap.addAttribute("mode", "edit");
        modelMap.addAttribute("domaines", doms);
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("size", size);
        return "formUniversite";
    }

    @RequestMapping("/updateUniversite")
    public String updateUniversite(@ModelAttribute("universite") UniversiteDTO universiteDTO,
                                   @RequestParam("date") String date,
                                   ModelMap modelMap) throws ParseException {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(date);
        universiteDTO.setDateCreation(dateCreation);

        universiteService.updateUniversite(universiteDTO); // Mise à jour via le DTO
        List<UniversiteDTO> universites = universiteService.getAllUniversites();
        modelMap.addAttribute("universites", universites);
        return "listeUniversites";
    }

    
	@GetMapping(value = "/")
	public String welcome() {
		return "index";
	}
}
