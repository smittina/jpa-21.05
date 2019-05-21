package fr.biblio.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.biblio.model.Client;
import fr.biblio.model.Emprunt;

public class EmpruntDao {
	
	EntityManager em;
	
	public EmpruntDao() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-biblio");
		this.em = emf.createEntityManager();
	}
	
	public Emprunt findById(int id) {
		Emprunt e = null;
		e = em.find(Emprunt.class,id);
		return e;
	}
	
	public List<Emprunt> findByClient(Client c) {
		List<Emprunt> e = new ArrayList<Emprunt>();
		TypedQuery<Emprunt> query = em.createQuery("select e from Emprunt e where e.client = :client",Emprunt.class);
		e = query.setParameter("client", c).getResultList();
		return e;
	}
	

}
