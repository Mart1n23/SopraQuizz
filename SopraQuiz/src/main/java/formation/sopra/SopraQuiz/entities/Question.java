package formation.sopra.SopraQuiz.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.SopraQuiz.entities.views.Views;

@Entity
@SequenceGenerator(name="seqQuestion", sequenceName = "seq_question", initialValue = 100, allocationSize = 1)
public class Question {
	@JsonView(Views.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqQuestion")
	private Integer id;
	@JsonView(Views.Common.class)
	@Lob
	@Column(name="title")
	@NotNull
	private String intitule;
	@JsonView(Views.Common.class)
	@Lob
	@Column(name="ans1")
	@NotNull
	private String reponse1;
	@JsonView(Views.Common.class)
	@Lob
	@Column(name="ans2")
	@NotNull
	private String reponse2;
	@JsonView(Views.Common.class)
	@Lob
	@Column(name="ans3")
	@NotNull
	private String reponse3;
	@JsonView(Views.Common.class)
	@Lob
	@Column(name="ans4")
	@NotNull
	private String reponse4;
	@JsonView(Views.Common.class)
	@Column(name="valid")
	private int verif;
	
	public Question() {}

	public Question(String intitule, String reponse1, String reponse2, String reponse3, String reponse4, int verif) {
		this.intitule = intitule;
		this.reponse1 = reponse1;
		this.reponse2 = reponse2;
		this.reponse3 = reponse3;
		this.reponse4 = reponse4;
		this.verif = verif;
	}

	public Question(String intitule) {
		this.intitule = intitule;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getReponse1() {
		return reponse1;
	}

	public void setReponse1(String reponse1) {
		this.reponse1 = reponse1;
	}

	public String getReponse2() {
		return reponse2;
	}

	public void setReponse2(String reponse2) {
		this.reponse2 = reponse2;
	}

	public String getReponse3() {
		return reponse3;
	}

	public void setReponse3(String reponse3) {
		this.reponse3 = reponse3;
	}

	public String getReponse4() {
		return reponse4;
	}

	public void setReponse4(String reponse4) {
		this.reponse4 = reponse4;
	}

	public int getVerif() {
		return verif;
	}

	public void setVerif(int verif) {
		this.verif = verif;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", intitule=" + intitule + ",\nreponse1=" + reponse1 + ",\nreponse2=" + reponse2
				+ ",\nreponse3=" + reponse3 + ",\nreponse4=" + reponse4 + ",\nverif=" + verif + "]";
	}
	
	
	
}
