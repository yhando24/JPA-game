package main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aeronef extends Engin{
	
	
	
	@Column( nullable=false, length = 50)
	private String type;
	@Column( nullable=false, length = 50)
	private int autonomie_km;
	
	

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAutonomie_km() {
		return autonomie_km;
	}
	public void setAutonomie_km(int autonomie_km) {
		this.autonomie_km = autonomie_km;
	}
	@Override
	public String toString() {
		return "Aeronef [type=" + type + ", autonomie_km=" + autonomie_km + ", getCouleur()=" + getCouleur()
				+ ", getVitesse_max()=" + getVitesse_max() + ", getAvatar()=" + getAvatar() + ", getClass()="
				+ getClass() + "]";
	}
	
	
	
	
}
