package formation.sopra.SopraQuiz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//formatter:off
		http.
			antMatcher("/api/**")
				.csrf().ignoringAntMatchers("/api","/api/**") //pas de csrf pour les WebServices, car il n'y a pas d'échange avec le serveur !
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //autorise des requêtes sans que l'utilisateur n'ait de session sur le serveur
				.and()
				.authorizeRequests()
					.antMatchers(HttpMethod.OPTIONS).anonymous() //angular envoie une requête OPTIONS automatiquement, il faut donc l'autoriser !
					.antMatchers("/api/fournisseur","/api/fournisseur/**").hasRole("ADMIN")
					.antMatchers(HttpMethod.POST, "/api/commande").hasRole("USER")
					.antMatchers(HttpMethod.POST, "/api/client").anonymous()
					.antMatchers(HttpMethod.POST, "/api/produit").hasRole("ADMIN")
					.antMatchers(HttpMethod.PUT, "/api/produit/**").hasRole("ADMIN")
					.antMatchers(HttpMethod.DELETE, "/api/produit/**").hasRole("ADMIN")
					.antMatchers("/api/produit","/api/produit/**").hasRole("ADMIN")
					.antMatchers("/api","/api/**").authenticated()
				.and()
				.httpBasic()
			.and()
			.antMatcher("/**").
				authorizeRequests().
					antMatchers("/","/home","/commande/**","/client/inscription","/client/save").permitAll().
					
					antMatchers("/client/history","/client/history/details").authenticated().
					
					antMatchers("/produit","/produit/**").hasAnyRole("ADMIN"). //Spring le gère automatiquement comme ROLE_ADMIN
					antMatchers("/client", "/client/**").hasAnyRole("ADMIN").
					antMatchers("/fournisseur", "/fournisseur/**").hasAnyRole("ADMIN").
					
					anyRequest().authenticated().
				and().
				formLogin().
					loginPage("/login").
					defaultSuccessUrl("/").
					failureUrl("/login?error").
					permitAll()
				.and()
				.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/?logout");
		//formatter:on
	}
	
	
}
