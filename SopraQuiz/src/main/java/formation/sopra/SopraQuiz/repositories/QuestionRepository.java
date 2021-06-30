package formation.sopra.SopraQuiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.sopra.SopraQuiz.entities.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
