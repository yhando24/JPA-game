package main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Table
@Entity
public class Avatar {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length=50, nullable=false)
	private String nom;
	@Column(nullable=false)
	private int puissance;
	
	@OneToOne(optional = true)
	private Joueur joueur;
	
	public int getId() {
		return id;
	}
	
	@OneToMany(mappedBy="avatar")
	private List<Engin> engins = new ArrayList<>();

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getPuissance() {
		return puissance;
	}
	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}
	public Joueur getJoueur() {
		return joueur;
	}
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	public List<Engin> getEngins() {
		return engins;
	}
	public void setEngins(List<Engin> engins) {
		this.engins = engins;
	}

	public void addEngin(Engin engin) {
		this.engins.add(engin);
	}
	
	public void removeEngin(int id) {
		this.engins.remove(id);
	}
	
	
}
