package entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@DiscriminatorValue("LA")
public class LivretA extends Compte{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double taux;
	
	public LivretA() {}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
