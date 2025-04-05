package com.sarra.universitess.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomUniv", types = { Universite.class })
public interface UniversiteProjection {
	public String getNomUniversite();

}
