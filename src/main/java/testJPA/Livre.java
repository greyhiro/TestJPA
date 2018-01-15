package testJPA;

import java.util.HashSet;
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
	@JoinTable(name = "COMPO", 
	           joinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"), 
	           inverseJoinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID"))
	private Set<Emprunt> emprunt;

	/**
	 * @return the emprunt
	 */
	public Set<Emprunt> getEmprunt() {
		return emprunt;
	}

	/**
	 * @param emprunt the emprunt to set
	 */
	public void setEmprunt(Set<Emprunt> emprunt) {
		this.emprunt = emprunt;
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

	@Id
	private Integer id;
	@Column(name = "TITRE", length = 60, nullable = false, unique = true)
	private String titre;
	@Column(name = "AUTEUR", length = 60, nullable = false, unique = true)
	private String auteur;

	public Livre() {
		// TODO Auto-generated constructor stub
		emprunt = new HashSet<Emprunt>();
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
