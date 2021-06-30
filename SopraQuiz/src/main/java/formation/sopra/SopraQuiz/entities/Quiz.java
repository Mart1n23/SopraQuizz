package formation.sopra.SopraQuiz.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.SopraQuiz.entities.views.Views;

@Entity
@SequenceGenerator(name = "seqQuiz", sequenceName = "seq_quiz", initialValue = 100, allocationSize = 1 )
public class Quiz {
	@JsonView(Views.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seqQuiz")
	private Integer id;
	@JsonView(Views.Common.class)@Column(name="title", length= 150, nullable = false)
	private String nom;
	@JsonView(Views.Common.class)
	@Column(name="level", nullable = false)
	@Positive
	private int niveau;
	@JsonView(Views.Common.class)
	@Column(name="ranked", nullable = false)
	@NotNull
	private boolean ranked;
	@JsonView(Views.QuizWithQuestion.class) //annoter les joinColumns ?
	@ManyToMany
	@JoinTable(
			name = "quiz_with_questions",
			uniqueConstraints = @UniqueConstraint(columnNames = {"id_quiz", "id_question"}),
			joinColumns = @JoinColumn(name="id_quiz", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name="id_question", referencedColumnName = "id")
			)
//	@JoinColumn(name = "id_question", foreignKey = @ForeignKey(name = "quiz_id_question_fk"))
	private List<Question> questions;
	@JsonView(Views.QuizWithScore.class)
    @OneToMany(mappedBy="key.quiz")
	private List<Score> scores;
	
	public Quiz() {}

	public Quiz(String nom, int niveau, boolean ranked) {
		this.nom = nom;
		this.niveau = niveau;
		this.ranked = ranked;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public boolean isRanked() {
		return ranked;
	}

	public void setRanked(boolean ranked) {
		this.ranked = ranked;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Quiz other = (Quiz) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Quiz [nom=" + nom + ", niveau=" + niveau + ", ranked=" + ranked + "]";
	}
	
	
	
}
