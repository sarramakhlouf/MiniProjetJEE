package com.sarra.universitess.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.sarra.universitess.entities.Domaine;
import com.sarra.universitess.entities.Universite;
import com.sarra.universitess.repos.DomaineRepository;
import com.sarra.universitess.repos.UniversiteRepository;

@Service
public class UniversiteServiceImpl implements UniversiteService {

    @Autowired
    private UniversiteRepository universiteRepository;
    
    @Autowired
    DomaineRepository domaineRepository;


    @Override
    public Universite saveUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public void deleteUniversite(Universite u) {
        universiteRepository.delete(u);
    }

    @Override
    public void deleteUniversiteById(Long id) {
        universiteRepository.deleteById(id);
    }

    @Override
    public Universite getUniversite(Long id) {
        return universiteRepository.findById(id).get();
    }

    @Override
    public List<Universite> getAllUniversites() {
        return universiteRepository.findAll();
    }
    
	@Override
	public Page<Universite> getAllUniversitesParPage(int page, int size) {
		return universiteRepository.findAll(PageRequest.of(page, size));
	}
	
	@Override
	public List<Universite> findByNomUniversite(String nom) {
	    return universiteRepository.findByNomUniversite(nom);
	}

	@Override
	public List<Universite> findByNomUniversiteContains(String nom) {
	    return universiteRepository.findByNomUniversiteContains(nom);
	}

	@Override
	public List<Universite> findByNomAndEtudiants(String nom, Double nbEtudiants) {
	    return universiteRepository.findByNomAndEtudiants(nom, nbEtudiants);
	}

	@Override
	public List<Universite> findByDomaine(Domaine domaine) {
	    return universiteRepository.findByDomaine(domaine);
	}

	@Override
	public List<Universite> findByDomaineIdDom(Long id) {
	    return universiteRepository.findByDomaineIdDom(id);
	}

	@Override
	public List<Universite> findByOrderByNomUniversiteAsc() {
	    return universiteRepository.findByOrderByNomUniversiteAsc();
	}

	@Override
	public List<Universite> trierUniversitesNomNbEtudiants() {
	    return universiteRepository.trierUniversitesNomNbEtudiants();
	}
	
	@Override
	public List<Domaine> getAllDomaines() {
		return domaineRepository.findAll();
	}
	
	@Override
    public Domaine saveDomaine(Domaine d) {
        return domaineRepository.save(d);
    }


}
