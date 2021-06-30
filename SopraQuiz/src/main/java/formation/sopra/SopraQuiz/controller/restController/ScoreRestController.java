package formation.sopra.SopraQuiz.controller.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.SopraQuiz.config.PersonneSpring;
import formation.sopra.SopraQuiz.entities.Personne;
import formation.sopra.SopraQuiz.entities.Quiz;
import formation.sopra.SopraQuiz.entities.Score;
import formation.sopra.SopraQuiz.entities.ScoreKey;
import formation.sopra.SopraQuiz.entities.views.Views;
import formation.sopra.SopraQuiz.services.QuizService;
import formation.sopra.SopraQuiz.services.ScoreService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/score")
public class ScoreRestController {
	
	@Autowired
	ScoreService scoreService;
	@Autowired
	QuizService quizService;

	@PostMapping("/{idQuiz}")
	@JsonView(Views.ScoreWithKey.class)
	public Score quizWithScoreUpdate(@RequestBody Score score, @PathVariable Integer idQuiz, @AuthenticationPrincipal PersonneSpring persoSpring) {
		Quiz quizBDD = quizService.getById(idQuiz);
		if(quizBDD.getId() == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		Personne personne = persoSpring.getPersonne();
		score.setKey(new ScoreKey(personne,quizBDD));
		scoreService.save(score);
		return score;
	}
}
