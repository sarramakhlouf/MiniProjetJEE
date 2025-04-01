package com.sarra.universitess;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.sarra.universitess.entities.Universite;
import com.sarra.universitess.service.UniversiteService;

@SpringBootApplication
public class UniversitessApplication implements CommandLineRunner {

    @Autowired
    UniversiteService universiteService;

    public static void main(String[] args) {
        SpringApplication.run(UniversitessApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        universiteService.saveUniversite(new Universite("Université de Tunis", "Tunis", "contact@utn.tn", 5000.00, new Date()));
        universiteService.saveUniversite(new Universite("Université de Sfax", "Sfax", "contact@usf.tn", 7000.00, new Date()));
        universiteService.saveUniversite(new Universite("Université de Monastir", "Monastir", "contact@umon.tn", 6000.00, new Date()));
    }
}
