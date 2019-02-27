package main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
public class Joueur implements Comparable  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length=50, nullable=false)
	private String nom;
	@Column(length=50, nullable=false)
	private String mail;
	@Column(length=50, nullable=false, unique=true)
	private String pseudo;
	
	@OneToOne
	private Avatar avatar;

	 @ManyToMany(mappedBy = "joueurs")
	    private List<Partie> parties = new ArrayList<>();
	    
	
	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	

	public List<Partie> getParties() {
		return parties;
	}


	public void setParties(List<Partie> parties) {
		this.parties = parties;
	}
	
	public void addPartie(Partie partie) {
		this.parties.add(partie);
	}


	
	public Avatar getAvatar() {
		return avatar;
	}


	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}


	@Override
	public String toString() {
		return "Joueur [id=" + id + ", nom=" + nom + ", mail=" + mail + ", pseudo=" + pseudo
				+ "]";
	}
	
	
	
	@Override
	public int compareTo(Object o) {
		
		Joueur p = (Joueur) o;
		int result = pseudo.compareToIgnoreCase(p.getPseudo());

		return result;
	
	}


	
}
