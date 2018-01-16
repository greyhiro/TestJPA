package banque;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestBanqueJPA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		Client client = new Client();

		client.setNom("LEON");
		client.setPrenom("Paul");
		LocalDate date = LocalDate.of(2006, 2, 4);
		client.setDateDeNaissance(date);

		
		Adresse adresse = new Adresse();

		adresse.setCodePostal(2150);
		adresse.setNumero(31);
		adresse.setRue("rue des magnolia");
		adresse.setVille("Bordeaux");
		client.setAdresse(adresse);
		

		Banque banque = new Banque();
		banque.setNom("La poste");
		client.setBanque(banque);
		
	

		Compte compte = new Compte();
		compte.setNum("A805");
		compte.setSolde(150.58);
		
		em.persist(compte);
		em.persist(client);
		em.persist(banque);
		
		LivretA a = new LivretA();
		LocalDate dateA = LocalDate.of(2020, 2, 4);
		a.setDateFin(dateA);
		a.setTaux(0.5);
		
		em.persist(a);
		
		AssuranceVie assVie = new AssuranceVie();
		assVie.setTaux(0.5);
		
		em.persist(assVie);
		
		Virement virement = new Virement();
		virement.setBeneficiare("A805");
		
		em.persist(virement);
		
		et.commit();
		

		em.close();

	}

}
