package lieux;

import java.util.Iterator;

import personnages.*;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		this.villageois[nbVillageois++] = gaulois;
	}
	
	public Gaulois trouverHabitant(int reference) {
		return this.villageois[reference];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans " + this.nom + " du chef "
				+ this.chef.getNom() + " vivent les l�gendaires gaulois :");
		for(int i = 0; i < this.nbVillageois; i++) {
			System.out.println("- " + this.villageois[i].getNom());
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irr�ductibles", 30);
//		Gaulois gaulois = village.trouverHabitant(30);
//		le tableau accepte des r�f�rence de 0 � 29
		Chef abraracourcix = new Chef("Abraracourcix", 5, village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Ast�rix", 8);
		village.ajouterHabitant(asterix);
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		Affichage : null car asterix est en position 0
		Gaulois obelix = new Gaulois("Ob�lix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
	}
}
