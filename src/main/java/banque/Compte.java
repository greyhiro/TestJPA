package banque;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COMPTE")
public class Compte {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "NUMERO", length = 20, nullable = false, unique = true)
	private String num;
	@Column(name = "SOLDE", length = 10, nullable = false)
	private double solde;

	/**
	 * Constructeur pour JPA
	 */
	
	
	@ManyToMany(mappedBy="compte")

	private Set<Client> client;

	
	/**
	 * JPA CONSTRUCTOR
	 */
	public Compte() {

	}

	/**
	 * @return the client
	 */
	public Set<Client> getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Set<Client> client) {
		this.client = client;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the num
	 */
	public String getNum() {
		return num;
	}

	/**
	 * @param num
	 *            the num to set
	 */
	public void setNum(String num) {
		this.num = num;
	}

	/**
	 * @return the solde
	 */
	public double getSolde() {
		return solde;
	}

	/**
	 * @param solde
	 *            the solde to set
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}

}
