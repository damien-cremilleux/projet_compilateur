/**
 * Projet compilateur - 2012/2013
 * date : 22/02/2013
 * 
 */
package compilateur;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Classe YVM, generation des instructions assembleurs
 * 
 * @author Samuel COZ - Damien CREMILLEUX - Lauriane HOLY - Arnaud TROUCHE
 * 
 */
public class YVMasm extends YVM {
	/**
	 * Methode pour definir le fichier de sortie
	 * 
	 * @param f
	 *            le fichier de sortie
	 * @throws FileNotFoundException
	 */
	public void setFichierSortie(String f) throws FileNotFoundException {
		fichierSortie = new FileOutputStream(f + ".asm");
	}

	/**
	 * Réalise l'entete d'un fichier
	 */
	public void entete() {
		Ecriture.ecrireStringln(fichierSortie, "");
		Ecriture.ecrireStringln(fichierSortie, ";entete");
		Ecriture.ecrireStringln(fichierSortie, ".model SMALL");
		Ecriture.ecrireStringln(fichierSortie, ".586");
		Ecriture.ecrireStringln(fichierSortie, ".CODE");
		Ecriture.ecrireStringln(fichierSortie, "debut:");
		Ecriture.ecrireStringln(fichierSortie, "STARTUPCODE");
	}

	/**
	 * Fonction ouvrePrinc
	 * 
	 * @param nb
	 *            le nombre de variables
	 */
	public void ouvrePrinc(final int nb) {
		Ecriture.ecrireStringln(fichierSortie, "");
		Ecriture.ecrireStringln(fichierSortie, ";ouvrePrinc " + nb);
		Ecriture.ecrireStringln(fichierSortie, "mov bp,sp");
		Ecriture.ecrireStringln(fichierSortie, "sub sp," + nb);
	}

	/**
	 * Methode iadd
	 */
	public void iadd() {
		Ecriture.ecrireStringln(fichierSortie, "");
		Ecriture.ecrireStringln(fichierSortie, ";iadd");
		Ecriture.ecrireStringln(fichierSortie, "pop bx");
		Ecriture.ecrireStringln(fichierSortie, "pop ax");
		Ecriture.ecrireStringln(fichierSortie, "add ax,bx");
		Ecriture.ecrireStringln(fichierSortie, "push ax");
	}

	/**
	 * Methode isub
	 */
	public void isub() {
		Ecriture.ecrireStringln(fichierSortie, "");
		Ecriture.ecrireStringln(fichierSortie, ";isub");
		Ecriture.ecrireStringln(fichierSortie, "pop bx");
		Ecriture.ecrireStringln(fichierSortie, "pop ax");
		Ecriture.ecrireStringln(fichierSortie, "sub ax,bx");
		Ecriture.ecrireStringln(fichierSortie, "push ax");
	}

	/**
	 * Methode imul
	 */
	public void imul() {
		Ecriture.ecrireStringln(fichierSortie, "");
		Ecriture.ecrireStringln(fichierSortie, ";imul");
		Ecriture.ecrireStringln(fichierSortie, "pop bx");
		Ecriture.ecrireStringln(fichierSortie, "pop ax");
		Ecriture.ecrireStringln(fichierSortie, "imul bx");
		Ecriture.ecrireStringln(fichierSortie, "push ax");
	}

	/**
	 * Methode idiv
	 */
	public void idiv() {
		Ecriture.ecrireStringln(fichierSortie, "");
		Ecriture.ecrireStringln(fichierSortie, ";idiv");
		Ecriture.ecrireStringln(fichierSortie, "pop bx");
		Ecriture.ecrireStringln(fichierSortie, "pop ax");
		Ecriture.ecrireStringln(fichierSortie, "cwd");
		Ecriture.ecrireStringln(fichierSortie, "idiv bx");
		Ecriture.ecrireStringln(fichierSortie, "push ax");
	}

	/**
	 * Methode inot
	 */
	public void inot() {
		Ecriture.ecrireStringln(fichierSortie, "");
		Ecriture.ecrireStringln(fichierSortie, ";inot");
		Ecriture.ecrireStringln(fichierSortie, "pop ax");
		Ecriture.ecrireStringln(fichierSortie, "not ax");
		Ecriture.ecrireStringln(fichierSortie, "push ax");

	}

