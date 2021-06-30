package formation.sopra.SopraQuiz.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.sopra.SopraQuiz.entities.Personne;
import formation.sopra.SopraQuiz.repositories.PersonneRepository;
import formation.sopra.SopraQuiz.repositories.QuizRepository;
import formation.sopra.SopraQuiz.repositories.ScoreRepository;

@Service
public class PersonneService {

	@Autowired
	private PersonneRepository personneRepository;
	@Autowired
	private ScoreRepository scoreRepository;
	@Autowired
	private QuizRepository quizRepository;

	public Personne save(Personne personne) {
		personneRepository.save(personne);
//		personne.getScores().stream().forEach(scoreRepository::save);
		return personne;
	}
	
	

	public List<Personne> getAll() {
		return personneRepository.findAll();
	}

	public Personne getById(Integer id) {		
		if(id!=null) {
			Optional<Personne> opt=personneRepository.findById(id);
			if(opt.isPresent()) {
				return opt.get();
			}
		}
		return new Personne();
	}
	
	public Personne getByIdWithScore(Integer id) {		
		if(id!=null) {
			Optional<Personne> opt=personneRepository.findByIdWithScore(id);
			if(opt.isPresent()) {
				return opt.get();
			}
		}
		return new Personne();
	}
	
	public Personne getByMail(String mail) {
		if(mail!=null) {
			Optional<Personne> opt=personneRepository.findByMail(mail);
			if(opt.isPresent()) {
				return opt.get();
			}
		}
		return new Personne();
	}
	
	public void delete(Personne personne) {
		delete(personne.getId());
	}

	public void delete(Integer id) {
		if (id != null) {
			Optional<Personne> opt = personneRepository.findByIdWithScore(id);
			if (opt.isPresent()) {
				Personne p = opt.get();
				p.getScores().stream().forEach(s -> {
					if(!s.getKey().getQuiz().isRanked()) {
						quizRepository.delete(s.getKey().getQuiz());
					}
				});
				scoreRepository.deleteByPersonne(p);
				personneRepository.delete(p);
			}
		}
	}
}
