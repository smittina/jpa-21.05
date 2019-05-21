package fr.biblio.console;

import java.util.Iterator;
import java.util.List;

import fr.biblio.dao.ClientDao;
import fr.biblio.dao.EmpruntDao;
import fr.biblio.dao.LivreDao;
import fr.biblio.model.Client;
import fr.biblio.model.Emprunt;
import fr.biblio.model.Livre;

public class App {

	public static void main(String[] args) {
		
		// ---------------- TP 1 ----------------------------
		LivreDao daoLivre = new LivreDao();
		Livre leLivreById = daoLivre.findLivreById(3);
		if(leLivreById != null) {
			System.out.println("Id : "+leLivreById.getId());
			System.out.println("Titre : "+leLivreById.getTitre());
			System.out.println("Auteur : "+leLivreById.getAuteur());
		}
		else {
			System.out.println("Le Livre demandé n'existe pas");
		}
		Livre leLivreByTitre = daoLivre.findLivreByTitre("Germinal");
		if(leLivreByTitre != null) {
			System.out.println("Id : "+leLivreByTitre.getId());
			System.out.println("Titre : "+leLivreByTitre.getTitre());
			System.out.println("Auteur : "+leLivreByTitre.getAuteur());
		}
		else {
			System.out.println("Le Livre demandé n'existe pas");
		}
		
		// ------------------ TP 2 ----------------------------

		EmpruntDao daoEmprunt = new EmpruntDao();
		ClientDao daoClient = new ClientDao();
		Emprunt emprunt = daoEmprunt.findById(2);
		if(emprunt != null) {
			System.out.println("Emprunt n°: "+emprunt.getId());
			for(Livre l : emprunt.getLivres()) {
				System.out.println("Livre emprunté : "+l.getTitre());
			}
		}
		System.out.println();
		Client c = daoClient.findById(2);
		if(c != null) {
			System.out.println("Client : "+ c.getPrenom()+" "+c.getNom());
			System.out.println("Emprunts du client :");
			List<Emprunt> lesEmprunts = daoEmprunt.findByClient(c);
			for(Emprunt e : lesEmprunts) {
				System.out.println("Emprunt n° : "+ e.getId());
			}
		}
		
	}

}