	/**
	 * Methode ineg
	 */
	public void ineg() {
		Ecriture.ecrireStringln(fichierSortie, "");
		Ecriture.ecrireStringln(fichierSortie, ";ineg");
		Ecriture.ecrireStringln(fichierSortie, "pop ax");
		Ecriture.ecrireStringln(fichierSortie, "neg ax");
		Ecriture.ecrireStringln(fichierSortie, "push ax");

	}

	/**
	 * Methode ior
	 */
	public void ior() {
		Ecriture.ecrireStringln(fichierSortie, "");
		Ecriture.ecrireStringln(fichierSortie, ";ior");
		Ecriture.ecrireStringln(fichierSortie, "pop bx");
		Ecriture.ecrireStringln(fichierSortie, "pop ax");
		Ecriture.ecrireStringln(fichierSortie, "or ax,bx");
		Ecriture.ecrireStringln(fichierSortie, "push ax");
	}

	/**
	 * Methode iand
	 */
	public void iand() {
		Ecriture.ecrireStringln(fichierSortie, "");
		Ecriture.ecrireStringln(fichierSortie, ";iand");
		Ecriture.ecrireStringln(fichierSortie, "pop bx");
		Ecriture.ecrireStringln(fichierSortie, "pop ax");
		Ecriture.ecrireStringln(fichierSortie, "and ax,bx");
		Ecriture.ecrireStringln(fichierSortie, "push ax");
	}

	/**
	 * Methode iinf
	 */
	public void iinf() {
		Ecriture.ecrireStringln(fichierSortie, "");
		Ecriture.ecrireStringln(fichierSortie, ";iinf");
		Ecriture.ecrireStringln(fichierSortie, "pop bx");
		Ecriture.ecrireStringln(fichierSortie, "pop ax");
		Ecriture.ecrireStringln(fichierSortie, "cmp ax,bx");
		Ecriture.ecrireStringln(fichierSortie, "jge $+6");
		Ecriture.ecrireStringln(fichierSortie, "push -1");
		Ecriture.ecrireStringln(fichierSortie, "jmp $+4");
		Ecriture.ecrireStringln(fichierSortie, "push 0");
	}

	/**
	 * Methode isup
	 */
	public void isup() {
		Ecriture.ecrireStringln(fichierSortie, "");
		Ecriture.ecrireStringln(fichierSortie, ";isup");
		Ecriture.ecrireStringln(fichierSortie, "pop bx");
		Ecriture.ecrireStringln(fichierSortie, "pop ax");
		Ecriture.ecrireStringln(fichierSortie, "cmp ax,bx");
		Ecriture.ecrireStringln(fichierSortie, "jle $+6");
		Ecriture.ecrireStringln(fichierSortie, "push -1");
		Ecriture.ecrireStringln(fichierSortie, "jmp $+4");
		Ecriture.ecrireStringln(fichierSortie, "push 0");
	}

	/**
	 * Methode iinfegal
	 */
	public void iinfegal() {
		Ecriture.ecrireStringln(fichierSortie, "");
		Ecriture.ecrireStringln(fichierSortie, ";iinfegal");
		Ecriture.ecrireStringln(fichierSortie, "pop bx");
		Ecriture.ecrireStringln(fichierSortie, "pop ax");
		Ecriture.ecrireStringln(fichierSortie, "cmp ax,bx");
		Ecriture.ecrireStringln(fichierSortie, "jg $+6");
		Ecriture.ecrireStringln(fichierSortie, "push -1");
		Ecriture.ecrireStringln(fichierSortie, "jmp $+4");
		Ecriture.ecrireStringln(fichierSortie, "push 0");
	}

	/**
	 * Methode isupegal
	 */
	public void isupegal() {
		Ecriture.ecrireStringln(fichierSortie, "");
		Ecriture.ecrireStringln(fichierSortie, ";isupegal");
		Ecriture.ecrireStringln(fichierSortie, "pop bx");
		Ecriture.ecrireStringln(fichierSortie, "pop ax");
		Ecriture.ecrireStringln(fichierSortie, "cmp ax,bx");
		Ecriture.ecrireStringln(fichierSortie, "jl $+6");
		Ecriture.ecrireStringln(fichierSortie, "push -1");
		Ecriture.ecrireStringln(fichierSortie, "jmp $+4");
		Ecriture.ecrireStringln(fichierSortie, "push 0");
	}

