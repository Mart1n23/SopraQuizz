package formation.sopra.SopraQuiz.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.SopraQuiz.entities.views.Views;

@Embeddable
public class ScoreKey implements Serializable {
	
	@ManyToOne
    @JoinColumn(name = "score_personne_id",foreignKey=@ForeignKey(name="score_personne_id_fk"))
	private Personne personne;
	@JsonView(Views.PersonneWithScore.class)
	@ManyToOne
    @JoinColumn(name = "score_quiz_id",foreignKey=@ForeignKey(name="score_quiz_id_fk"))
	private Quiz quiz;
	
	public ScoreKey() {}

	public ScoreKey(Personne personne, Quiz quiz) {
		this.personne = personne;
		this.quiz = quiz;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((personne == null) ? 0 : personne.hashCode());
		result = prime * result + ((quiz == null) ? 0 : quiz.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScoreKey other = (ScoreKey) obj;
		if (personne == null) {
			if (other.personne != null)
				return false;
		} else if (!personne.equals(other.personne))
			return false;
		if (quiz == null) {
			if (other.quiz != null)
				return false;
		} else if (!quiz.equals(other.quiz))
			return false;
		return true;
	}
	
	
	
}
