package testJPA;



import java.time.LocalDateTime;
import java.util.HashSet;
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
		LocalDateTime date_debut;
		@Column(name="DELAI" , length=10,nullable = false, unique = true)
		Integer delai;
		@Column(name="DATE_FIN", nullable = false, unique = true)
		LocalDateTime date_fin;
	
		
		@ManyToOne
		@JoinColumn(name="ID_CLIENT")
		private Client client;
		
		
		
		/**
		 * @return the client
		 */
		public Client getClient() {
			return client;
		}

		/**
		 * @param client the client to set
		 */
		public void setClient(Client client) {
			this.client = client;
		}

		@ManyToMany(mappedBy="emprunt")
		private Set<Livre> livre;
		
		public Emprunt(){
			
			livre =new HashSet<Livre>();
		}

		/**
		 * @return the date_debut
		 */
		public LocalDateTime getDate_debut() {
			return date_debut;
		}

		/**
		 * @param date_debut the date_debut to set
		 */
		public void setDate_debut(LocalDateTime date_debut) {
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
		public LocalDateTime getDate_fin() {
			return date_fin;
		}

		/**
		 * @param date_fin the date_fin to set
		 */
		public void setDate_fin(LocalDateTime date_fin) {
			this.date_fin = date_fin;
		}

	

		
		
	}
		
	


