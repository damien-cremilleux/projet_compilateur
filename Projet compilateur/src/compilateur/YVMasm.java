/**
 * Projet compilateur - 2012/2013
 * date : 22/02/2013
 * 
 */
package compilateur;

import java.io.OutputStream;

/**
 * Classe YVM, génération des instructions assembleurs
 * 
 * @author Samuel COZ - Damien CRÉMILLEUX - Lauriane HOLY - Arnaud TROUCHE
 * 
 */
public class YVMasm extends YVM {
    /**
     * Constructeur
     * 
     * @param f
     *            le fichier de sortie, contenant les instructions assembleurs
     */
    public YVMasm(OutputStream f) {
	super(f);
	// TODO Auto-generated constructor stub
    }

    /**
     * Le fichier de sortie contenant les instructions assembleurs
     */
    public OutputStream fichierSortie; // TODO à voir avec l'héritage

    /**
     * Réalise l'entete d'un fichier
     */
    public void entete() {
	Ecriture.ecrireStringln(fichierSortie, ".model SMALL");
	Ecriture.ecrireStringln(fichierSortie, ".586");
	Ecriture.ecrireStringln(fichierSortie, ".CODE");
	Ecriture.ecrireStringln(fichierSortie, "debut:");
	Ecriture.ecrireStringln(fichierSortie, "STARTUPCODE");
    }

    /**
     * Fonction ouvPrinc
     * 
     * @param nb
     *            le nombre de variables
     */
    public void ouvePrinc(final int nb) {
	Ecriture.ecrireStringln(fichierSortie, "move bp,sp");
	Ecriture.ecrireStringln(fichierSortie, "sub sp," + nb);
    }

    public void iadd() {
	Ecriture.ecrireStringln(fichierSortie, "pop bx");
	Ecriture.ecrireStringln(fichierSortie, "pop ax");
	Ecriture.ecrireStringln(fichierSortie, "add ax,bx");
	Ecriture.ecrireStringln(fichierSortie, "push ax");
    }

    public void isub() {
	Ecriture.ecrireStringln(fichierSortie, "pop bx");
	Ecriture.ecrireStringln(fichierSortie, "pop ax");
	Ecriture.ecrireStringln(fichierSortie, "sub ax,bx");
	Ecriture.ecrireStringln(fichierSortie, "push ax");
    }

    public void imul() {
	Ecriture.ecrireStringln(fichierSortie, "pop bx");
	Ecriture.ecrireStringln(fichierSortie, "pop ax");
	Ecriture.ecrireStringln(fichierSortie, "imul bx");
	Ecriture.ecrireStringln(fichierSortie, "push ax");
    }

    public void idiv() {
	Ecriture.ecrireStringln(fichierSortie, "pop bx");
	Ecriture.ecrireStringln(fichierSortie, "pop ax");
	Ecriture.ecrireStringln(fichierSortie, "cwd");
	Ecriture.ecrireStringln(fichierSortie, "idiv ax,bx");
	Ecriture.ecrireStringln(fichierSortie, "push ax");
    }

    // avec ax ?
    public void inot() {
	Ecriture.ecrireStringln(fichierSortie, "pop ax");
	Ecriture.ecrireStringln(fichierSortie, "not ax");
	Ecriture.ecrireStringln(fichierSortie, "push ax");

    }

    // avec ax ?
    public void ineg() {
	Ecriture.ecrireStringln(fichierSortie, "neg ax");
	Ecriture.ecrireStringln(fichierSortie, "push ax");

    }

    public void ior() {
	Ecriture.ecrireStringln(fichierSortie, "pop bx");
	Ecriture.ecrireStringln(fichierSortie, "pop ax");
	Ecriture.ecrireStringln(fichierSortie, "or ax,bx");
	Ecriture.ecrireStringln(fichierSortie, "push ax");
    }

    public void iand() {
	Ecriture.ecrireStringln(fichierSortie, "pop bx");
	Ecriture.ecrireStringln(fichierSortie, "pop ax");
	Ecriture.ecrireStringln(fichierSortie, "and ax,bx");
	Ecriture.ecrireStringln(fichierSortie, "push ax");
    }

