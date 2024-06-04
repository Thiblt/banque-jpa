package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import entity.Client;
import entity.Compte;
import entity.Operation;
import entity.Virement;
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
		Compte c=new Compte();
		c.setSolde(0);
		c.setNumero("yegzuzgfi");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Client cl1= new Client();
		cl1.setNom("Dupont");
		cl1.setPrenom("Jean");
		cl1.setDatenaissance(LocalDate.now());
		em.persist(cl1);
		Client cl2= new Client();
		cl2.setNom("Dupont");
		cl2.setPrenom("Jean");
		cl2.setDatenaissance(LocalDate.parse("12/08/1996", formatter));
		em.persist(cl2);
		 Set<Client> clients= new HashSet();
		 clients.add(cl1);
		 clients.add(cl2);
		c.setClients(clients);
		Operation o= new Operation();
		o.setMontant(10);
		o.setMotif("Comme ça");
		o.setDate(LocalDateTime.now());
		em.persist(o);
		Virement v= new Virement();
		v.setMontant(100);
		v.setMotif("payement");
		v.setDate(LocalDateTime.now());
		v.setBeneficiaire("Moi");
		em.persist(v);
		v.setCompte(c);
		o.setCompte(c);
		 Set<Operation> ops= new HashSet();
		 ops.add(o);
		 ops.add(v);
		 c.setOperations(ops);
		 
		 
		em.persist(c);
		
		
		
		transaction.commit();

	}

}
