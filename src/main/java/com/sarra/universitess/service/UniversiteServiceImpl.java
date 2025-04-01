package com.sarra.universitess.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.sarra.universitess.entities.Universite;
import com.sarra.universitess.repos.UniversiteRepository;

@Service
public class UniversiteServiceImpl implements UniversiteService {

    @Autowired
    private UniversiteRepository universiteRepository;

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
}
