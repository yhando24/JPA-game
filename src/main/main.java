package main;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;



public class main {

	public static void main(String[] args) {
	EntityManager em = 	DatabaseHandle.getEntityManagerFactory();
	
		Joueur j1 = em.find(Joueur.class, 1);
		System.out.println("nom du p1: " + j1.getNom());
		
		TypedQuery<Joueur> query = em.createQuery("FROM Joueur", Joueur.class);
		System.out.println("Longueur liste : " + query.getResultList().size());
		
		for (Joueur joueur : query.getResultList()) {
			System.out.println(joueur.toString());
		} 
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		
		Partie p1 = new Partie();
		p1.setNiveau(20);
		p1.setScore(300);
		p1.setDatedeNaissance(LocalDate.of(1989, 11, 20));
		
		em.persist(p1);
		
		
		Partie p2 = new Partie();
		p2.setNiveau(80);
		p2.setScore(600);
		p2.setDatedeNaissance(LocalDate.of(2008, 4, 18));
		
		em.persist(p2);
		
		Partie p3 = new Partie();
		p3.setNiveau(100);
		p3.setScore(400);
		p3.setDatedeNaissance(LocalDate.of(2000, 6, 12));
		
		
		em.persist(p3);
		
		Partie p4 = new Partie();
		p4.setNiveau(12);
		p4.setScore(1500);
		p4.setDatedeNaissance(LocalDate.of(1989, 11, 26));
		
		em.persist(p4);
		
		
		transaction.commit();
		
		TypedQuery<Partie> query2 = em.createQuery("FROM Partie", Partie.class);
		System.out.println(query2.getResultList());
		
		transaction.begin();
		try {
		
			for (Partie partie : query2.getResultList()) {
				partie.setNiveau(partie.getNiveau()+1);
			}
			transaction.commit();
		} catch( Exception e) {
			System.out.println("Pas d'ajout de niveau");
			transaction.rollback();
		}
	
		
		System.out.println(query2.getResultList());
		
		
		
	}

}
