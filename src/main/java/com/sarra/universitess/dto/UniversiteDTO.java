package com.sarra.universitess.dto;

import java.util.Date;

import com.sarra.universitess.entities.Domaine;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UniversiteDTO {
	private Long idUniversite;
	private String nomUniversite;
	private String adresseUniversite;
	private String email;
	private Double nbEtudiants;
	private Date dateCreation;
	private String nomDom;
	private Domaine domaine;
}
