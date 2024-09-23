package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		assert force >= 0;
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert this.force >= 0;
		int forceInitiale = this.force;
		this.force -= forceCoup;
		if (this.force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert this.force < forceInitiale;
	}
	
	public void sEquiper(Equipement equipement) {
		switch(this.nbEquipement) {
			case 2 : 
				System.out.println("Le soldat " + this.nom + " est déjà bien protégé !");
				break;
			case 1 :
				if(this.equipements[0] == equipement) {
					System.out.println("Le soldat " + this.nom + " possède déjà un "
							+ equipement.toString() + " !");
					break;
				}
			default : 
				this.equipements[this.nbEquipement++] = equipement;
				System.out.println("Le soldat " + this.nom + " s'équipe avec un "
						+ equipement.toString() + ".");
		}		
	}
	
	public static void main(String[] args) {
		
		Romain minus = new Romain("Minus", 6);
		
		System.out.println(Equipement.BOUCLIER);
		System.out.println(Equipement.CASQUE);
		
		
		
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);

		
		minus.prendreParole();
		minus.recevoirCoup(5);
	}
}
