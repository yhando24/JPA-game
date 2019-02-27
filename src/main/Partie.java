package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "partie")
public class Partie {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column( nullable=false)
	private int niveau =0;
	@Column( nullable=false)
	private int score =0;
	@Column(name = "date")
	private LocalDate date;
	
	@ManyToMany
	@JoinTable(name = "Joueur_partie", // nom table de jointure
		        joinColumns = @JoinColumn(name = "Joueur_id", referencedColumnName="id"), // non de la colonne id de cette object
		        inverseJoinColumns = @JoinColumn(name = "Partie_id", referencedColumnName="id") // non de la colonne id de lautre table
		    )
	private List<Joueur> joueurs = new ArrayList<>();
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public List<Joueur> getJoueurs() {
		return joueurs;
	}
	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}
	
	public void addjoueur(Joueur joueur) {
		this.joueurs.add(joueur);
		joueur.addPartie(this);

	}
	@Override
	public String toString() {
		return "Partie [id=" + id + ", niveau=" + niveau + ", score=" + score + ", date" + date
				+ ", joueurs=" + joueurs + "]";
	}

	
	
	
	
	
	
}
