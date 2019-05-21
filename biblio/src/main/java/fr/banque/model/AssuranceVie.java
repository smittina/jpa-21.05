package fr.banque.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ASSURANCE_VIE")
public class AssuranceVie extends Compte {
	
	@Column(name="DATE_FIN")
	private LocalDate dateFin;
	
	@Column(name="TAUX")
	private double taux;
	
	public AssuranceVie() {
		
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
	
	
}
