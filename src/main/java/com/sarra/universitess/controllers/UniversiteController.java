package com.sarra.universitess.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;

import com.sarra.universitess.entities.Universite;
import com.sarra.universitess.service.UniversiteService;

@Controller
public class UniversiteController {

    @Autowired
    UniversiteService universiteService;

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
    public String showCreate() {
        return "createUniversite";
    }

    @RequestMapping("/saveUniversite")
    public String saveUniversite(@ModelAttribute("universite") Universite universite,
                                 @RequestParam("date") String date,
                                 ModelMap modelMap) throws ParseException {
        // Conversion de la date
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(date);
        universite.setDateCreation(dateCreation);

        Universite savedUniversite = universiteService.saveUniversite(universite);
        String msg = "Université enregistrée avec Id " + savedUniversite.getIdUniversite();
        modelMap.addAttribute("msg", msg);
        return "createUniversite";
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
    public String editerUniversite(@RequestParam("id") Long id, ModelMap modelMap) {
        Universite u = universiteService.getUniversite(id);
        modelMap.addAttribute("universite", u);
        return "editerUniversite";
    }

    @RequestMapping("/updateUniversite")
    public String updateUniversite(@ModelAttribute("universite") Universite universite,
                                   @RequestParam("date") String date,
                                   ModelMap modelMap) throws ParseException {
        // Conversion de la date
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(date);
        universite.setDateCreation(dateCreation);

        universiteService.updateUniversite(universite);
        List<Universite> universites = universiteService.getAllUniversites();
        modelMap.addAttribute("universites", universites);
        return "listeUniversites";
    }
}
