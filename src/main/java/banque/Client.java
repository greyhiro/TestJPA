package banque;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT")
public class Client {
	
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "NOM", length = 50, nullable = false)
	private String nom;
	@Column(name = "PRENOM", length = 50, nullable = false)
	private String prenom;
	@Column(name = "DATE_DE_NAISSANCE", nullable = false)
	private LocalDate dateDeNaissance;


	@ManyToOne
	@JoinColumn(name="ID_BANQUE")
	private Banque banque;


	/**
	 * @return the client
	 */

	@Embedded
	private Adresse adresse;

	/**
	 * @return the banque
	 */
	public Banque getBanque() {
		return banque;
	}

	/**
	 * @param banque the banque to set
	 */
	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	@ManyToMany
	@JoinTable(name="COMPTE_CLIENT",

	joinColumns= @JoinColumn(name="ID_COMPTE", referencedColumnName="ID"),
	inverseJoinColumns= @JoinColumn(name="ID_CLIENT", referencedColumnName="ID")
	)
	private Set<Compte> compte;

	/**
	 * @return the compte
	 */
	public Set<Compte> getCompte() {
		return compte;
	}

	/**
	 * @param compte the compte to set
	 */
	public void setCompte(Set<Compte> compte) {
		this.compte = compte;
	}

	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/**
	 * Constructeur pour JPA
	 */

	public Client() {

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

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the dateDeNaissance
	 */
	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}

	/**
	 * @param dateDeNaissance
	 *            the dateDeNaissance to set
	 */
	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}


}
