package com.sarra.universitess;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sarra.universitess.service.UniversiteService;


@SpringBootApplication
public class UniversitessApplication implements CommandLineRunner {

	@Autowired
	UniversiteService universiteService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	/*@PostConstruct
	void init_users() {
		// ajouter les rôles
		userService.addRole(new Role(null, "ADMIN"));
		userService.addRole(new Role(null, "AGENT"));
		userService.addRole(new Role(null, "USER"));
		// ajouter les users
		userService.saveUser(new User(null, "admin", "123", true, null));
		userService.saveUser(new User(null, "nadhem", "123", true, null));
		userService.saveUser(new User(null, "user1", "123", true, null));
		// ajouter les rôles aux users
		userService.addRoleToUser("admin", "ADMIN");
		userService.addRoleToUser("nadhem", "USER");
		userService.addRoleToUser("nadhem", "AGENT");
		userService.addRoleToUser("user1", "USER");
	}*/

	public static void main(String[] args) {
		SpringApplication.run(UniversitessApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Password Encoded BCRYPT :******************** ");
		System.out.println(passwordEncoder.encode("123"));
		// repositoryRestConfiguration.exposeIdsFor(Universite.class);
		/*
		 * universiteService.saveUniversite(new Universite("ISET", "Sousse",
		 * "iset.sousse@iset.tn", 3000.0, new Date()));
		 * universiteService.saveUniversite(new Universite("IHEC", "Carthage",
		 * "contact@ihec.tn", 50000.0, new Date()));
		 * universiteService.saveUniversite(new Universite("FMM", "Monastir",
		 * "med.mon@univ.tn", 4500.0, new Date())); universiteService.saveUniversite(new
		 * Universite("FST Tunis", "Tunis", "fst@fst.tn", 6500.0, new Date()));
		 */

		/*
		 * universiteService.saveDomaine(new Domaine ("Informatique",
		 * "Technologies, développement, réseaux")); universiteService.saveDomaine(new
		 * Domaine ("Économie et Gestion", "Comptabilité, finance, marketing"));
		 * universiteService.saveDomaine(new Domaine ("Sciences Médicales",
		 * "Médecine, pharmacie, paramédica")); universiteService.saveDomaine(new
		 * Domaine ("Biologie", "Sciences de la vie, génétique, écologie"));
		 */
	}

	/*@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}*/
}
