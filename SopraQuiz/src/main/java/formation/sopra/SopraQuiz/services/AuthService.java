package formation.sopra.SopraQuiz.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import formation.sopra.SopraQuiz.config.PersonneSpring;
import formation.sopra.SopraQuiz.entities.Personne;
import formation.sopra.SopraQuiz.repositories.PersonneRepository;

@Service
public class AuthService implements UserDetailsService {

	@Autowired
	PersonneRepository personneRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Personne> opt=personneRepo.findByMail(username);
		if (opt.isPresent()) {
			return new PersonneSpring(opt.get());
		}
		else {
			throw new UsernameNotFoundException("Compte introuvable");
		}
	}
}
