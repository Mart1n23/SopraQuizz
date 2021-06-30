package formation.sopra.SopraQuiz.controller.restController;

import java.lang.reflect.Field;
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
import formation.sopra.SopraQuiz.entities.views.Views;
import formation.sopra.SopraQuiz.exceptions.rest.QuestionInvalidException;
import formation.sopra.SopraQuiz.services.QuestionService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/question")
public class QuestionRestController {

	@Autowired
	QuestionService questionService;
	
	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Question> getAllQuestions() {
		return questionService.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public Question getById(@PathVariable Integer id) {
		Question q =questionService.getById(id);
		if(q.getId() == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "question introuvable");
		}
		return q;
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	@JsonView(Views.Common.class)
	public Question create(@Valid @RequestBody Question question, BindingResult br) {
		if(br.hasErrors()) {
			throw new QuestionInvalidException();
		}
		question = questionService.save(question);
		return question;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		questionService.delete(id);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.Common.class)
	public Question update(@Valid @RequestBody Question question, BindingResult br, @PathVariable Integer id) {
		if(br.hasErrors()) {
			throw new QuestionInvalidException();
		}
		question.setId(id);
		questionService.save(question);
		return question;
	}
	
	@PatchMapping("/{id}")
	@JsonView(Views.Common.class)
	public Question personneUpdate(@RequestBody Map<String,Object> fields, @PathVariable Integer id) {
		final Question questionBDD = questionService.getById(id);
		if(questionBDD.getId() == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		fields.forEach((key,value)-> {
			Field field = ReflectionUtils.findField(Question.class, key);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, questionBDD, value);
			});
		questionService.save(questionBDD);
		return questionBDD;
		
	}
}
	
