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
     * Realise l'entete d'un fichier
     */
    public void entete() {
	presentation("");
	presentation(";entete");
	indent = 1;
	presentation("extrn lirent:proc,ecrent:proc");
	presentation("extrn ecrbool:proc");
	presentation("extrn ecrch:proc,ligsuiv:proc");
	indent = 0;
	presentation("debut:");
	presentation("STARTUPCODE");
	presentation(".model SMALL");
	presentation(".586");
	presentation(".CODE");
	presentation("debut:");
	presentation("STARTUPCODE");
	indent =1;
    }

    /**
     * Fonction ouvrePrinc
     * 
     * @param nb
     *            le nombre de variables
     */
    public void ouvrePrinc(final int nb) {
	presentation("");
	presentation(";ouvrePrinc " + nb);
	presentation("mov bp,sp");
	presentation("sub sp," + nb);
    }

    /**
     * Methode iadd
     */
    public void iadd() {
	presentation("");
	presentation(";iadd");
	presentation("pop bx");
	presentation("pop ax");
	presentation("add ax,bx");
	presentation("push ax");
    }

    /**
     * Methode isub
     */
    public void isub() {
	presentation("");
	presentation(";isub");
	presentation("pop bx");
	presentation("pop ax");
	presentation("sub ax,bx");
	presentation("push ax");
    }

    /**
     * Methode imul
     */
    public void imul() {
	presentation("");
	presentation(";imul");
	presentation("pop bx");
	presentation("pop ax");
	presentation("imul bx");
	presentation("push ax");
    }

    /**
     * Methode idiv
     */
    public void idiv() {
	presentation("");
	presentation(";idiv");
	presentation("pop bx");
	presentation("pop ax");
	presentation("cwd");
	presentation("idiv bx");
	presentation("push ax");
    }

    /**
     * Methode inot
     */
    public void inot() {
	presentation("");
	presentation(";inot");
	presentation("pop ax");
	presentation("not ax");
	presentation("push ax");

    }

    /**
     * Methode ineg
     */
    public void ineg() {
	presentation("");
	presentation(";ineg");
	presentation("pop ax");
	presentation("neg ax");
	presentation("push ax");

    }

    /**
     * Methode ior
     */
    public void ior() {
	presentation("");
	presentation(";ior");
	presentation("pop bx");
	presentation("pop ax");
	presentation("or ax,bx");
	presentation("push ax");
    }

    /**
     * Methode iand
     */
    public void iand() {
	presentation("");
	presentation(";iand");
	presentation("pop bx");
	presentation("pop ax");
	presentation("and ax,bx");
	presentation("push ax");
    }

    /**
     * Methode iinf
     */
    public void iinf() {
	presentation("");
	presentation(";iinf");
	presentation("pop bx");
	presentation("pop ax");
	presentation("cmp ax,bx");
	presentation("jge $+6");
	presentation("push -1");
	presentation("jmp $+4");
	presentation("push 0");
    }

    /**
     * Methode isup
     */
    public void isup() {
	presentation("");
	presentation(";isup");
	presentation("pop bx");
	presentation("pop ax");
	presentation("cmp ax,bx");
	presentation("jle $+6");
	presentation("push -1");
	presentation("jmp $+4");
	presentation("push 0");
    }

    /**
     * Methode iinfegal
     */
    public void iinfegal() {
	presentation("");
	presentation(";iinfegal");
	presentation("pop bx");
	presentation("pop ax");
	presentation("cmp ax,bx");
	presentation("jg $+6");
	presentation("push -1");
	presentation("jmp $+4");
	presentation("push 0");
    }

    /**
     * Methode isupegal
     */
    public void isupegal() {
	presentation("");
	presentation(";isupegal");
	presentation("pop bx");
	presentation("pop ax");
	presentation("cmp ax,bx");
	presentation("jl $+6");
	presentation("push -1");
	presentation("jmp $+4");
	presentation("push 0");
    }

    /**
     * Methode iegal
     */
    public void iegal() {
	presentation("");
	presentation(";iegal");
	presentation("pop bx");
	presentation("pop ax");
	presentation("cmp ax,bx");
	presentation("je $+6");
	presentation("push 0");
	presentation("jmp $+4");
	presentation("push -1");
    }

    /**
     * Methode idiff
     */
    public void idiff() {
	presentation("");
	presentation(";idiff");
	presentation("pop bx");
	presentation("pop ax");
	presentation("cmp ax,bx");
	presentation("je $+6");
	presentation("push -1");
	presentation("jmp $+4");
	presentation("push 0");
    }

    /**
     * Methode iload
     */
    public void iload(final int offset) {
	presentation("");
	presentation(";iload" + offset);
	presentation("push word ptr[bp" + offset + "]");
    }

    /**
     * Methode istore
     */
    public void istore(final int offset) {
	presentation("");
	presentation(";istore" + offset);
	presentation("pop ax");
	presentation("mov word ptr[bp" + offset + "],ax");
    }

    /**
     * Methode iconst
     */
    public void iconst(final int valeur) {
	presentation("");
	presentation(";iconst " + valeur);
	presentation("push " + valeur);
    }

    /**
     * Methode ifeq
     */
    public void ifeq(final String etiquette) {
	presentation("");
	presentation(";ifeq" + etiquette);
	presentation("pop bx");
	presentation("cmp 0, bx");
	presentation("je $+6");
	presentation("jmp " + etiquette);

    }

    /**
     * Methode iffaux affiche iffaux et l'etiquette de saut
     * 
     * @param etiquette
     */
    public void iffaux(final String etiquette) {
	presentation("");
	presentation(";iffaux " + etiquette);
	presentation("pop ax");
	presentation("cmp ax, 0");
	presentation("je " + etiquette);

    }

    /**
     * Generation des sauts
     * 
     * @param etiquette
     */
    public void gotoYVM(final String etiquette) {
	presentation("");
	presentation(";gotoYVM" + etiquette);
	presentation("jmp " + etiquette);
    }

    /**
     * methode pour afficher les instructions de fin
     */
    public void queue() {
	presentation("");
	presentation(";queue");
	presentation("nop");
	presentation("EXITCODE");
	presentation("end debut");
    }

    /**
     * Generation des etiquettes
     * 
     * @param etiquette
     */
    public void etiquette(final String etiquette) {
	presentation(etiquette + ":");

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