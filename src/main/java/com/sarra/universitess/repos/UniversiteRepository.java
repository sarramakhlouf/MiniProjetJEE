package com.sarra.universitess.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarra.universitess.entities.Universite;

public interface UniversiteRepository  extends JpaRepository<Universite, Long>{
	

}
