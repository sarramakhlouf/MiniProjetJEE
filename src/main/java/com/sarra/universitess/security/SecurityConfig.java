package com.sarra.universitess.security;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	/*@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> requests

				.requestMatchers("/universites/api/**").permitAll()
				.requestMatchers("/showCreate", "/saveUniversite").hasAnyAuthority("ADMIN", "AGENT")
				.requestMatchers("/modifierUniversite", "/supprimerUniversite").hasAnyAuthority("ADMIN")
				.requestMatchers("/ListeUniversites").hasAnyAuthority("ADMIN", "AGENT", "USER")
				.requestMatchers("/login","/webjars/**").permitAll()
				.anyRequest().authenticated())

				.formLogin((formLogin) -> formLogin.loginPage("/login").defaultSuccessUrl("/") )
				.httpBasic(Customizer.withDefaults())

				.exceptionHandling((exception) -> exception.accessDeniedPage("/accessDenied"));

		return http.build();
	}*/
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http
	        .csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests(auth -> auth
	            .anyRequest().permitAll()
	        );
	    return http.build();
	}


	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	/*@Bean
	public UserDetailsService userDetailsService(DataSource dataSource) {
		JdbcUserDetailsManager jdbcUserDetailsManager =new
		JdbcUserDetailsManager(dataSource);
	
		jdbcUserDetailsManager.setUsersByUsernameQuery("select username, password, enabled from user where username =?");
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT u.username, r.role as authority " +
		"FROM user_role ur, user u , role r " +
		"WHERE u.user_id = ur.user_id "
		+ "AND ur.role_id = r.role_id AND u.username = ?");
	
		 return jdbcUserDetailsManager;
	 }*/
	
	/*@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		PasswordEncoder passwordEncoder = passwordEncoder();

		UserDetails admin = User.withUsername("admin").password(passwordEncoder.encode("123")).authorities("ADMIN")
				.build();
		UserDetails userSarra = User.withUsername("Sarra").password(passwordEncoder.encode("123"))
				.authorities("AGENT", "USER").build();
		UserDetails user1 = User.withUsername("user1").password(passwordEncoder.encode("123")).authorities("USER")
				.build();

		return new InMemoryUserDetailsManager(admin, userSarra, user1);
	}*/
}
