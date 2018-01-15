package testJPA;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name = "LIVRE")
public class Livre {

	
	
	@ManyToMany
	@JoinTable(name="COMPO",joinColumns= @JoinColumn(name="ID_EMP", referencedColumnName="ID"),
	inverseJoinColumns= @JoinColumn(name="ID_LIV", referencedColumnName="ID"))
	private Set<Emprunt> emprunt;

	

		@Id
		private Integer id;
		@Column(name = "TITRE", length = 60, nullable = false, unique = true)
		private String titre;
		@Column(name = "AUTEUR", length = 60, nullable = false, unique = true)
		private String auteur;

		public Livre() {
			// TODO Auto-generated constructor stub

		}

		/**
		 * @return the titre
		 */
		public String getTitre() {
			return titre;
		}

		/**
		 * @param titre
		 *            the titre to set
		 */
		public void setTitre(String titre) {
			this.titre = titre;
		}

		/**
		 * @return the auteur
		 */
		public String getAuteur() {
			return auteur;
		}

		/**
		 * @param auteur
		 *            the auteur to set
		 */
		public void setAuteur(String auteur) {
			this.auteur = auteur;
		}

	}

