package banque;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "OPERATION")
public class Operation {

	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "DATE", nullable = false)
	private LocalDateTime date;
	@Column(name = "MONTANT", length = 10, nullable = false)
	private double montant;
	@Column(name = "MOTIF", length = 100, nullable = false)
	private String motif;

	
	@ManyToMany
	@JoinTable(name="OPERATION_COMPTE",

	joinColumns= @JoinColumn(name="ID_OPERATION", referencedColumnName="ID"),
	inverseJoinColumns= @JoinColumn(name="ID_COMPTE", referencedColumnName="ID")
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
	 * Constructeur pour JPA
	 */
	public Operation() {

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
	 * @return the date
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	/**
	 * @return the montant
	 */
	public double getMontant() {
		return montant;
	}

	/**
	 * @param montant
	 *            the montant to set
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}

	/**
	 * @return the motif
	 */
	public String getMotif() {
		return motif;
	}

	/**
	 * @param motif
	 *            the motif to set
	 */
	public void setMotif(String motif) {
		this.motif = motif;
	}

}
