package banque;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


	
	@Entity
	@Table(name="ASSURANCE_VIE")
	public class AssuranceVie {
		@Id
		@GeneratedValue
		private Integer id;
		@Column(name="TAUX", length=15, nullable=false)
		private double taux;

		
		/**
		 * JPA CONSTRUCTOR
		 */
		public AssuranceVie(){
			
		}


		/**
		 * @return the id
		 */
		public Integer getId() {
			return id;
		}


		/**
		 * @param id the id to set
		 */
		public void setId(Integer id) {
			this.id = id;
		}


		/**
		 * @return the taux
		 */
		public double getTaux() {
			return taux;
		}


		/**
		 * @param taux the taux to set
		 */
		public void setTaux(double taux) {
			this.taux = taux;
		}


	
		
}
