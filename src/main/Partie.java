package main;

import java.time.LocalDate;

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
	@Column(name = "dateNaissance")
	private LocalDate datedeNaissance;
	
	
	
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
	public LocalDate getDatedeNaissance() {
		return datedeNaissance;
	}
	public void setDatedeNaissance(LocalDate datedeNaissance) {
		this.datedeNaissance = datedeNaissance;
	}
	@Override
	public String toString() {
		return "Partie [id=" + id + ", niveau=" + niveau + ", score=" + score + ", datedeNaissance=" + datedeNaissance
				+ "]";
	}
	
	
	
	
	
}
