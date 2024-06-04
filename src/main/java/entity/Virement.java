package entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@DiscriminatorValue("V")
public class Virement extends Operation{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String beneficiaire;
	
	public Virement() {}

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
