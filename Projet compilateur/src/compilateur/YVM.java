/**
 * Pojet compilateur - 2012-2013 Classe YVM Samuel Coz - Arnaud Trouche - Damien
 * Cremilleux - Lauriane Holy
 */

public class YVM {
	public OutputStream fichierSortie;

	/**
	 * Constructeur de la classe
	 */
	public YVM(flot f) {
		fichierSortie = f;
	}

	/**
	 * Methode entete
	 * affiche entete au debut du fichier YAKA 
	 */
	public void entete(){
		Ecriture.ecrireString(fichierSortie, "entete");
	}
	
	/**
	 * Methode iadd
	 */
	public void iadd() {
		Ecriture.ecrireString(fichierSortie, "iadd");
	}

	/**
	 * Methode isub
	 */
	public void isub() {
		Ecriture.ecrireString(fichierSortie, "isub");
	}

	/**
	 * Methode imul
	 */
	public void imul() {
		Ecriture.ecrireString(fichierSortie, "imul");
	}

	/**
	 * Methode idiv
	 */
	public void idiv() {
		Ecriture.ecrireString(fichierSortie, "idiv");
	}

	/**
	 * Methode inot
	 */
	public void inot() {
		Ecriture.ecrireString(fichierSortie, "iadd");
	}

	/**
	 * Methode ineg
	 */
	public void ineg() {
		Ecriture.ecrireString(fichierSortie, "ineg");
	}

	/**
	 * Methode ior
	 */
	public void ior() {
		Ecriture.ecrireString(fichierSortie, "ior");
	}

	/**
	 * Methode iand
	 */
	public void iand() {
		Ecriture.ecrireString(fichierSortie, "iand");
	}

	/**
	 * Methode iinf
	 */
	public void iinf() {
		Ecriture.ecrireString(fichierSortie, "iadd");
	}

	/**
	 * Methode isup
	 */
	public void isup() {
		Ecriture.ecrireString(fichierSortie, "isup");
	}

	/**
	 * Methode iinfegal
	 */
	public void iinfegal() {
		Ecriture.ecrireString(fichierSortie, "iinfegal");
	}

	/**
	 * Method isupegal
	 */
	public void isupegal() {
    	Ecriture.ecrireString(fichierSortie,"isupegal);
    }

	/**
	 * Methode iegal
	 */
	public void iegal() {
		Ecriture.ecrireString(fichierSortie, "iegal");
	}

	/**
	 * Methode idiff
	 */
	public void idiff() {
		Ecriture.ecrireString(fichierSortie, "idiff");
	}

	/**
	 * Methode iload 
	 * affiche iload et l'offset de la variable dans le fichier de sortie
	 *  @param offset de la variable
	 */
	public void iload(final int offset) {
		Ecriture.ecrireString(fichierSortie, "iload " + offset);
	}

	/**
	 * Methode istore
	 * affiche istore et l'offset de la variable dans le fichier de sortie
	 * @param offset de la variable
	 */
	public void istore(final int offset) {
		Ecriture.ecrireString(fichierSortie, "istore " + offset);
	}

	/**
	 * Methode iconst
	 * affiche iconst et la valeur de la constante dans le fichier de sortie
	 * @param valeur de la constante
	 */
	public void iconst(final int valeur) {
		Ecriture.ecrireString(fichierSortie, "iconst " + valeur);
	}

	/**
	 * Methode ifeq
	 * affiche ifeq et l'étiquette de saut dans le fichier de sortie
	 * @param etiquette de saut
	 */
	public void ifeq(final String etiquette) {
		Ecriture.ecrireString(fichierSortie, "ifeq " + etiquette);
	}
	
	/**
	 * Methode gotoYVM
	 * affiche goto et  l'étiquette de saut dans le fichier de sortie
	 *@param etiquette de saut
	 */
	public void gotoYVM(final String etiquette) {
		Ecriture.ecrireString(fichierSortie, "goto " + etiquette);
	}

	/**
	 * Methode ouvrePrinc
	 * affiche ouvrPrinc et l'espace resevé pour l'ensemble des variables dans la pile
	 * @param nb
	 */
	public void ouvrePrinc(final int nb) {
		Ecriture.ecrireString(fichierSortie, "ouvrePrinc " + nb);
	}
	
	/**
	 * Methode queue
	 * affiche queue à la fin du fichier YAKA 
	 */
	public void queue(){
		Ecriture.ecrireString(fichierSortie, "queue");
	}

}