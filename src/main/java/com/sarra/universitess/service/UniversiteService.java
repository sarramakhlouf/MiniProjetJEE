package com.sarra.universitess.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.sarra.universitess.dto.UniversiteDTO;
import com.sarra.universitess.entities.Domaine;
import com.sarra.universitess.entities.Universite;

public interface UniversiteService {
	
	UniversiteDTO saveUniversite(UniversiteDTO u);
	UniversiteDTO getUniversite(Long id);
	List<UniversiteDTO> getAllUniversites();
    UniversiteDTO updateUniversite(UniversiteDTO u);
    
    void deleteUniversite(Universite u);
    void deleteUniversiteById(Long id);
    
    Page<Universite> getAllUniversitesParPage(int page, int size);
    List<Universite> findByNomUniversite(String nom);
    List<Universite> findByNomUniversiteContains(String nom);
    List<Universite> findByNomAndEtudiants(String nom, Double nbEtudiants);
    List<Universite> findByDomaine(Domaine domaine);
    List<Universite> findByDomaineIdDom(Long id);
	List<Universite> findByOrderByNomUniversiteAsc();
	List<Universite> trierUniversitesNomNbEtudiants();
	List<Domaine> getAllDomaines();
	Domaine saveDomaine(Domaine d);
	 
	UniversiteDTO convertEntityToDto (Universite universite);
	Universite convertDtoToEntity(UniversiteDTO universiteDto);	
}
