package com.sarra.universitess.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.sarra.universitess.dto.UniversiteDTO;
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
    
    @Autowired
    ModelMapper modelMapper;

    @Override
    public UniversiteDTO saveUniversite(UniversiteDTO u) {
    	Universite universite = convertDtoToEntity(u);
        Universite updated = universiteRepository.save(universite); 
        return convertEntityToDto(updated);
    }
    
    @Override
    public UniversiteDTO getUniversite(Long id) {
        return convertEntityToDto (universiteRepository.findById(id).get());
    }

    @Override
    public List<UniversiteDTO> getAllUniversites() {
    	return universiteRepository.findAll().stream()
    			.map(this::convertEntityToDto)
    			.collect(Collectors.toList());
    	//OU BIEN
    	/*List<Universite> unis = universiteRepository.findAll();
    	List<UniversiteDTO> listuniDto = new ArrayList<>(unis.size());
    	for (Universite p : unis)
    	listuniDto.add(convertEntityToDto(p));
    	return listuniDto;*/
    }

    @Override
    public UniversiteDTO updateUniversite(UniversiteDTO u) {
        Universite universite = convertDtoToEntity(u);
        Universite updated = universiteRepository.save(universite); 
        return convertEntityToDto(updated); 
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

	@Override
	public UniversiteDTO convertEntityToDto(Universite universite) {
		
		//modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		UniversiteDTO universiteDTO = modelMapper.map(universite, UniversiteDTO.class);
		return universiteDTO;
		
		/*UniversiteDTO universiteDTO = new UniversiteDTO();
		    universiteDTO.setIdUniversite(universite.getIdUniversite());
		    universiteDTO.setNomUniversite(universite.getNomUniversite());
		    universiteDTO.setAdresseUniversite(universite.getAdresseUniversite());
		    universiteDTO.setEmail(universite.getEmail());
		    universiteDTO.setNbEtudiants(universite.getNbEtudiants());
		    universiteDTO.setDateCreation(universite.getDateCreation());
		    //universiteDTO.setDomaine(universite.getDomaine());
		    return universiteDTO;*/
		    
		    /*return UniversiteDTO.builder()
		        .idUniversite(universite.getIdUniversite())
		        .nomUniversite(universite.getNomUniversite())
		        .adresseUniversite(universite.getAdresseUniversite())
		        .email(universite.getEmail())
		        .nbEtudiants(universite.getNbEtudiants())
		        .dateCreation(universite.getDateCreation())
		        //.nomDom(universite.getDomaine().getNomDom())
		        .domaine(universite.getDomaine())
		        .build();*/
	}

	@Override
	public Universite convertDtoToEntity(UniversiteDTO universiteDto) {
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Universite universite = new Universite();
		return universite = modelMapper.map(universiteDto, Universite.class);

		/*Universite universite = new Universite();
	    universite.setIdUniversite(universiteDto.getIdUniversite());
	    universite.setNomUniversite(universiteDto.getNomUniversite());
	    universite.setAdresseUniversite(universiteDto.getAdresseUniversite());
	    universite.setEmail(universiteDto.getEmail());
	    universite.setNbEtudiants(universiteDto.getNbEtudiants());
	    universite.setDateCreation(universiteDto.getDateCreation());
	    //universite.setDomaine(universiteDto.getDomaine());
	    return universite;*/
	}

}
