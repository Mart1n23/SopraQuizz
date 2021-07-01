package formation.sopra.SopraQuiz.config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import formation.sopra.SopraQuiz.entities.Personne;

public class PersonneSpring implements UserDetails {
	
	private Personne personne;
	
	public PersonneSpring(Personne personne) {
		this.personne = personne;
	}

	public Personne getPersonne() {
		return personne;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority(personne.getRole().toString()));
	}

	@Override
	public String getPassword() {
		return personne.getPassword();
	}

	@Override
	public String getUsername() {
		return personne.getMail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
