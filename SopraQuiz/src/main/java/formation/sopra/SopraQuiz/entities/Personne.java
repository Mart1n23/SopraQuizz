package formation.sopra.SopraQuiz.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.SopraQuiz.entities.views.Views;

@Entity
@SequenceGenerator(name = "seqPersonne", sequenceName = "seq_pers", initialValue = 100, allocationSize = 1 )
public class Personne {
	@JsonView(Views.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPersonne")
	private Integer id;
	@JsonView(Views.Common.class)
	@Column(name = "first_name", length = 150, nullable=false)
    @Size(min=1, max=150)
	private String nom;
	@JsonView(Views.Common.class)
	@Column(name = "last_name", length = 150, nullable=false)
    @Size(min=1, max=150)
	private String prenom;
	@JsonView(Views.Common.class)
	@Column(name="email")
	@NotEmpty
	private String mail; //get by mail
	@Column(name="password")
	private String password;
	@JsonView(Views.Common.class)
	@Enumerated(EnumType.STRING)
	@Column(name="role", length = 50)
	private Role role;
	@JsonView(Views.PersonneWithScore.class)
	@OneToMany(mappedBy="key.personne")
	private List<Score> scores;
	
	public Personne() {}

	public Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	public Personne(String nom, String prenom, String mail, String password) {
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		Personne other = (Personne) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	
}
