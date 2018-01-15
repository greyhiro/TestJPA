package testJPA;

import java.security.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


	@Entity
	@Table(name = "EMPRUNT")
	public class Emprunt {

		@Id
		private Integer id;
		@Column(name="DATE_DEBUT", nullable = false, unique = true)
		Timestamp date_debut;
		@Column(name="DELAI" , length=10,nullable = false, unique = true)
		Integer delai;
		@Column(name="DATE_FIN", nullable = false, unique = true)
		Timestamp date_fin;
		@Column(name="ID_CLIENT" , length=10,nullable = false, unique = true)
		Integer id_client;
		
		@ManyToOne
		@JoinColumn(name="ID_EMP")
		private Client client;
		
		
		
		@ManyToMany(mappedBy="emprunt")
		private Set<Livre> livre;
		
		public Emprunt(){
			
		}

		/**
		 * @return the date_debut
		 */
		public Timestamp getDate_debut() {
			return date_debut;
		}

		/**
		 * @param date_debut the date_debut to set
		 */
		public void setDate_debut(Timestamp date_debut) {
			this.date_debut = date_debut;
		}

		/**
		 * @return the delai
		 */
		public Integer getDelai() {
			return delai;
		}

		/**
		 * @param delai the delai to set
		 */
		public void setDelai(Integer delai) {
			this.delai = delai;
		}

		/**
		 * @return the date_fin
		 */
		public Timestamp getDate_fin() {
			return date_fin;
		}

		/**
		 * @param date_fin the date_fin to set
		 */
		public void setDate_fin(Timestamp date_fin) {
			this.date_fin = date_fin;
		}

		/**
		 * @return the id_client
		 */
		public Integer getId_client() {
			return id_client;
		}

		/**
		 * @param id_client the id_client to set
		 */
		public void setId_client(Integer id_client) {
			this.id_client = id_client;
		}
		
		
	}
		
	