	/**
	 * Methode iegal
	 */
	public void iegal() {
		Ecriture.ecrireStringln(fichierSortie, "");
		Ecriture.ecrireStringln(fichierSortie, ";iegal");
		Ecriture.ecrireStringln(fichierSortie, "pop bx");
		Ecriture.ecrireStringln(fichierSortie, "pop ax");
		Ecriture.ecrireStringln(fichierSortie, "cmp ax,bx");
		Ecriture.ecrireStringln(fichierSortie, "je $+6");
		Ecriture.ecrireStringln(fichierSortie, "push 0");
		Ecriture.ecrireStringln(fichierSortie, "jmp $+4");
		Ecriture.ecrireStringln(fichierSortie, "push -1");
	}

	/**
	 * Methode idiff
	 */
	public void idiff() {
		Ecriture.ecrireStringln(fichierSortie, "");
		Ecriture.ecrireStringln(fichierSortie, ";idiff");
		Ecriture.ecrireStringln(fichierSortie, "pop bx");
		Ecriture.ecrireStringln(fichierSortie, "pop ax");
		Ecriture.ecrireStringln(fichierSortie, "cmp ax,bx");
		Ecriture.ecrireStringln(fichierSortie, "je $+6");
		Ecriture.ecrireStringln(fichierSortie, "push -1");
		Ecriture.ecrireStringln(fichierSortie, "jmp $+4");
		Ecriture.ecrireStringln(fichierSortie, "push 0");
	}

	/**
	 * Methode iload
	 */
	public void iload(final int offset) {
		Ecriture.ecrireStringln(fichierSortie, "");
		Ecriture.ecrireStringln(fichierSortie, ";iload" + offset);
		Ecriture.ecrireStringln(fichierSortie, "push word ptr[bp" + offset
				+ "]");
	}

	/**
	 * Methode istore
	 */
	public void istore(final int offset) {
		Ecriture.ecrireStringln(fichierSortie, "");
		Ecriture.ecrireStringln(fichierSortie, ";istore" + offset);
		Ecriture.ecrireStringln(fichierSortie, "pop ax");
		Ecriture.ecrireStringln(fichierSortie, "mov word ptr[bp" + offset
				+ "],ax");
	}

	/**
	 * Methode iconst
	 */
	public void iconst(final int valeur) {
		Ecriture.ecrireStringln(fichierSortie, "");
		Ecriture.ecrireStringln(fichierSortie, ";iconst " + valeur);
		Ecriture.ecrireStringln(fichierSortie, "push " + valeur);
	}

	/**
	 * Methode ifeq
	 */
	public void ifeq(final String etiquette) {
		Ecriture.ecrireStringln(fichierSortie, "");
		Ecriture.ecrireStringln(fichierSortie, ";ifeq" + etiquette);
		Ecriture.ecrireStringln(fichierSortie, "pop bx");
		Ecriture.ecrireStringln(fichierSortie, "cmp 0, bx");
		Ecriture.ecrireStringln(fichierSortie, "je $+6");
		Ecriture.ecrireStringln(fichierSortie, "jmp " + etiquette);

	}

	/**
	 * Methode iffaux affiche iffaux et l'etiquette de saut
	 * 
	 * @param etiquette
	 */
	public void iffaux(final String etiquette) {
		Ecriture.ecrireStringln(fichierSortie, "");
		Ecriture.ecrireStringln(fichierSortie, ";iffaux" + etiquette);
		Ecriture.ecrireStringln(fichierSortie, "pop ax");
		Ecriture.ecrireStringln(fichierSortie, "cmp ax, -1");
		Ecriture.ecrireStringln(fichierSortie, "jne $+6");
		Ecriture.ecrireStringln(fichierSortie, "jmp " + etiquette);

	}

	/**
	 * Generation des sauts
	 * 
	 * @param etiquette
	 */
	public void gotoYVM(final String etiquette) {
		Ecriture.ecrireStringln(fichierSortie, "");
		Ecriture.ecrireStringln(fichierSortie, ";gotoYVM" + etiquette);
		Ecriture.ecrireStringln(fichierSortie, "jump " + etiquette);
	}

	public void queue() {
		Ecriture.ecrireStringln(fichierSortie, "");
		Ecriture.ecrireStringln(fichierSortie, ";queue");
		Ecriture.ecrireStringln(fichierSortie, "nop");
		Ecriture.ecrireStringln(fichierSortie, "EXITCODE");
		Ecriture.ecrireStringln(fichierSortie, "end debut");
	}
}