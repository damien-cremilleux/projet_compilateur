/**
 * Projet compilateur - 2012/2013
 * date : 15/03/2013
 * 
 */
package compilateur;

import java.util.Stack;

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
	public static Stack<Integer> nbBoucles = new Stack<Integer>();

	/**
	 * Ecrit le mot-clef de debut SI+num de boucle
	 */
	public void entreeCond() {
		Yaka.cptCond++;
		nbBoucles.push(Yaka.cptCond);
		Yaka.yVM.etiquette("SI" + nbBoucles.peek());
	}

	/**
	 * Verifie que l'expression est bien booleenne et ecrit la condition de saut
	 */
	public void conditionCond() {
		if (Yaka.controleT.isBoolean()) {
			Yaka.yVM.iffaux("SINON" + nbBoucles.peek());

		} else {
			Erreur.ajouterErreur("La condition de la conditionnelle n'est pas une expression booleenne");
		}

	}

	/**
	 * Ecrit le saut et l'etiquette SINON
	 */
	public void sinonCond() {

		Yaka.yVM.gotoYVM("FSI" + nbBoucles.peek());
		Yaka.yVM.etiquette("SINON" + nbBoucles.peek());

	}

	/**
	 * Ecrit le mot-clef de fin
	 */
	public void sortieCond() {
		Yaka.yVM.etiquette("FSI" + nbBoucles.peek());
		nbBoucles.pop();
	}

}