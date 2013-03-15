/**
 * Projet compilateur - 2012/2013
 * date : 15/03/2013
 * 
 */
package compilateur;

/**
 * Classe Conditionnelle, contient les fonctions necessaires a la gestion des
 * conditionnelle
 * 
 * @author Samuel COZ - Damien CREMILLEUX - Lauriane HOLY - Arnaud TROUCHE
 */
public class Conditionnelle {
	/**
	 * integer qui represente a quelle boucle on en est, pour les etiquettes
	 */
	public static int nbBoucles = 0;

	/**
	 * entreeCond : ecrit le mot-clef de debut SI+num de boucle
	 * 
	 */
	public void entreeCond() {
		nbBoucles++;
		Yaka.yVM.etiquette("SI" + nbBoucles);
	}

	/**
	 * conditionCond : Verifie que l'expression est bien booleenne et ecrit
	 * la condition de saut
	 */
	public void conditionCond() {
		if (Yaka.controleT.isBoolean()) {
			Yaka.yVM.iffaux("SINON" + nbBoucles);

		} else {
			Erreur.ajouterErreur("La condition de la conditionnelle n'est pas une expression booleenne");
		}

	}
	
	/**
	 * sinonCond : ecrit le saut et l'étiquette SINON
	 */
	public void sinonCond() {
		
		Yaka.yVM.gotoYVM("FSI" + nbBoucles);
		Yaka.yVM.etiquette("SINON" + nbBoucles);
		
	}

	/**
	 * sortieCond : ecrit le mot-clef de fin
	 * 
	 */
	public void sortieCond() {
		Yaka.yVM.etiquette("FSI" + nbBoucles);
		nbBoucles--;
	}

}