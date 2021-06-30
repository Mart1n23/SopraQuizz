package formation.sopra.SopraQuiz.exceptions.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, value = HttpStatus.BAD_REQUEST, reason = "donnees du quiz invalides")
public class QuizInvalidException extends RuntimeException {

}
