package formation.sopra.SopraQuiz.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.SopraQuiz.entities.views.Views;

@Entity
public class Score {
	@JsonView(Views.Common.class)
	@EmbeddedId
	private ScoreKey key;
	@JsonView(Views.Common.class)
	@Column(name="value")
	private int value;
	
	public Score() {}

	public Score(ScoreKey key) {
		this.key = key;
		this.value = 0;
	}

	public ScoreKey getKey() {
		return key;
	}

	public void setKey(ScoreKey key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
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
		Score other = (Score) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Score = " + value;
	}
	
	
}
