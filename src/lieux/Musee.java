package lieux;

import personnages.*;
import objets.*;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee;
	
	public void donnerTrophees(Gaulois donneur, Equipement offrande) {
		this.trophees[nbTrophee++] = new Trophee(donneur,offrande);
	}
	
	public String extraireInstructionsOCaml() {
		String texte = "let musee = [\n";
		for(int i = 0; i < this.nbTrophee; i++) {
			texte += "\t\"" + trophees[i].getGaulois().getNom() + "\", \"" + trophees[i].getEquipement().toString() + "\";\n";
		}
		texte += "]";
		return texte;
	}
	public static void main(String[] args) {
		Musee musee = new Musee();
		Gaulois asterix = new Gaulois("Astérix", 5);
		musee.trophees[0] = new Trophee(asterix, Equipement.CASQUE);
		musee.trophees[1] = new Trophee(asterix, Equipement.BOUCLIER);
		musee.nbTrophee++;
		musee.nbTrophee++;
		System.out.println(musee.extraireInstructionsOCaml());
	}
}
