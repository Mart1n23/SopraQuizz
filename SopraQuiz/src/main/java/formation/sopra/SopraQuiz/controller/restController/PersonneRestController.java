package formation.sopra.SopraQuiz.controller.restController;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import formation.sopra.SopraQuiz.entities.Role;
import formation.sopra.SopraQuiz.entities.views.Views;
import formation.sopra.SopraQuiz.exceptions.rest.PersonneInvalidException;
import formation.sopra.SopraQuiz.services.PersonneService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/personne")
public class PersonneRestController {

	@Autowired
	PersonneService personneService;
	@Autowired
	PasswordEncoder pwdEncoder;

	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Personne> getAllPersonnes() {
		return getAll();
	}

	@GetMapping("/score")
	@JsonView(Views.PersonneWithScore.class)
	public List<Personne> getAllPersonnesWithScores() {
		return getAll();
	}

	private List<Personne> getAll() {
		return personneService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public Personne getPersonneById(@PathVariable Integer id) {
		return getById(id);
	}

	@GetMapping("/{id}/score")
	@JsonView(Views.PersonneWithScore.class)
	public Personne getPersonneWithScoreById(@PathVariable Integer id) {
		return getById(id);
	}

	private Personne getById(Integer id) {
		Personne p = personneService.getById(id);
		if(p.getId() == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "personne introuvable");
		}
		return p;
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	@JsonView(Views.Common.class)
	public Personne create(@Valid @RequestBody Personne personne, BindingResult br) {
		if(br.hasErrors()) {
			throw new PersonneInvalidException();
		}
		personne.setPassword(pwdEncoder.encode(personne.getPassword()));
		personne = personneService.save(personne);
		return personne;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		personneService.delete(id);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.Common.class)
	public Personne update(@Valid @RequestBody Personne personne, BindingResult br, @PathVariable Integer id) {
		if(br.hasErrors()) {
			throw new PersonneInvalidException();
		}
		personne.setId(id);
		if(!personne.getPassword().isEmpty()) {
			personne.setPassword(pwdEncoder.encode(personne.getPassword()));
		}
		personne = personneService.save(personne);
		return personne;
	}
	
	@PatchMapping("/{id}")
	@JsonView(Views.Common.class)
	public Personne personneUpdate(@RequestBody Map<String,Object> fields, @PathVariable Integer id) {
		final Personne personneBDD = personneService.getById(id);
		if(personneBDD.getId() == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		fields.forEach((key,value)-> {
			Field field = ReflectionUtils.findField(Personne.class, key);
			ReflectionUtils.makeAccessible(field);
//			if(key.equals("role")) {
//				ReflectionUtils.setField(field, personneBDD, Role.valueOf((String) value));
//			}
			if(key.equals("password")) {
				value = pwdEncoder.encode(value.toString());
			}
			if(!key.equals("role")) {
				ReflectionUtils.setField(field, personneBDD, value);
			}
			});
		personneService.save(personneBDD);
		return personneBDD;
	}
	
}
