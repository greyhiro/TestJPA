package banque;

import java.time.LocalDate;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class TestBanqueJPA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		
		Client client =new Client();
		client.setNom("LEON");
		client.setPrenom("Paul");
		LocalDate date = LocalDate.of(2006, 2, 4);
		client.setDateDeNaissance(date);
		
		Client client2 = new Client();

		client2.setNom("POTO");
		client2.setPrenom("Paulin");
		LocalDate date2 = LocalDate.of(2007, 2, 4);
		client2.setDateDeNaissance(date2);
		
		
		
		Adresse adresse2 = new Adresse();

		adresse2.setCodePostal(2150);
		adresse2.setNumero(31);
		adresse2.setRue("rue des magnolia");
		adresse2.setVille("Bordeaux");
		client2.setAdresse(adresse2);

		Adresse adresse = new Adresse();

		adresse.setCodePostal(2155);
		adresse.setNumero(41);
		adresse.setRue("rue du chocolat");
		adresse.setVille("BORD");
		client.setAdresse(adresse);



		Banque banque2 = new Banque();
		banque2.setNom("La mer");
		client2.setBanque(banque2);
		
		Banque banque = new Banque();
		banque.setNom("La poste");
		client.setBanque(banque);
		
		Compte compte = new Compte();
		compte.setNum("A805");
		compte.setSolde(150.58);
	

		Compte compte2 = new Compte();
		compte2.setNum("A8e05");
		compte2.setSolde(150.58);
		
		em.persist(compte);
		em.persist(client);
		em.persist(banque);
		
		em.persist(compte2);
		em.persist(client2);
		em.persist(banque2);
		/*
		LivretA a2 = new LivretA();
		LocalDate dateA2 = LocalDate.of(2020, 2, 4);
		a2.setDateFin(dateA2);
		a2.setTaux(0.5);
		
		em.persist(a2);
		
		AssuranceVie assVie2 = new AssuranceVie();
		assVie2.setTaux(0.5);
		
		em.persist(assVie2);
		
		Virement virement2 = new Virement();
		virement2.setBeneficiare("A805");
		
		em.persist(virement2);
		
		*/
		
		et.commit();
		
		em.close();
		
		
		EntityManager emget= entityManagerFactory.createEntityManager();
		
		
		Query query = emget.createQuery("SELECT c FROM Client c");
		
		for (int i=0; i< query.getResultList().size();i++)
		{
			Client cli = (Client) query.getResultList().get(i);
			System.out.println("NOM: "+cli.getNom()+" "+cli.getPrenom()+" ID: "+cli.getId()+"Adresse" + cli.getAdresse());
		}
	
		emget.close();
		

	}

}
