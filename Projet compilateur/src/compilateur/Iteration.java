/**
 * Projet compilateur - 2012/2013
 * date : 12/03/2013
 * 
 */
package compilateur;

import java.util.Stack;

/**
 * Classe Iteration, contient les fonctions necessaires a la gestion des
 * iterations
 * 
 * @author Samuel COZ - Damien CREMILLEUX - Lauriane HOLY - Arnaud TROUCHE
 */
public class Iteration {
	/**
	 * integer qui represente a quelle boucle on en est, pour les etiquettes
	 */
	public static Stack<Integer> nbBoucles = new Stack<Integer>();

	/**
	 * entreeIteration : ecrit le mot-clef de debut
	 * 
	 */
	public void entreeIteration() {
		Yaka.cptBoucles++;
		nbBoucles.push(Yaka.cptBoucles);
		Yaka.yVM.etiquette("FAIRE" + nbBoucles.peek());
	}

	/**
	 * conditionIteration : Verifie que l'expression est bien booleenne et ecrit
	 * la condition de saut
	 */
	public void conditionIteration() {
		if (Yaka.controleT.isBoolean()) {
			Yaka.yVM.iffaux("FAIT" + nbBoucles.peek());

		} else {
			Erreur.ajouterErreur("La condition de l'iteration n'est pas une expression booleenne");
		}

	}

	/**
	 * sortieIteration : ecrit le mot-clef de fin
	 * 
	 */
	public void sortieIteration() {
		Yaka.yVM.gotoYVM("FAIRE" + nbBoucles.peek());
		Yaka.yVM.etiquette("FAIT" + nbBoucles.peek());
		nbBoucles.pop();
	}

}