package formation.sopra.SopraQuiz.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.sopra.SopraQuiz.entities.Personne;
import formation.sopra.SopraQuiz.entities.Question;
import formation.sopra.SopraQuiz.repositories.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	QuestionRepository questionRepository;

	public Question save(Question question) {
		questionRepository.save(question);
		return question;
	}

	public List<Question> getAll() {
		return questionRepository.findAll();
	}

	public Question getById(Integer id) {
		if(id!=null) {
			Optional<Question> opt = questionRepository.findById(id);
			if(opt.isPresent()) {
				return opt.get();
			}
		}
		return new Question();
	}
	
	public void delete(Question question) {
		delete(question.getId());
	}

	public void delete(Integer id) {
		if (id != null) {
			Optional<Question> opt = questionRepository.findById(id);
			if (opt.isPresent()) {
				questionRepository.delete(opt.get());
			}
		}
		
	}
	
	
}
