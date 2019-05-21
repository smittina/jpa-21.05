package fr.biblio.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.biblio.model.Client;

public class ClientDao {
	EntityManager em;
	
	public ClientDao() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-biblio");
		this.em = emf.createEntityManager();
	}
	
	public Client findById(int id) {
		Client c = null;
		c = em.find(Client.class, id);
		return c;
	}
}
