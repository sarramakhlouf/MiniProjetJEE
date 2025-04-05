package com.sarra.universitess.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sarra.universitess.entities.Domaine;
import com.sarra.universitess.entities.Universite;

@RepositoryRestResource(path = "rest")
public interface UniversiteRepository  extends JpaRepository<Universite, Long>{
	
	List<Universite> findByNomUniversite(String nom);
	List<Universite> findByNomUniversiteContains(String nom);
	
	@Query("select u from Universite u where u.nomUniversite like %?1% and u.nbEtudiants > ?2")
	List<Universite> findByNomAndEtudiants(String nom, Double nbEtudiants);
	
	@Query("select u from Universite u where u.nomUniversite like %:nom% and u.nbEtudiants > :nb")
	List<Universite> findByNomEtudiants(@Param("nom") String nom, @Param("nb") Double nbEtudiants);
	
	@Query("select u from Universite u where u.domaine = ?1")
	List<Universite> findByDomaine(Domaine domaine);

	List<Universite> findByDomaineIdDom(Long id);
	List<Universite> findByOrderByNomUniversiteAsc();
	
	@Query("select u from Universite u order by u.nomUniversite ASC, u.nbEtudiants DESC")
	List<Universite> trierUniversitesNomNbEtudiants();


}
