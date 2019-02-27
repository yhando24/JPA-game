package main;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import repository.JoueurRepository;



public class main {

	public static void main(String[] args) {
	EntityManager em = 	DatabaseHandle.getEntityManagerFactory();
	
		Joueur j1 = em.find(Joueur.class, 1);
		System.out.println("nom du p1: " + j1.getNom());
		
		TypedQuery<Joueur> query = em.createQuery("FROM Joueur", Joueur.class);
		System.out.println("Longueur liste : " + query.getResultList().size());
		
		
			query.getResultList().stream().forEach(e -> System.out.println(e.toString()));
		
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		Bolide b = new Bolide();
		b.setCouleur("vert");
		b.setAutonomie_heure(50);
		b.setNb_roues(4);
		b.setVitesse_max(150);
		
		Aeronef ae = new Aeronef();
		ae.setAutonomie_km(500);
		ae.setCouleur("jaune");
		ae.setType("Voiture volante");
		ae.setVitesse_max(500);
	
		
		em.persist(b);
		
		Avatar a = new Avatar();
		ae.setAvatar(a);
		a.setNom("Drius");
		a.setPuissance(1000);
		a.addEngin(b);
		a.addEngin(ae);
		b.setAvatar(a);
		a.setJoueur(j1);
		em.persist(a);
		j1.setAvatar(a);
		Partie p1 = new Partie();
		p1.setNiveau(20);
		p1.setScore(300);
		p1.setDate(LocalDate.now().plusDays(1));
		
	
		Joueur j2 = em.find(Joueur.class, 2);
		p1.addjoueur(j2);
		
		Joueur j3 = em.find(Joueur.class, 3);
		p1.addjoueur(j3);
		
		Partie p2 = new Partie();
		p2.setNiveau(80);
		p2.setScore(600);
		p2.setDate(LocalDate.of(2008, 4, 18));
		
	
		
		Partie p3 = new Partie();
		p3.setNiveau(100);
		p3.setScore(400);
		p3.setDate(LocalDate.of(2000, 6, 12));
		
		
		
		
		Partie p4 = new Partie();
		p4.setNiveau(12);
		p4.setScore(1500);
		p4.setDate(LocalDate.of(1989, 11, 26));
		

		
		p1.addjoueur(j1);
		p2.addjoueur(j1);
		p3.addjoueur(j1);
		p4.addjoueur(j1);
		
		
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.persist(p4);
		transaction.commit();
		
		TypedQuery<Partie> query2 = em.createQuery("FROM Partie", Partie.class);
		System.out.println(query2.getResultList());
		
		transaction.begin();

		try {
		
//			for (Partie partie : query2.getResultList()) {
//				partie.setNiveau(partie.getNiveau()+1);
//			}
			// la meme chose version stream
			query2.getResultList().stream().forEach(e -> e.setNiveau(e.getNiveau() + 1));
			transaction.commit();
		} catch( Exception e) {
			System.out.println("Pas d'ajout de niveau");
			transaction.rollback();
		}
		System.out.println(query2.getResultList());
		
		
		TypedQuery<Joueur> query3 = em.createQuery("FROM Joueur", Joueur.class);
	
		for (Joueur joueur : query3.getResultList()) {
			System.err.println("joueur : "+ joueur.toString() + " sa partie !!! : " + joueur.getParties().toString());
		}
		
		
		for (Partie part : query2.getResultList()) {
			System.out.println("partie : " + part.toString() +   " avec comme joueurs : " + part.getJoueurs());
		}
		
	
		System.out.println("Joueur avec le nom de DOE : " + JoueurRepository.getJoueurByname("DOE"));
		
		List <Joueur> joueurs = JoueurRepository.getAllJoueurs();
		Collections.sort(joueurs);
		System.out.println(joueurs);
		
		List <Joueur> joueursToday = JoueurRepository.getJoueursByDatePartie(LocalDate.now().plusDays(1));
		
		System.err.println(joueursToday + " CA MARCHE");
		
		Joueur joueurLastPartie = JoueurRepository.getJoueurLastPartieByJoueurId(1);
		System.out.println(joueurLastPartie + "ENGIN utilisé : " + joueurLastPartie.getAvatar().getEngins() );
		
		
		
		// changement des engins
		transaction.begin();
		try {
			joueurLastPartie.getAvatar().removeEngin(1);
			em.remove(em.find(Engin.class, 1));// suppression du bolide
			Aeronef ae1 = new Aeronef();
			ae1.setAutonomie_km(500);
			ae1.setAvatar(a);
			ae1.setCouleur("violet");
			ae1.setType("tapis volant");
			ae1.setVitesse_max(600);
			
			em.persist(ae1);
			joueurLastPartie.getAvatar().addEngin(ae1);
		
			
			transaction.commit();
		}catch (Exception e) {
			transaction.rollback();
		}
		

		Joueur joueurLastPartieApresUpdate = JoueurRepository.getJoueurLastPartieByJoueurId(1);
		System.err.println(joueurLastPartieApresUpdate + "ENGIN utilisé : " + joueurLastPartieApresUpdate.getAvatar().getEngins() );
		
		
		System.exit(0);
	}

}
