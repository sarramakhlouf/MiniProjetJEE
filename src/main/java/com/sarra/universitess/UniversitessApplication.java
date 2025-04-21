package com.sarra.universitess;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.sarra.universitess.entities.Domaine;
import com.sarra.universitess.entities.Universite;
import com.sarra.universitess.service.UniversiteService;

@SpringBootApplication
public class UniversitessApplication implements CommandLineRunner {

    @Autowired
    UniversiteService universiteService;
    
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;


    public static void main(String[] args) {
        SpringApplication.run(UniversitessApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    	//repositoryRestConfiguration.exposeIdsFor(Universite.class);
    	/*universiteService.saveUniversite(new Universite("ISET", "Sousse", "iset.sousse@iset.tn", 3000.0, new Date()));
    	universiteService.saveUniversite(new Universite("IHEC", "Carthage", "contact@ihec.tn", 50000.0, new Date()));
    	universiteService.saveUniversite(new Universite("FMM", "Monastir", "med.mon@univ.tn", 4500.0, new Date()));
    	universiteService.saveUniversite(new Universite("FST Tunis", "Tunis", "fst@fst.tn", 6500.0, new Date()));*/

    	/*universiteService.saveDomaine(new Domaine ("Informatique", "Technologies, développement, réseaux"));
    	universiteService.saveDomaine(new Domaine ("Économie et Gestion", "Comptabilité, finance, marketing"));
    	universiteService.saveDomaine(new Domaine ("Sciences Médicales", "Médecine, pharmacie, paramédica"));
    	universiteService.saveDomaine(new Domaine ("Biologie", "Sciences de la vie, génétique, écologie"));*/
    }

}
