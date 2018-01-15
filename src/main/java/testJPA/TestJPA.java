package testJPA;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestJPA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final Logger CONSOLE = LoggerFactory.getLogger("dev.service");
		
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager em = entityManagerFactory.createEntityManager();
		  Query query = em.createQuery("select l from Client l WHERE id=1"); 
		  Client client =(Client) query.getResultList().get(0); 
		  System.out.println("\n"+client.getNom()+" "+client.getPrenom()+" "+client.id_client); 
		  
		  
		  
		  Livre l = em.find(Livre.class, 120);
		  if (l != null){
		  System.out.println("nothing");
		  }
		  else 
		  {
			  CONSOLE.info("something");
		  }
	
		 
		 /*trouver un livre en fonction du titre*/
		 
		 	Query querylivre = em.createQuery("select l from Livre l "); 
		 	
		 	

			  for (int i=0; i<4; i++)
			  {
			  Livre liv =(Livre) querylivre.getResultList().get(i); 
			  
			 
			  CONSOLE.info("\n\n\n"+liv.getAuteur()+" "+liv.getTitre()+"\n\n\n");
			  
		  }  
		 	
		 

	}

}
