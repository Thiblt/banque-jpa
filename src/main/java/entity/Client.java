package entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private LocalDate datenaissance;
	
	@ManyToOne
	@JoinColumn(name="banque_id")
	private Banque banque;
	
	@ManyToMany
	@JoinTable(name="client_compte",
	joinColumns=@JoinColumn(name="id_client", referencedColumnName="id"),
	inverseJoinColumns
	=@JoinColumn(name="id_compte", referencedColumnName="id")
	)
	private Set<Compte> comptes;
	
	@Embedded
	private Adresse adresse;
	
	public Client() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDatenaissance() {
		return datenaissance;
	}

	public void setDatenaissance(LocalDate datenaissance) {
		this.datenaissance = datenaissance;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	public Set<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	

}
