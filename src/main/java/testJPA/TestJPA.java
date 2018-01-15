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
		Client client = (Client) query.getResultList().get(0);
		CONSOLE.info("\n" + client.getNom() + " " + client.getPrenom() + " " + client.id_client);

		/*
		 * Réaliser un find simple permettant d’extraire un livre en fonction de
		 * son id.
		 */

		Livre l = em.find(Livre.class, 6);
		if (l != null) {
			CONSOLE.info("EXISTE");
		} else {
			CONSOLE.info("PAS DE LIVRE!");
		}

		/* trouver un livre en fonction du titre */

		Query querylivre = em.createQuery("select l from Livre l ORDER BY TITRE");

		for (int i = 0; i < querylivre.getResultList().size(); i++) {
			Livre liv = (Livre) querylivre.getResultList().get(i);

			CONSOLE.info("\n\n\n" + liv.getAuteur() + " " + liv.getTitre() + "\n\n\n");

			/*
			 * Réaliser une requête qui permet d’extraire un emprunt et tous
			 * ses livres associés.
			 */

			Query queryEmp = em.createQuery("select l FROM Livre l");

			for (i = 0; i < queryEmp.getResultList().size(); i++) {

				Livre livr = (Livre) queryEmp.getResultList().get(i);

				for (Emprunt e : livr.getEmprunt()) {
					CONSOLE.info(e.getClient().getNom()+" "+e.getClient().getPrenom()+"\n a emprunter:\n  AUTEUR:"+liv.getAuteur()+" \n ID: "+liv.getId()+"\n TITRE: "+liv.getTitre());
				}

			}

		}

	}

}
