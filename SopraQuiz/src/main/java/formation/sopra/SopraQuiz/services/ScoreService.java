package formation.sopra.SopraQuiz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.sopra.SopraQuiz.entities.Score;
import formation.sopra.SopraQuiz.repositories.ScoreRepository;

@Service
public class ScoreService {

	@Autowired
	ScoreRepository scoreRepository;

	public Score save(Score score) {
		scoreRepository.save(score);
		return score;
	}
	
	
}
