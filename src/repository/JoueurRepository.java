package repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import main.DatabaseHandle;
import main.Joueur;

public class JoueurRepository {

	static EntityManager em = 	DatabaseHandle.getEntityManagerFactory();
	
	public static Joueur getJoueurByname(String value) {
		
		TypedQuery<Joueur> typedQuery1 = em.createQuery("Select j from Joueur j where nom =:nom",Joueur.class);
		typedQuery1.setParameter("nom", value );

		return typedQuery1.getSingleResult();
		
	}
	
	public static List <Joueur> getAllJoueurs() {
		
		TypedQuery<Joueur> typedQuery1 = em.createQuery("Select j from Joueur j" ,Joueur.class);
	

		return typedQuery1.getResultList();
		
	}
	public static List <Joueur> getJoueursByDatePartie(LocalDate date) {

//		
//		Select j from Joueur as j JOIN Joueur_partie as jp ON jp.Joueur_id=j.id JOIN Partie as p ON jp.Partie_id=p.id where p.date =:date
		TypedQuery<Joueur> typedQuery1 = em.createQuery("Select j FROM Joueur j Join j.parties p Join p.joueurs joueurs Where p.date=:date ",Joueur.class);
	
		typedQuery1.setParameter("date", date );
		return typedQuery1.getResultList();
		
	}
//	Pour un joueur, afficher les informations de l’engin utilisé dans sa dernière partie
//	ainsi que son score et le niveau du jeu atteint ;
	public static  Joueur getJoueurLastPartieByJoueurId(int id) {

//		
//		Select j from Joueur as j JOIN Joueur_partie as jp ON jp.Joueur_id=j.id JOIN Partie as p ON jp.Partie_id=p.id where p.date =:date
		TypedQuery<Joueur> typedQuery1 = em.createQuery("Select j FROM Joueur j Join j.avatar a Join a.engins e Join j.parties p Where j.id=:id ORDER BY p.date ",Joueur.class);
		typedQuery1.setMaxResults(1);
		typedQuery1.setParameter("id", id );
		return typedQuery1.getSingleResult();
		
	}
	
}
