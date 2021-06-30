package formation.sopra.SopraQuiz.controller.restController;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.SopraQuiz.entities.Personne;
import formation.sopra.SopraQuiz.entities.Question;
import formation.sopra.SopraQuiz.entities.Quiz;
import formation.sopra.SopraQuiz.entities.Score;
import formation.sopra.SopraQuiz.entities.ScoreKey;
import formation.sopra.SopraQuiz.entities.views.Views;
import formation.sopra.SopraQuiz.exceptions.rest.QuizInvalidException;
import formation.sopra.SopraQuiz.services.PersonneService;
import formation.sopra.SopraQuiz.services.QuestionService;
import formation.sopra.SopraQuiz.services.QuizService;
import formation.sopra.SopraQuiz.services.ScoreService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/quiz")
public class QuizRestController {

	@Autowired
	QuizService quizService;
	@Autowired
	QuestionService questionService;
	@Autowired
	PersonneService personneService;
	@Autowired
	ScoreService scoreService;

	@GetMapping("")
	@JsonView(Views.Common.class) //common ou quizWithQuestion ?
	public List<Quiz> getAllQuiz() {
		return getAll();
	}

	@GetMapping("/score")
	@JsonView(Views.QuizWithScore.class)
	public List<Quiz> getAllQuizWithScores() {
		return getAll();
	}

	private List<Quiz> getAll() {
		return quizService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public Quiz getQuizById(@PathVariable Integer id) {
		return getById(id);
	}

	@GetMapping("/{id}/score")
	@JsonView(Views.QuizWithScore.class)
	public Quiz getQuizWithScoreById(@PathVariable Integer id) {
		return getById(id);
	}

	private Quiz getById(Integer id) {
		Quiz q = quizService.getById(id);
		if(q.getId() == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "quiz introuvable");
		}
		return q;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	@JsonView(Views.Common.class)
	public Quiz create(@Valid @RequestBody Quiz quiz, BindingResult br) {
		if(br.hasErrors()) {
			throw new QuizInvalidException();
		}
		
		List<Question> listeQuestions = questionService.getAll(); //Ecrire algo choix aleatoire
		quiz.setQuestions(listeQuestions);
		
		Personne personne = personneService.getById(103); //A remplacer par un utilisateur spring
		
		Score score = new Score(new ScoreKey(personne,quiz));
		List<Score> scores = new ArrayList();
		if(quiz.getScores()!=null) {
			scores = quiz.getScores();
		}
		scores.add(score);
		quiz.setScores(scores);
		
		quiz = quizService.save(quiz);
		
		//score sauvegardé après le quiz !!!
		scoreService.save(score);
		return quiz;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		quizService.delete(id);
	}

	@PutMapping("/{id}")
	@JsonView(Views.Common.class)
	public Quiz update(@Valid @RequestBody Quiz quiz, BindingResult br, @PathVariable Integer id) {
		if(br.hasErrors()) {
			throw new QuizInvalidException();
		}
		quiz.setId(id);
		quiz = quizService.save(quiz);
		return quiz;
	}

	@PatchMapping("/{id}")
	@JsonView(Views.Common.class)
	public Quiz quizUpdate(@RequestBody Map<String,Object> fields, @PathVariable Integer id) {
		final Quiz quizBDD = quizService.getById(id);
		if(quizBDD.getId() == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
//		List<Question> listeQuestions = new ArrayList();
		fields.forEach((key,value)-> {
			Field field = ReflectionUtils.findField(Quiz.class, key);
			ReflectionUtils.makeAccessible(field);
//			if(key.equals("questions")) {
//				((Map<String, Object>) value).forEach((k,v)-> {
//					if(k.equals("id")) {
//						listeQuestions.add(questionService.getById(Integer.parseInt(v.toString()))) ;
//					}
//				});
//				quizBDD.setQuestions(listeQuestions);
//			}
//			else {
				ReflectionUtils.setField(field, quizBDD, value);				
//			}
		});
		quizService.save(quizBDD);
		return quizBDD;
	}
}
