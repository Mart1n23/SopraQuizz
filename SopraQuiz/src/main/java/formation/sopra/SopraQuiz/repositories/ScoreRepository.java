package formation.sopra.SopraQuiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import formation.sopra.SopraQuiz.entities.Personne;
import formation.sopra.SopraQuiz.entities.Quiz;
import formation.sopra.SopraQuiz.entities.Score;

public interface ScoreRepository extends JpaRepository<Score, Integer> {

	@Query("DELETE FROM Score s WHERE key.personne=:personne")
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	int deleteByPersonne(@Param("personne") Personne personne);
	
	@Query("DELETE FROM Score s WHERE key.quiz=:quiz")
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	int deleteByQuiz(@Param("quiz") Quiz quiz);
}
