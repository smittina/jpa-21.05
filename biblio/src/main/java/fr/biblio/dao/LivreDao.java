package fr.biblio.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.biblio.model.Livre;

public class LivreDao {
	EntityManager em;
	
	public LivreDao() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-biblio");
		this.em = emf.createEntityManager();
	}
	
	public Livre findLivreById(int id) {
		Livre l = null;
		l = em.find(Livre.class, id);
		return l;
	}
	
	public Livre findLivreByTitre(String titre) {
		Livre l = null;
		TypedQuery<Livre> query = em.createQuery("select l from Livre l where l.titre = :titre",Livre.class);
		l = query.setParameter("titre", titre).getSingleResult();
		return l;
	}
}
