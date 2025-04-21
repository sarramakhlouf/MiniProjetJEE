package com.sarra.universitess.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
public class Universite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUniversite;
	
	@NotNull
	//@Size (min = 4,max = 15)
	private String nomUniversite;
	
	@NotNull
	private String adresseUniversite;

	@NotNull
	private String email;
	
	@Min(value = 1000)
	@Max(value = 50000)
	private Double nbEtudiants;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
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

	public Universite(Long idUniversite, @NotNull String nomUniversite, @NotNull String adresseUniversite,
			@NotNull String email, @Min(1000) @Max(50000) Double nbEtudiants, @PastOrPresent Date dateCreation,
			Domaine domaine) {
		super();
		this.idUniversite = idUniversite;
		this.nomUniversite = nomUniversite;
		this.adresseUniversite = adresseUniversite;
		this.email = email;
		this.nbEtudiants = nbEtudiants;
		this.dateCreation = dateCreation;
		this.domaine = domaine;
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
