package br.edu.ifba.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class GetEntityManager {
	
	private static final String JPA = "AtividadeBanco";
	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	public static EntityManager getConnectionJpa() {
		
		if(emf == null) {
			emf = Persistence.createEntityManagerFactory(JPA);
			em = emf.createEntityManager();
			
			return em;

		}else {
			return em;
		}
				
	}
	

}