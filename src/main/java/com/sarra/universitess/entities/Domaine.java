package com.sarra.universitess.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Domaine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDom;
	private String nomDom;
	private String descriptionDom;
	
	@OneToMany(mappedBy = "domaine")
	@JsonIgnore
	private List<Universite> universites;

	public Domaine() {}

	public Domaine(String nomDom, String descriptionDom) {
		super();
		this.nomDom = nomDom;
		this.descriptionDom = descriptionDom;
	}

	public Domaine(String nomDom, String descriptionDom, List<Universite> universites) {
		super();
		this.nomDom = nomDom;
		this.descriptionDom = descriptionDom;
		this.universites = universites;
	}

	public Long getIdDom() {
		return idDom;
	}

	public void setIdDom(Long idDom) {
		this.idDom = idDom;
	}

	public String getNomDom() {
		return nomDom;
	}

	public void setNomDom(String nomDom) {
		this.nomDom = nomDom;
	}

	public String getDescriptionDom() {
		return descriptionDom;
	}

	public void setDescriptionDom(String descriptionDom) {
		this.descriptionDom = descriptionDom;
	}

	public List<Universite> getUniversites() {
		return universites;
	}

	public void setUniversites(List<Universite> universites) {
		this.universites = universites;
	}
	
	
	



}
