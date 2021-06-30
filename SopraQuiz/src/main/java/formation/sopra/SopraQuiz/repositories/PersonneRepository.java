package formation.sopra.SopraQuiz.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formation.sopra.SopraQuiz.entities.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Integer> {

	@Query("SELECT p FROM Personne p LEFT JOIN FETCH p.scores WHERE p.id=:id")
	Optional<Personne> findByIdWithScore(@Param("id") Integer id);
	
	Optional<Personne> findByMail(String string);
}
