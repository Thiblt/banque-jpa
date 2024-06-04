package test;

import java.util.Set;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TestDb {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("configBdd");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		EntityTransaction transaction= em.getTransaction();
		transaction.begin();
		
		
		
		
		transaction.commit();

	}

}
