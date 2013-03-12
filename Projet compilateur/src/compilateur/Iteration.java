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
	 * integer qui repr�sente � quelle boucle on en est, pour les etiquettes
	 */
	public static int nbBoucles = 0;

	/**
	 * entreeIteration : ecrit le mot-cl� de d�but
	 * 
	 */
	public void entreeIteration() {
		nbBoucles++;
		Yaka.yVM.etiquette("FAIRE"+nbBoucles);
	}

	
	/**
	 * conditionIteration : Verifie que l'expression est bien bool�enne et ecrit la 
	 * condition de saut
	 */
	public void conditionIteration() {
		if(Yaka.controleT.isBoolean()){
			Yaka.yVM.iffaux("FAIT"+nbBoucles);
			
		}else{
			Erreur.ajouterErreur("La condition de l'it�ration n'est pas une expression bool�enne");
		}
		
	}

	/**
	 * sortieIteration : ecrit le mot-cl� de fin
	 * 
	 */
	public void sortieIteration() {
		Yaka.yVM.gotoYVM("FAIRE"+nbBoucles);
		Yaka.yVM.etiquette("FAIT"+nbBoucles);
		nbBoucles--;
	}

	
}