package formation.sopra.SopraQuiz.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import formation.sopra.SopraQuiz.services.AuthService;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	AuthService authService;

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
					.antMatchers(HttpMethod.POST, "/api/personne").anonymous()
					.antMatchers(HttpMethod.DELETE, "/api/question/**").hasRole("ADMIN")
					.antMatchers(HttpMethod.DELETE, "/api/quiz/**").hasRole("ADMIN")
					.antMatchers("/api","/api/**").authenticated()
//					.antMatchers("/api","/api/**").permitAll()
				.and()
				.httpBasic()
			.and()
			.antMatcher("/**").
				authorizeRequests().
					antMatchers("/","/home","/personne/inscription","/personne/save").permitAll().					
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
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(authService);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
