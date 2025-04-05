package com.sarra.universitess.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Universite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUniversite;
	private String nomUniversite;
	private String adresseUniversite;
	private String email;
	private Double nbEtudiants;
	private Date dateCreation;
	
	@ManyToOne
	private Domaine domaine;


	public Universite() {
		super();
	}

	public Universite(String nomUniversite, String adresseUniversite, String email, Double nbEtudiants,
			Date dateCreation) {
		super();
		this.nomUniversite = nomUniversite;
		this.adresseUniversite = adresseUniversite;
		this.email = email;
		this.nbEtudiants = nbEtudiants;
		this.dateCreation = dateCreation;
	}

	public Long getIdUniversite() {
		return idUniversite;
	}

	public void setIdUniversite(Long idUniversite) {
		this.idUniversite = idUniversite;
	}

	public String getNomUniversite() {
		return nomUniversite;
	}

	public void setNomUniversite(String nomUniversite) {
		this.nomUniversite = nomUniversite;
	}

	public String getAdresseUniversite() {
		return adresseUniversite;
	}

	public void setAdresseUniversite(String adresseUniversite) {
		this.adresseUniversite = adresseUniversite;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getNbEtudiants() {
		return nbEtudiants;
	}

	public void setNbEtudiants(Double nbEtudiants) {
		this.nbEtudiants = nbEtudiants;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	public Domaine getDomaine() {
		return domaine;
	}

	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}

	@Override
	public String toString() {
		return "Universite [idUniversite=" + idUniversite + ", nomUniversite=" + nomUniversite + ", adresseUniversite="
				+ adresseUniversite + ", email=" + email + ", nbEtudiants=" + nbEtudiants + ", dateCreation="
				+ dateCreation + "]";
	}
	
	

}
