package personnages;

import lieux.*;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private int effetPotion = 1;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}

//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de "
//				+ romain.getNom());
//		romain.recevoirCoup((force/3)*effetPotion);
//	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] t = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; t != null && i < t.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = t[i];
		}
	}

	public void boirePotion(int forcePotion) {
		this.effetPotion += forcePotion;
		parler("Merci Druide, je sens que ma force est " + forcePotion + " fois décuplée. ");
	}
	
	public void faireUneDonnation(Musee musee) {
		if (nbTrophees > 0) {
			parler("Je donne au musee tous mes trophees :");
			while(nbTrophees > 0) {
				musee.donnerTrophees(this, this.trophees[nbTrophees-1]);
				System.out.println("- " +this.trophees[nbTrophees-1].toString());
				nbTrophees--;
			}
			
			
		}
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);

		asterix.parler("J'ai envie de frapper un romain !)");

		Romain minus = new Romain("Minus", 5);

		asterix.boirePotion(5);

		asterix.frapper(minus);
	}

}
