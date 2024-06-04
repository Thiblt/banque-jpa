package entity;

import java.util.Set;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
public class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String numero;
	private double solde;
	
	@ManyToMany
	@JoinTable(name="client_compte",
	joinColumns=@JoinColumn(name="id_compte", referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="id_client", referencedColumnName="id")
	)
	private Set<Client> clients;
	
	@OneToMany(mappedBy="compte")
	private Set<Operation> operations;
	
	public Compte() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	public Set<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}
	

}
