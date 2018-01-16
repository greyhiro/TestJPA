package banque;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="VIREMENT")
public class Virement {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name="BENEFICIAIRE", length=6,nullable=false)
	private String beneficiare;
	
	
	/**
	 * JPA CONSTRUCTOR
	 */
	public Virement() {
		
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
	 * @return the beneficiare
	 */
	public String getBeneficiare() {
		return beneficiare;
	}


	/**
	 * @param beneficiare the beneficiare to set
	 */
	public void setBeneficiare(String beneficiare) {
		this.beneficiare = beneficiare;
	}



	
	

}
