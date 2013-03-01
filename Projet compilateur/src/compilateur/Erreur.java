/**
 * Projet compilateur - 2012/2013
 * date : 22/02/2013
 * 
 */
package compilateur;

import java.util.ArrayList;

/**
 * Classe Constante
 * 
 * @author Samuel COZ - Damien CREMILLEUX - Lauriane HOLY - Arnaud TROUCHE
 * 
 */
public class Erreur {
	
	/**
	 * Tableau contenant les messages d'erreurs
	 */
	public static ArrayList<String> tabErreur = new ArrayList<String>();

	/**
	 * Ajout d'une erreur, et affichage de celle-ci
	 * 
	 * @param e
	 *            le message d'erreur a ajouter
	 */
	public static void ajouterErreur(String e) {
		System.out.println("ligne " + Integer.toString(Yaka.token.beginLine) + " colonne " + Integer.toString(Yaka.token.beginColumn) + " : "+e);
		tabErreur.add(e);
	}

}
