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
     * @param f le fichier de sortie
     * @throws FileNotFoundException 
	 */
	public void setFichierSortie(String f) throws FileNotFoundException {
		fichierSortie = new FileOutputStream(f + ".txt");
    }
	/**
	 *  Methode pour ecrire les fonctions et permettre l'identation
	 *   0 indentation si etiquette
	 *   1 sinon
	 */
	public void presentation(int ind, String s){
		if (ind == 0)
			Ecriture.ecrireStringln(fichierSortie,""+s);
		else
			Ecriture.ecrireStringln(fichierSortie," "+s);
	}

	/**
	 * Methode entete affiche entete au debut du fichier YAKA
	 */
	public void entete() {
		presentation(1,"entete");
	}

	/**
	 * Methode ouvrePrinc affiche ouvrPrinc et l'espace reserve pour l'ensemble
	 * des variables dans la pile
	 * 
     * @param nb le nombre de variables dans la pile
	 */

	public void ouvrePrinc(final int nb) {
		presentation(1,"ouvrePrinc " + nb);
	}

	/**
	 * Methode iadd
	 */
	public void iadd() {
		presentation(1,"iadd");
	}

	/**
	 * Methode isub
	 */
	public void isub() {
		presentation(1,"isub");
	}

	/**
	 * Methode imul
	 */
	public void imul() {
		presentation(1,"imul");
	}

	/**
	 * Methode idiv
	 */
	public void idiv() {
		presentation(1,"idiv");
	}

	/**
	 * Methode inot
	 */
	public void inot() {
		presentation(1,"iadd");
	}

	/**
	 * Methode ineg
	 */
	public void ineg() {
		presentation(1,"ineg");
	}

	/**
	 * Methode ior
	 */
	public void ior() {
		presentation(1,"ior");
	}

	/**
	 * Methode iand
	 */
	public void iand() {
		presentation(1,"iand");
	}

	/**
	 * Methode iinf
	 */
	public void iinf() {
		presentation(1,"iadd");
	}

	/**
	 * Methode isup
	 */
	public void isup() {
		presentation(1,"isup");
	}

	/**
	 * Methode iinfegal
	 */
	public void iinfegal() {
		presentation(1,"iinfegal");
	}

	/**
	 * Method isupegal
	 */
	public void isupegal() {
		presentation(1,"isupegal");
	}

	/**
	 * Methode iegal
	 */
	public void iegal() {
		presentation(1,"iegal");
	}

	/**
	 * Methode idiff
	 */
	public void idiff() {
		presentation(1,"idiff");
	}

	/**
	 * Methode iload affiche iload et l'offset de la variable dans le fichier de
	 * sortie
	 * 
	 * @param offset
	 *            de la variable
	 */
	public void iload(final int offset) {
		presentation(1,"iload " + offset);
	}

	/**
	 * Methode istore affiche istore et l'offset de la variable dans le fichier
	 * de sortie
	 * 
	 * @param offset
	 *            de la variable
	 */
	public void istore(final int offset) {
		presentation(1,"istore " + offset);
	}

	/**
	 * Methode iconst affiche iconst et la valeur de la constante dans le
	 * fichier de sortie
	 * 
	 * @param valeur
	 *            de la constante
	 */
	public void iconst(final int valeur) {
		presentation(1,"iconst " + valeur);
	}

	/**
	 * Methode ifeq affiche ifeq et l'étiquette de saut dans le fichier de
	 * sortie
	 * 
	 * @param etiquette
	 *            de saut
	 */
	public void ifeq(final String etiquette) {
		presentation(1,"ifeq " + etiquette);
	}

	/**
	 * Methode iffaux affiche iffaux et l'etiquette de saut
	 * 
	 * @param etiquette
	 */
	public void iffaux(final String etiquette) {
	presentation(1,"iffaux " + etiquette);
	}

	/**
	 * Methode gotoYVM affiche goto et l'étiquette de saut dans le fichier de
	 * sortie
	 * 
	 * @param etiquette
	 *            de saut
	 */
	public void gotoYVM(final String etiquette) {
		presentation(1 ,"goto " + etiquette);
	}

	/**
	 * Methode queue affiche queue à la fin du fichier YAKA
	 */
	public void queue() {
		presentation(1,"queue");
    }

    /**
     * Methode pour ecrire dans le fichier de sortie
     * 
     * @param var la variable à lire
     */
    public void ecrire(final String var) {
    	presentation(1,"ecrireChaine " + '"' + var
    			+ '"');
    }
    
    /**
     * Methode pour lire
     * @param offset l'offset de la variable à lire
     */
    public void lire(final int offset) {
    	presentation(1,"lireEnt "+offset );
	}
    
    public void etiquette(final String etiquette){
    	presentation(0,etiquette + " :");
    }
    

}