package banque;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import javax.persistence.Id;

import javax.persistence.OneToMany;

@Entity
@Table(name = "BANQUE")
public class Banque {

	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "NOM", length = 50, nullable = false, unique = true)
	private String nom;


	
	@OneToMany(mappedBy="banque")
	private Set<Client> client; 
	
	/**
	 * @return the client
	 */
	public Set<Client> getClient() {
		return client;
	}

	/**
	 * @param Client the client to set
	 */
	public void setBanque(Set<Client> client) {
		this.client = client;
	}



	/**
	 * Constructeur pour JPA
	 */
	public Banque() {

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
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

}
