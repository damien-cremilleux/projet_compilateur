/**
 * Projet compilateur - 2012/2013
 * date : 12/03/2013
 * 
 */
package compilateur;


/**
 * Classe Iteration, contient les fonctions necessaires a la gestion des
 * iterations
 * 
 * @author Samuel COZ - Damien CREMILLEUX - Lauriane HOLY - Arnaud TROUCHE
 */
public class Iteration {
	/**
	 * integer qui représente à quelle boucle on en est, pour les etiquettes
	 */
	public static int nbBoucles = 0;

	/**
	 * entreeIteration : ecrit le mot-clé de début
	 * 
	 */
	public void entreeIteration() {
		nbBoucles++;
		Yaka.yVM.etiquette("FAIRE"+nbBoucles);
	}

	
	/**
	 * conditionIteration : Verifie que l'expression est bien booléenne et ecrit la 
	 * condition de saut
	 */
	public void conditionIteration() {
		if(Yaka.controleT.isBoolean()){
			Yaka.yVM.iffaux("FAIT"+nbBoucles);
			
		}else{
			Erreur.ajouterErreur("La condition de l'itération n'est pas une expression booléenne");
		}
		
	}

	/**
	 * sortieIteration : ecrit le mot-clé de fin
	 * 
	 */
	public void sortieIteration() {
		Yaka.yVM.gotoYVM("FAIRE"+nbBoucles);
		Yaka.yVM.etiquette("FAIT"+nbBoucles);
		nbBoucles--;
	}

	
}