    public void iinf() {
	Ecriture.ecrireStringln(fichierSortie, "pop bx");
	Ecriture.ecrireStringln(fichierSortie, "pop ax");
	Ecriture.ecrireStringln(fichierSortie, "cmp ax,bx");
	Ecriture.ecrireStringln(fichierSortie, "jge $+6");
	Ecriture.ecrireStringln(fichierSortie, "push -1");
	Ecriture.ecrireStringln(fichierSortie, "jmp $+4");
	Ecriture.ecrireStringln(fichierSortie, "push 0");
    }

    public void isup() {
	Ecriture.ecrireStringln(fichierSortie, "pop bx");
	Ecriture.ecrireStringln(fichierSortie, "pop ax");
	Ecriture.ecrireStringln(fichierSortie, "cmp ax,bx");
	Ecriture.ecrireStringln(fichierSortie, "jle $+6");
	Ecriture.ecrireStringln(fichierSortie, "push -1");
	Ecriture.ecrireStringln(fichierSortie, "jmp $+4");
	Ecriture.ecrireStringln(fichierSortie, "push 0");
    }

    public void iinfegal() {
	Ecriture.ecrireStringln(fichierSortie, "pop bx");
	Ecriture.ecrireStringln(fichierSortie, "pop ax");
	Ecriture.ecrireStringln(fichierSortie, "cmp ax,bx");
	Ecriture.ecrireStringln(fichierSortie, "jg $+6");
	Ecriture.ecrireStringln(fichierSortie, "push -1");
	Ecriture.ecrireStringln(fichierSortie, "jmp $+4");
	Ecriture.ecrireStringln(fichierSortie, "push 0");
    }

    public void isupegal() {
	Ecriture.ecrireStringln(fichierSortie, "pop bx");
	Ecriture.ecrireStringln(fichierSortie, "pop ax");
	Ecriture.ecrireStringln(fichierSortie, "cmp ax,bx");
	Ecriture.ecrireStringln(fichierSortie, "jl $+6");
	Ecriture.ecrireStringln(fichierSortie, "push -1");
	Ecriture.ecrireStringln(fichierSortie, "jmp $+4");
	Ecriture.ecrireStringln(fichierSortie, "push 0");
    }

    public void iegal() {
	Ecriture.ecrireStringln(fichierSortie, "pop bx");
	Ecriture.ecrireStringln(fichierSortie, "pop ax");
	Ecriture.ecrireStringln(fichierSortie, "cmp ax,bx");
	Ecriture.ecrireStringln(fichierSortie, "jne $+6");
	Ecriture.ecrireStringln(fichierSortie, "push -1");
	Ecriture.ecrireStringln(fichierSortie, "jmp $+4");
	Ecriture.ecrireStringln(fichierSortie, "push 0");
    }

    public void idiff() {
	Ecriture.ecrireStringln(fichierSortie, "pop bx");
	Ecriture.ecrireStringln(fichierSortie, "pop ax");
	Ecriture.ecrireStringln(fichierSortie, "cmp ax,bx");
	Ecriture.ecrireStringln(fichierSortie, "je $+6");
	Ecriture.ecrireStringln(fichierSortie, "push -1");
	Ecriture.ecrireStringln(fichierSortie, "jmp $+4");
	Ecriture.ecrireStringln(fichierSortie, "push 0");
    }

    public void iload(final int offset) {
	Ecriture.ecrireStringln(fichierSortie, "push word ptr[bp" + offset
		+ "]");
    }

    public void istore(final int offset) {
	Ecriture.ecrireStringln(fichierSortie, "pop ax");
	Ecriture.ecrireStringln(fichierSortie, "move word ptr[bp" + offset
		+ ",ax");
    }

    public void iconst(final int valeur) {
	Ecriture.ecrireStringln(fichierSortie, "push " + valeur);
    }

    // public void ifeq(final String etiquette) {

    /**
     * Generation des sauts
     * @param etiquette
     */
    public void gotoYVMasm(final String etiquette) {
	Ecriture.ecrireStringln(fichierSortie, "jump " + etiquette);
    }

    public void queue() {
	Ecriture.ecrireStringln(fichierSortie, "nop");
	Ecriture.ecrireStringln(fichierSortie, "EXIT CODE");
	Ecriture.ecrireStringln(fichierSortie, "end debut");
    }
}