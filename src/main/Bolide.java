package main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bolide extends Engin {
	
	
	
	@Column( nullable=false, length = 50)
	private int nb_roues;
	@Column( nullable=false, length = 50)
	private int autonomie_heure;
	

	public int getNb_roues() {
		return nb_roues;
	}
	public void setNb_roues(int nb_roues) {
		this.nb_roues = nb_roues;
	}
	public int getAutonomie_heure() {
		return autonomie_heure;
	}
	public void setAutonomie_heure(int autonomie_heure) {
		this.autonomie_heure = autonomie_heure;
	}
	@Override
	public String toString() {
		return "Bolide [nb_roues=" + nb_roues + ", autonomie_heure=" + autonomie_heure + ", getCouleur()="
				+ getCouleur() + ", getVitesse_max()=" + getVitesse_max() + ", getAvatar()=" + getAvatar()
				+ ", getId()=" + getId() + ", getClass()=" + getClass() + "]";
	}
	
	
	
	
	
	
}
