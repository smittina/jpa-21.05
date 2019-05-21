package fr.biblio.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="emprunt")
public class Emprunt {
	
	@Id
	private int id;
	
	@Column(name="DATE_DEBUT", nullable=false)
	private LocalDate date_debut;
	
	@Column(name="DATE_FIN", nullable=true)
	private LocalDate date_fin;
	
	@Column(name="DELAI", length=10, nullable=true)
	private int delai;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client;
	
	@ManyToMany
	@JoinTable(name="compo",
		joinColumns=@JoinColumn(name="ID_EMP",referencedColumnName="ID"),
		inverseJoinColumns=@JoinColumn(name="ID_LIV",referencedColumnName="ID")
	)
	private Set<Livre> livres;
	
	


	public Emprunt() {
		livres = new HashSet<Livre>();
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(LocalDate date_debut) {
		this.date_debut = date_debut;
	}
	public LocalDate getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(LocalDate date_fin) {
		this.date_fin = date_fin;
	}
	public int getDelai() {
		return delai;
	}
	public void setDelai(int delai) {
		this.delai = delai;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Set<Livre> getLivres() {
		return livres;
	}


	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}

	
	
}
