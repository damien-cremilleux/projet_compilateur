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

    public void presentation(int ind, String s) {
	if (ind == 0)
	    Ecriture.ecrireStringln(fichierSortie, "" + s);
	else
	    Ecriture.ecrireStringln(fichierSortie, " " + s);
    }

    /**
     * Realise l'entete d'un fichier
     */
    public void entete() {
	presentation(0, "");
	presentation(0, ";entete");
	presentation(1, "extrn lirent:proc,ecrent:proc");
	presentation(1, "extrn ecrbool:proc");
	presentation(1, "extrn ecrch:proc,ligsuiv:proc");
	presentation(0, ".model SMALL");
	presentation(0, ".586");
	presentation(0, ".CODE");
	presentation(0, "debut:");
	presentation(0, "STARTUPCODE");
    }

    /**
     * Fonction ouvrePrinc
     * 
     * @param nb
     *            le nombre de variables
     */
    public void ouvrePrinc(final int nb) {
	presentation(0, "");
	presentation(0, ";ouvrePrinc " + nb);
	presentation(0, "mov bp,sp");
	presentation(0, "sub sp," + nb);
    }

    /**
     * Methode iadd
     */
    public void iadd() {
	presentation(1, "");
	presentation(1, ";iadd");
	presentation(1, "pop bx");
	presentation(1, "pop ax");
	presentation(1, "add ax,bx");
	presentation(1, "push ax");
    }

    /**
     * Methode isub
     */
    public void isub() {
	presentation(1, "");
	presentation(1, ";isub");
	presentation(1, "pop bx");
	presentation(1, "pop ax");
	presentation(1, "sub ax,bx");
	presentation(1, "push ax");
    }

    /**
     * Methode imul
     */
    public void imul() {
	presentation(1, "");
	presentation(1, ";imul");
	presentation(1, "pop bx");
	presentation(1, "pop ax");
	presentation(1, "imul bx");
	presentation(1, "push ax");
    }

    /**
     * Methode idiv
     */
    public void idiv() {
	presentation(1, "");
	presentation(1, ";idiv");
	presentation(1, "pop bx");
	presentation(1, "pop ax");
	presentation(1, "cwd");
	presentation(1, "idiv bx");
	presentation(1, "push ax");
    }

    /**
     * Methode inot
     */
    public void inot() {
	presentation(1, "");
	presentation(1, ";inot");
	presentation(1, "pop ax");
	presentation(1, "not ax");
	presentation(1, "push ax");

    }

    /**
     * Methode ineg
     */
    public void ineg() {
	presentation(1, "");
	presentation(1, ";ineg");
	presentation(1, "pop ax");
	presentation(1, "neg ax");
	presentation(1, "push ax");

    }

    /**
     * Methode ior
     */
    public void ior() {
	presentation(1, "");
	presentation(1, ";ior");
	presentation(1, "pop bx");
	presentation(1, "pop ax");
	presentation(1, "or ax,bx");
	presentation(1, "push ax");
    }

    /**
     * Methode iand
     */
    public void iand() {
	presentation(1, "");
	presentation(1, ";iand");
	presentation(1, "pop bx");
	presentation(1, "pop ax");
	presentation(1, "and ax,bx");
	presentation(1, "push ax");
    }

    /**
     * Methode iinf
     */
    public void iinf() {
	presentation(1, "");
	presentation(1, ";iinf");
	presentation(1, "pop bx");
	presentation(1, "pop ax");
	presentation(1, "cmp ax,bx");
	presentation(1, "jge $+6");
	presentation(1, "push -1");
	presentation(1, "jmp $+4");
	presentation(1, "push 0");
    }

    /**
     * Methode isup
     */
    public void isup() {
	presentation(1, "");
	presentation(1, ";isup");
	presentation(1, "pop bx");
	presentation(1, "pop ax");
	presentation(1, "cmp ax,bx");
	presentation(1, "jle $+6");
	presentation(1, "push -1");
	presentation(1, "jmp $+4");
	presentation(1, "push 0");
    }

    /**
     * Methode iinfegal
     */
    public void iinfegal() {
	presentation(1, "");
	presentation(1, ";iinfegal");
	presentation(1, "pop bx");
	presentation(1, "pop ax");
	presentation(1, "cmp ax,bx");
	presentation(1, "jg $+6");
	presentation(1, "push -1");
	presentation(1, "jmp $+4");
	presentation(1, "push 0");
    }

    /**
     * Methode isupegal
     */
    public void isupegal() {
	presentation(1, "");
	presentation(1, ";isupegal");
	presentation(1, "pop bx");
	presentation(1, "pop ax");
	presentation(1, "cmp ax,bx");
	presentation(1, "jl $+6");
	presentation(1, "push -1");
	presentation(1, "jmp $+4");
	presentation(1, "push 0");
    }

    /**
     * Methode iegal
     */
    public void iegal() {
	presentation(1, "");
	presentation(1, ";iegal");
	presentation(1, "pop bx");
	presentation(1, "pop ax");
	presentation(1, "cmp ax,bx");
	presentation(1, "je $+6");
	presentation(1, "push 0");
	presentation(1, "jmp $+4");
	presentation(1, "push -1");
    }

    /**
     * Methode idiff
     */
    public void idiff() {
	presentation(1, "");
	presentation(1, ";idiff");
	presentation(1, "pop bx");
	presentation(1, "pop ax");
	presentation(1, "cmp ax,bx");
	presentation(1, "je $+6");
	presentation(1, "push -1");
	presentation(1, "jmp $+4");
	presentation(1, "push 0");
    }

    /**
     * Methode iload
     */
    public void iload(final int offset) {
	presentation(1, "");
	presentation(1, ";iload" + offset);
	presentation(1, "push word ptr[bp" + offset + "]");
    }

    /**
     * Methode istore
     */
    public void istore(final int offset) {
	presentation(1, "");
	presentation(1, ";istore" + offset);
	presentation(1, "pop ax");
	presentation(1, "mov word ptr[bp" + offset + "],ax");
    }

    /**
     * Methode iconst
     */
    public void iconst(final int valeur) {
	presentation(1, "");
	presentation(1, ";iconst " + valeur);
	presentation(1, "push " + valeur);
    }

    /**
     * Methode ifeq
     */
    public void ifeq(final String etiquette) {
	presentation(1, "");
	presentation(1, ";ifeq" + etiquette);
	presentation(1, "pop bx");
	presentation(1, "cmp 0, bx");
	presentation(1, "je $+6");
	presentation(1, "jmp " + etiquette);

    }

    /**
     * Methode iffaux affiche iffaux et l'etiquette de saut
     * 
     * @param etiquette
     */
    public void iffaux(final String etiquette) {
	presentation(1, "");
	presentation(1, ";iffaux " + etiquette);
	presentation(1, "pop ax");
	presentation(1, "cmp ax, 0");
	presentation(1, "je " + etiquette);

    }

    /**
     * Generation des sauts
     * 
     * @param etiquette
     */
    public void gotoYVM(final String etiquette) {
	presentation(1, "");
	presentation(1, ";gotoYVM" + etiquette);
	presentation(1, "jmp " + etiquette);
    }

    /**
     * methode pour afficher les instructions de fin
     */
    public void queue() {
	presentation(0, "");
	presentation(0, ";queue");
	presentation(0, "nop");
	presentation(0, "EXITCODE");
	presentation(0, "end debut");
    }

    /**
     * Generation des etiquettes
     * 
     * @param etiquette
     */
    public void etiquette(final String etiquette) {
	presentation(0, etiquette + ":");

    }

    public void ecrireChaine(final String var) {
	String mess = "mess" + EcrireChaine.nouveauMess();
	String chaine = var.substring(0, (var.length() >= 1) ? var.length() - 1
		: 0)
		+ "$" + '"';

	Ecriture.ecrireStringln(fichierSortie, "");
	Ecriture.ecrireStringln(fichierSortie, ";ecrireChaine " + var);
	Ecriture.ecrireStringln(fichierSortie, ".DATA");
	Ecriture.ecrireStringln(fichierSortie, mess + " DB " + chaine);
	Ecriture.ecrireStringln(fichierSortie, ".CODE");
	Ecriture.ecrireStringln(fichierSortie, "lea dx," + mess);
	Ecriture.ecrireStringln(fichierSortie, "push dx");
	Ecriture.ecrireStringln(fichierSortie, "call ecrch");
    }

    /**
     * Ecriture d'une expresssion
     */
    public void ecrireExpr() {
	Ecriture.ecrireStringln(fichierSortie, "");
	Ecriture.ecrireStringln(fichierSortie, ";ecrireEnt");
	Ecriture.ecrireStringln(fichierSortie, "call ecrent");

    }

    public void aLaLigne() {
	Ecriture.ecrireString(fichierSortie, "\n; ");
	super.aLaLigne();
	Ecriture.ecrireStringln(fichierSortie, "call ligsuiv");
    }

    public void lire(final int offset) {
	Ecriture.ecrireString(fichierSortie, "\n; ");
	super.lire(offset);
	Ecriture.ecrireStringln(fichierSortie, "lea dx,[bp" + offset + "]");
	Ecriture.ecrireStringln(fichierSortie, "push dx");
	Ecriture.ecrireStringln(fichierSortie, "call lirent");

    }
}