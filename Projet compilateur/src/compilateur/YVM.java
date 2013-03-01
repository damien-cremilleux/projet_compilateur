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
 * Classe YVM, génération des instructions pour la Yaka Virual Machine
 * 
 * @author Samuel COZ - Damien CRÉMILLEUX - Lauriane HOLY - Arnaud TROUCHE
 * 
 */
public class YVM {
	/**
	 * fichier de sortie, contenant les instructions YVM
	 */
	public static OutputStream fichierSortie;

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
	 * Methode entete affiche entete au debut du fichier YAKA
	 */
	public void entete() {
		Ecriture.ecrireStringln(fichierSortie, "entete");
	}

	/**
	 * Methode ouvrePrinc affiche ouvrPrinc et l'espace reserve pour l'ensemble
	 * des variables dans la pile
	 * 
	 * @param nb
	 *            le nombre de variables dans la pile
	 */

	public void ouvrePrinc(final int nb) {
		Ecriture.ecrireStringln(fichierSortie, "ouvrePrinc " + nb);
	}

	/**
	 * Methode iadd
	 */
	public void iadd() {
		Ecriture.ecrireStringln(fichierSortie, "iadd");
	}

	/**
	 * Methode isub
	 */
	public void isub() {
		Ecriture.ecrireStringln(fichierSortie, "isub");
	}

	/**
	 * Methode imul
	 */
	public void imul() {
		Ecriture.ecrireStringln(fichierSortie, "imul");
	}

	/**
	 * Methode idiv
	 */
	public void idiv() {
		Ecriture.ecrireStringln(fichierSortie, "idiv");
	}

	/**
	 * Methode inot
	 */
	public void inot() {
		Ecriture.ecrireStringln(fichierSortie, "iadd");
	}

	/**
	 * Methode ineg
	 */
	public void ineg() {
		Ecriture.ecrireStringln(fichierSortie, "ineg");
	}

	/**
	 * Methode ior
	 */
	public void ior() {
		Ecriture.ecrireStringln(fichierSortie, "ior");
	}

	/**
	 * Methode iand
	 */
	public void iand() {
		Ecriture.ecrireStringln(fichierSortie, "iand");
	}

	/**
	 * Methode iinf
	 */
	public void iinf() {
		Ecriture.ecrireStringln(fichierSortie, "iadd");
	}

	/**
	 * Methode isup
	 */
	public void isup() {
		Ecriture.ecrireStringln(fichierSortie, "isup");
	}

	/**
	 * Methode iinfegal
	 */
	public void iinfegal() {
		Ecriture.ecrireStringln(fichierSortie, "iinfegal");
	}

	/**
	 * Method isupegal
	 */
	public void isupegal() {
		Ecriture.ecrireStringln(fichierSortie, "isupegal");
	}

	/**
	 * Methode iegal
	 */
	public void iegal() {
		Ecriture.ecrireStringln(fichierSortie, "iegal");
	}

	/**
	 * Methode idiff
	 */
	public void idiff() {
		Ecriture.ecrireStringln(fichierSortie, "idiff");
	}

	/**
	 * Methode iload affiche iload et l'offset de la variable dans le fichier de
	 * sortie
	 * 
	 * @param offset
	 *            de la variable
	 */
	public void iload(final int offset) {
		Ecriture.ecrireStringln(fichierSortie, "iload " + offset);
	}

	/**
	 * Methode istore affiche istore et l'offset de la variable dans le fichier
	 * de sortie
	 * 
	 * @param offset
	 *            de la variable
	 */
	public void istore(final int offset) {
		Ecriture.ecrireStringln(fichierSortie, "istore " + offset);
	}

	/**
	 * Methode iconst affiche iconst et la valeur de la constante dans le
	 * fichier de sortie
	 * 
	 * @param valeur
	 *            de la constante
	 */
	public void iconst(final int valeur) {
		Ecriture.ecrireStringln(fichierSortie, "iconst " + valeur);
	}

	/**
	 * Methode ifeq affiche ifeq et l'étiquette de saut dans le fichier de
	 * sortie
	 * 
	 * @param etiquette
	 *            de saut
	 */
	public void ifeq(final String etiquette) {
		Ecriture.ecrireStringln(fichierSortie, "ifeq " + etiquette);
	}

	/**
	 * Methode iffaux affiche iffaux et l'etiquette de saut
	 * 
	 * @param etiquette
	 */
	public void iffaux(final String etiquette) {
		Ecriture.ecrireStringln(fichierSortie, "iffaux " + etiquette);
	}

	/**
	 * Methode gotoYVM affiche goto et l'étiquette de saut dans le fichier de
	 * sortie
	 * 
	 * @param etiquette
	 *            de saut
	 */
	public void gotoYVM(final String etiquette) {
		Ecriture.ecrireStringln(fichierSortie, "goto " + etiquette);
	}

	/**
	 * Methode queue affiche queue à la fin du fichier YAKA
	 */
	public void queue() {
		Ecriture.ecrireStringln(fichierSortie, "queue");
	}

}