package com.sarra.universitess;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

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
    	repositoryRestConfiguration.exposeIdsFor(Universite.class);
    }

}
