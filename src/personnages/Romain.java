package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	private boolean vainqueur;

	public Romain(String nom, int force) {
		assert force >= 0;
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public int getForce() {
		return force;
	}

	public boolean isVainqueur() {
		return vainqueur;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

//	public void recevoirCoup(int forceCoup) {
//		assert this.force >= 0;
//		int forceInitiale = this.force;
//		this.force -= forceCoup;
//		if (this.force > 0) {
//			parler("Aïe");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert this.force < forceInitiale;
//	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("Aïe");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		if (force == oldForce) {
			parler("Ton coup ne m'a rien fait !");
			this.vainqueur = true;
		} else if (force >= 0) {
			parler("Aïe");
			this.vainqueur = true;
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			this.vainqueur = false;
		}

		// post condition la force a diminuée
		assert force <= oldForce;
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		if (forceCoup <= resistanceEquipement) {
			forceCoup = 0;
		} else {
			forceCoup -= resistanceEquipement;
		}
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	public void sEquiper(Equipement equipement) {
		switch (this.nbEquipement) {
		case 2:
			System.out.println("Le soldat " + this.nom + " est déjà bien protégé !");
			break;
		case 1:
			if (this.equipements[0] == equipement) {
				System.out.println("Le soldat " + this.nom + " possède déjà un " + equipement.toString() + " !");
				break;
			}
		default:
			this.equipements[this.nbEquipement++] = equipement;
			System.out.println("Le soldat " + this.nom + " s'équipe avec un " + equipement.toString() + ".");
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
