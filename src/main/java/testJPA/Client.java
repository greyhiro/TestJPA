package testJPA;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT")
public class Client {

	@Id
	private Integer id;
	@Column(name="NOM", length=50,nullable = false)
	private String nom;
	@Column(name="PRENOM", length=50,nullable = false)
	private String prenom;
	
	
	@OneToMany(mappedBy="client")
	private Set<Emprunt> emprunt;
	
	
	
	public Client(){
		emprunt= new HashSet<Emprunt>();
	}


	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}


	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}


	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}


	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
}
