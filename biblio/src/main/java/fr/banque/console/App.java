package fr.banque.console;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.banque.model.Adresse;
import fr.banque.model.AssuranceVie;
import fr.banque.model.Banque;
import fr.banque.model.Client;
import fr.banque.model.Compte;
import fr.banque.model.LivretA;
import fr.banque.model.Operation;
import fr.banque.model.Virement;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-banque"); 
		EntityManager em = factory.createEntityManager();
		
		/*----------------- TP 3 ----------------------------- */
		// Création d'une Banque
		Banque b = new Banque();
		b.setNom("Banque 1");
		
		// Création d'un Client
		Adresse a1 = new Adresse();
		a1.setNumero(10);
		a1.setRue("Rue de l'Olivier");
		a1.setVille("Marseille");
		a1.setCodePostal(13013);
		Client c1 = new Client();
		c1.setNom("Nom 1");
		c1.setPrenom("Prenom 1");
		c1.setAdresse(a1);
		c1.setBanque(b);
		c1.setDateNaissance(LocalDate.parse("1990-04-02"));
		
		// Création d'un compte
		Compte compte1 = new Compte();
		compte1.setNumero("1561MLD");
		compte1.setSolde(15642);
		Set<Client> clients = new HashSet<Client>();
		clients.add(c1);
		compte1.setClients(clients);
		
		// Création d'une opération
		Operation op1 = new Operation();
		op1.setDate(LocalDateTime.parse("2019-05-21 16:10:11",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		op1.setMontant(1005);
		op1.setMotif("Besoin d'argent");
		op1.setCompte(compte1);
		
		// TRANSACTION
		em.getTransaction().begin();
		em.persist(b);
		em.persist(c1);
		em.persist(compte1);
		em.persist(op1);
		em.getTransaction().commit();
		
		
		/* -------------------------- TP 4 --------------------------------------- */
		
		// Compte associé à deux clients
		Client c2 = new Client();
		c2.setNom("Nom 2");
		c2.setPrenom("Prenom 2");
		c2.setBanque(b);
		c2.setAdresse(a1);
		c2.setDateNaissance(LocalDate.parse("1997-07-12"));
		
		Set<Client> deuxClients = new HashSet<Client>();
		deuxClients.add(c1);
		deuxClients.add(c2);
		
		Compte compte2 = new Compte();
		compte2.setNumero("16546MDF");
		compte2.setSolde(15004);
		compte2.setClients(deuxClients);
		
		em.getTransaction().begin();
		em.persist(c2);
		em.persist(compte2);
		em.getTransaction().commit();
		
		// Un client avec plusieurs comptes : un compte Assurance Vie et un compte Livret A
		AssuranceVie av1 = new AssuranceVie();
		av1.setNumero("46954MLP");
		av1.setSolde(1500);
		av1.setTaux(0.5);
		av1.setDateFin(LocalDate.parse("2019-05-30"));
		
		LivretA la1 = new LivretA();
		la1.setNumero("154GGG");
		la1.setSolde(10);
		la1.setTaux(0.1);
		
		Set<Compte> comptesDiff = new HashSet<Compte>();
		comptesDiff.add(av1);
		comptesDiff.add(la1);
		
		Client c3 = new Client();
		c3.setAdresse(a1);
		c3.setBanque(b);
		c3.setNom("Nom 3");
		c3.setPrenom("Prenom 3");
		c3.setDateNaissance(LocalDate.parse("1990-05-22"));
		c3.setComptes(comptesDiff);
		
		em.getTransaction().begin();
		em.persist(av1);
		em.persist(la1);
		em.persist(c3);
		em.getTransaction().commit();
		
		// Insertion d'opérations de type virement sur un compte
		Compte compte3 = new Compte();
		compte3.setNumero("1564");
		compte3.setSolde(1500);
		compte3.setClients(deuxClients);
		
		Virement v1 = new Virement();
		v1.setMontant(140);
		v1.setCompte(compte3);
		v1.setBeneficiaire("Toto");
		v1.setDate(LocalDateTime.parse("2019-05-21 16:10:11",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		v1.setMotif("Besoin d'argent");
		Virement v2 = new Virement();
		v2.setMontant(160);
		v2.setCompte(compte3);
		v2.setBeneficiaire("Tata");
		v2.setDate(LocalDateTime.parse("2019-05-21 17:10:11",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		v2.setMotif("Besoin d'argent");
		Operation op2 = new Operation();
		op2.setCompte(compte3);
		op2.setMontant(152);
		op2.setMotif("Générosité");
		op2.setDate(LocalDateTime.parse("2019-05-21 17:13:11",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

		em.getTransaction().begin();
		em.persist(compte3);
		em.persist(v1);
		em.persist(v2);
		em.persist(op2);
		em.getTransaction().commit();
		
		
		
	}

}
