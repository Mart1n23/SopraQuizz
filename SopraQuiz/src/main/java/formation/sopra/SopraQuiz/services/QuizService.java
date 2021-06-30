package formation.sopra.SopraQuiz.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.sopra.SopraQuiz.entities.Question;
import formation.sopra.SopraQuiz.entities.Quiz;
import formation.sopra.SopraQuiz.repositories.QuizRepository;
import formation.sopra.SopraQuiz.repositories.ScoreRepository;

@Service
public class QuizService {

	@Autowired
	QuizRepository quizRepository;
	@Autowired
	ScoreRepository scoreRepository;

	public Quiz save(Quiz quiz) {
		quizRepository.save(quiz);
		//		scoreRepository.deleteByQuiz(quiz);
		//		quiz.getScores().stream().forEach(scoreRepository::save);
		return quiz;
	}
	
	public List<Quiz> getAll() {
		return quizRepository.findAll();
	}

	public void delete(Quiz quiz) {
		delete(quiz.getId());
	}

	public void delete(Integer id) {
		if(id != null) {
			Optional<Quiz> opt = quizRepository.findById(id);
			if(opt.isPresent()) {
				if(!opt.get().isRanked()) {
					scoreRepository.deleteByQuiz(opt.get());
					quizRepository.delete(opt.get());
				}
			}
		}
	}

	public Quiz getByNiveau(int niveau) {
		Optional<Quiz> opt = quizRepository.findByNiveau(niveau);
		if(opt.isPresent()) {
			return opt.get();
		}
		Quiz q = new Quiz();
		q.setNiveau(niveau);
		return q;
	}
	
	public Quiz getById(Integer id) {
		if(id!=null) {
			Optional<Quiz> opt = quizRepository.findById(id);
			if(opt.isPresent()) {
				return opt.get();
			}
		}
		return new Quiz();
	}

	public Quiz getByIdWithQuestion(Integer id) {
		if(id!=null) {
			Optional<Quiz> opt = quizRepository.findByIdWithQuestion(id);
			if(opt.isPresent()) {
				return opt.get();
			}
		}
		return new Quiz();
	}

	public Quiz getByIdWithScore(Integer id) {
		if(id!=null) {
			Optional<Quiz> opt = quizRepository.findByIdWithScore(id);
			if(opt.isPresent()) {
				return opt.get();
			}
		}
		return new Quiz();
	}
}
