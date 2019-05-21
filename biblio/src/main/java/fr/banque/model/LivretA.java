package fr.banque.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="LIVRET_A")
public class LivretA extends Compte {
	
	@Column(name="taux")
	private double taux;
	
	public LivretA() {
		
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
	
	

}
