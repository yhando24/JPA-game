package main;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;



public class main {

	public static void main(String[] args) {
	EntityManager em = 	DatabaseHandle.getEntityManagerFactory();
	
		Joueur p1 = em.find(Joueur.class, 1);
		System.out.println("nom du p1: " + p1.getNom());
		
		TypedQuery<Joueur> query = em.createQuery("FROM Joueur", Joueur.class);
		System.out.println("Longueur liste : " + query.getResultList().size());
		
		for (Joueur joueur : query.getResultList()) {
			System.out.println(joueur.toString());
		}
	}

}
