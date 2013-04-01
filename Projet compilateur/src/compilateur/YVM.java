/**
 * Projet compilateur - 2012/2013
 * date : 26/03/2013
 * 
 */
package compilateur;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Classe YVM, generation des instructions pour la Yaka Virtual Machine
 * 
 * @author Samuel COZ - Damien CREMILLEUX - Lauriane HOLY - Arnaud TROUCHE
 * 
 */
public class YVM {
	/**
	 * fichier de sortie, contenant les instructions YVM
	 */
	public static OutputStream fichierSortie;

	/**
	 * Gestion de l'indentation (par defaut on commence avec 1)
	 */
	public static int indent = 1;

	/**
	 * Methode pour definir le fichier de sortie
	 * 
	 * @param f
	 *            le fichier de sortie
	 * @throws FileNotFoundException
	 *             exception si le fichier n'est pas trouve
	 */
	public void setFichierSortie(String f) throws FileNotFoundException {
		fichierSortie = new FileOutputStream(f + ".txt");
	}

	/**
	 * Methode pour ecrire les fonctions et permettre l'identation 0 indentation
	 * si etiquette 1 sinon
	 * 
	 * @param s
	 *            la chaine de caractere a ecrire
	 */
	public void presentation(String s) {
		String esp = "";
		for (int i = 0; i < indent; i++) {
			esp += "    ";
		}
		Ecriture.ecrireStringln(fichierSortie, esp + s);
	}

	/**
	 * Methode entete affiche entete au debut du fichier YAKA
	 */
	public void entete() {
		presentation("entete");
	}

	/**
	 * Methode ouvrePrinc affiche ouvrPrinc et l'espace reserve pour l'ensemble
	 * des variables dans la pile
	 * 
	 * @param nb
	 *            le nombre de variables dans la pile
	 */

	public void ouvrePrinc(final int nb) {
		presentation("ouvrePrinc " + nb);
	}

	/**
	 * Methode ouvreBloc affiche ouvbloc et la taille a reserver pour les
	 * variables locales
	 * 
	 * @param nb
	 *            le nombre de variables locales de la fonction
	 */

	public void ouvreBloc(final int nb) {
		presentation("ouvbloc " + nb);
	}

	/**
	 * Methode ouvreBloc affiche fermebloc et la taille des parametres
	 * 
	 * @param nb
	 *            le nombre de parametres de la fonction
	 */

	public void fermeBloc(final int nb) {
		presentation("fermebloc " + nb);
	}

	/**
	 * Methode iadd
	 */
	public void iadd() {
		presentation("iadd");
	}

	/**
	 * Methode isub
	 */
	public void isub() {
		presentation("isub");
	}

	/**
	 * Methode imul
	 */
	public void imul() {
		presentation("imul");
	}

	/**
	 * Methode idiv
	 */
	public void idiv() {
		presentation("idiv");
	}

	/**
	 * Methode inot
	 */
	public void inot() {
		presentation("iadd");
	}

	/**
	 * Methode ineg
	 */
	public void ineg() {
		presentation("ineg");
	}

	/**
	 * Methode ior
	 */
	public void ior() {
		presentation("ior");
	}

	/**
	 * Methode iand
	 */
	public void iand() {
		presentation("iand");
	}

	/**
	 * Methode iinf
	 */
	public void iinf() {
		presentation("iadd");
	}

	/**
	 * Methode isup
	 */
	public void isup() {
		presentation("isup");
	}

	/**
	 * Methode iinfegal
	 */
	public void iinfegal() {
		presentation("iinfegal");
	}

	/**
	 * Method isupegal
	 */
	public void isupegal() {
		presentation("isupegal");
	}

	/**
	 * Methode iegal
	 */
	public void iegal() {
		presentation("iegal");
	}

	/**
	 * Methode idiff
	 */
	public void idiff() {
		presentation("idiff");
	}

	/**
	 * Methode iload affiche iload et l'offset de la variable dans le fichier de
	 * sortie
	 * 
	 * @param offset
	 *            de la variable
	 */
	public void iload(final int offset) {
		presentation("iload " + offset);
	}

	/**
	 * Methode istore affiche istore et l'offset de la variable dans le fichier
	 * de sortie
	 * 
	 * @param offset
	 *            de la variable
	 */
	public void istore(final int offset) {
		presentation("istore " + offset);
	}

	/**
	 * Methode iconst affiche iconst et la valeur de la constante dans le
	 * fichier de sortie
	 * 
	 * @param valeur
	 *            de la constante
	 */
	public void iconst(final int valeur) {
		presentation("iconst " + valeur);
	}

	/**
	 * Methode ifeq affiche ifeq et l'etiquette de saut dans le fichier de
	 * sortie
	 * 
	 * @param etiquette
	 *            de saut
	 */
	public void ifeq(final String etiquette) {
		presentation("ifeq " + etiquette);
	}

	/**
	 * Methode iffaux affiche iffaux et l'etiquette de saut
	 * 
	 * @param etiquette
	 *            etiquette de saut
	 */
	public void iffaux(final String etiquette) {
		presentation("iffaux " + etiquette);
	}

	/**
	 * Methode gotoYVM affiche goto et l'etiquette de saut dans le fichier de
	 * sortie
	 * 
	 * @param etiquette
	 *            de saut
	 */
	public void gotoYVM(final String etiquette) {
		presentation("goto " + etiquette);
	}

	/**
	 * Methode queue affiche queue a la fin du fichier YAKA
	 */
	public void queue() {
		presentation("queue");
	}

	/**
	 * Methode pour ecrire dans le fichier de sortie
	 * 
	 * @param var
	 *            la variable à lire
	 */
	public void ecrireChaine(final String var) {
		presentation("ecrireChaine " + '"' + var + '"');
	}

	/**
	 * Ecriture d'une expresssion
	 */
	public void ecrireExpr() {
		presentation("ecrireEnt");
	}

	/**
	 * Methode pour lire
	 * 
	 * @param offset
	 *            l'offset de la variable a lire
	 */
	public void lire(final int offset) {
		presentation("lireEnt " + offset);
	}

	/**
	 * Ajouter une etiquette
	 * 
	 * @param etiquette
	 *            l'etiquette a ajouter
	 */
	public void etiquette(final String etiquette) {
		int tmp = indent;
		indent = 0;
		presentation(etiquette + " :");
		indent = tmp;
	}

	/**
	 * Methode aLaLigne : realiser un saut de ligne
	 */
	public void aLaLigne() {
		presentation("aLaLigne");
	}

	/**
	 * Affiche ireturn et l'offset ou stocker le resultat
	 * 
	 * @param offset
	 *            l'offset pour stocker le resultat
	 */
	public void ireturn(final int offset) {
		presentation("ireturn " + offset);
	}

	/**
	 * Instruction a appeller avant l'appel a une fonction pour reserver la
	 * place pour le retour
	 */
	public void reserveRetour() {
		presentation("reserveRetour");
	}

	/**
	 * Instruction pour appeller une fonction avec son nom
	 * 
	 * @param nom
	 *            de la fonction
	 */
	public void call(final String nom) {
		presentation("call " + nom);
	}

}