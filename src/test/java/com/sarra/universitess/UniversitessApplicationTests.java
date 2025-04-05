package com.sarra.universitess;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.sarra.universitess.entities.Domaine;
import com.sarra.universitess.entities.Universite;
import com.sarra.universitess.repos.UniversiteRepository;
import com.sarra.universitess.service.UniversiteServiceImpl;

@SpringBootTest
class UniversitessApplicationTests {

	@Autowired
	private UniversiteRepository universiteRepository;

	@Autowired
	private UniversiteServiceImpl universiteService;

	@Test
	public void testCreateUniversite() {
		Universite uni = new Universite("Université de Tunis", "Tunis, Tunisie", "contact@universite.tn", 15000.0, new Date());
		universiteRepository.save(uni);
	}

	@Test
	public void testFindUniversite() {
		Universite u = universiteRepository.findById(1L).orElse(null);
		System.out.println(u);
	}

	@Test
	public void testUpdateUniversite() {
		Universite u = universiteRepository.findById(1L).orElse(null);
		if (u != null) {
			u.setNbEtudiants(20000.0);
			universiteRepository.save(u);
		}
	}

	@Test
	public void testDeleteUniversite() {
		universiteRepository.deleteById(1L);
	}

	@Test
	public void testListerToutesUniversites() {
		List<Universite> unis = universiteRepository.findAll();
		for (Universite u : unis) {
			System.out.println(u);
		}
	}

	@Test
	public void testFindByNomUniversiteContains() {
		Page<Universite> unis = universiteService.getAllUniversitesParPage(0, 2);
		System.out.println("Taille de la page : " + unis.getSize());
		System.out.println("Total d'universités : " + unis.getTotalElements());
		System.out.println("Nombre total de pages : " + unis.getTotalPages());

		unis.getContent().forEach(u -> System.out.println(u.toString()));

		/*
		 * Ou bien for (Universite u : unis) { System.out.println(u); }
		 */
	}

	@Test
	public void testFindByNomUniversite() {
	    List<Universite> universites = universiteRepository.findByNomUniversite("Université de Tunis");
	    for (Universite u : universites) {
	        System.out.println(u);
	    }
	}

	@Test
	public void testfindByNomUniversiteContains() {
	    List<Universite> universites = universiteRepository.findByNomUniversiteContains("Tunis");
	    for (Universite u : universites) {
	        System.out.println(u);
	    }
	}
	
	@Test
	public void testFindByNomEtudiants() {
	    List<Universite> universites = universiteRepository.findByNomEtudiants("Tunis", 10000.0);
	    for (Universite u : universites) {
	        System.out.println(u);
	    }
	}
	
	@Test
	public void testFindByDomaine() {
	    Domaine dom = new Domaine();
	    dom.setIdDom(1L); 
	    
	    List<Universite> universites = universiteRepository.findByDomaine(dom);
	    
	    for (Universite u : universites) {
	        System.out.println(u);
	    }
	}
	
	@Test
	public void testFindByDomaineIdDom() {
	    List<Universite> universites = universiteRepository.findByDomaineIdDom(1L);
	    for (Universite u : universites) {
	        System.out.println(u);
	    }
	}
	
	@Test
	public void testFindByOrderByNomUniversiteAsc()
	{
	    List<Universite> unis = universiteRepository.findByOrderByNomUniversiteAsc();
	    for (Universite u : unis)
	    {
	        System.out.println(u);
	    }
	}
	
	@Test
	public void testTrierUniversitesNomNbEtudiants() {
	    List<Universite> unis = universiteRepository.trierUniversitesNomNbEtudiants();
	    for (Universite u : unis) {
	        System.out.println(u);
	    }
	}



	



}
