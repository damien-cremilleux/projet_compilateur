/**
 * Projet compilateur - 2012/2013
 * date : 22/02/2013
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

	public static int indent;

	/**
	 * Methode pour definir le fichier de sortie
	 * 
	 * @param f
	 *            le fichier de sortie
	 * @throws FileNotFoundException
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
	for(int i = 0; i<indent; i++) {
		esp +=" ";
	}
	Ecriture.ecrireStringln(fichierSortie, esp + s);
    }

	/**
	 * Methode entete affiche entete au debut du fichier YAKA
	 */
	public void entete() {
		indent = 0;
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
	 * Methode ifeq affiche ifeq et l'étiquette de saut dans le fichier de
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
	 */
	public void iffaux(final String etiquette) {
		presentation("iffaux " + etiquette);
	}

	/**
	 * Methode gotoYVM affiche goto et l'étiquette de saut dans le fichier de
	 * sortie
	 * 
	 * @param etiquette
	 *            de saut
	 */
	public void gotoYVM(final String etiquette) {
		presentation("goto " + etiquette);
	}

	/**
	 * Methode queue affiche queue à la fin du fichier YAKA
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
		Ecriture.ecrireStringln(fichierSortie, "ecrireEnt");

	}

	/**
	 * Methode pour lire
	 * 
	 * @param offset
	 *            l'offset de la variable à lire
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
		presentation(etiquette + " :");
	}

	/**
	 * Methode aLaLigne : realiser un saut de ligne
	 */
	public void aLaLigne() {
		Ecriture.ecrireStringln(fichierSortie, "aLaLigne");

	}

}