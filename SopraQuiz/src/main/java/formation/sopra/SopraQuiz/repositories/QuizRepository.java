package formation.sopra.SopraQuiz.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formation.sopra.SopraQuiz.entities.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {

	@Query("SELECT q FROM Quiz q LEFT JOIN FETCH q.questions WHERE q.id=:id")
	Optional<Quiz> findByIdWithQuestion(@Param("id") Integer id);
	
	@Query("SELECT q FROM Quiz q LEFT JOIN FETCH q.scores WHERE q.id=:id")
	Optional<Quiz> findByIdWithScore(Integer id);
	
	Optional<Quiz> findByNiveau(int niveau);
}
