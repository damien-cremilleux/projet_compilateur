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
	 * @throws FileNotFoundExceptionexception
	 *             si le fichier de sortie n'est pas defini
	 */
	@Override
	public void setFichierSortie(String f) throws FileNotFoundException {
		fichierSortie = new FileOutputStream(f + ".asm");
	}

	/**
	 * Realise l'entete d'un fichier
	 */
	@Override
	public void entete() {
		presentation("; entete");
		indent = 1;
		presentation("extrn lirent:proc,ecrent:proc");
		presentation("extrn ecrbool:proc");
		presentation("extrn ecrch:proc,ligsuiv:proc");
		indent = 0;
		presentation(".model SMALL");
		presentation(".586");
		presentation(".CODE");
		indent = 1;
	}

	/**
	 * Fonction ouvreMain
	 */
	@Override
	public void ouvreMain() {
		presentation("STARTUPCODE");
	}

	/**
	 * Methode ouvreBloc affiche ouvreBloc et la taille a reserver pour les
	 * variables locales
	 * 
	 * @param nb
	 *            le nombre de variables locales de la fonction
	 */

	@Override
	public void ouvreBloc(final int nb) {
		presentation("");
		presentation(";ouvbloc " + nb);
		presentation("enter " + nb + ",0");
	}

	/**
	 * Methode ouvreBloc affiche fermebloc et la taille des parametres
	 * 
	 * @param nb
	 *            le nombre de parametres de la fonction
	 */

	@Override
	public void fermeBloc(final int nb) {
		presentation("");
		presentation(";fermebloc " + nb);
		presentation("leave");
		presentation("ret " + nb);
	}

	/**
	 * Methode iadd
	 */
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
	public void iload(final int offset) {
		presentation("");
		presentation("; iload " + offset);
		if (offset > 0) {
			presentation("push word ptr[bp+" + offset + "]");
		} else {
			presentation("push word ptr[bp" + offset + "]");
		}
	}

	/**
	 * Methode istore
	 */
	@Override
	public void istore(final int offset) {
		presentation("");
		presentation(";istore" + offset);
		presentation("pop ax");
		presentation("mov word ptr [bp" + offset + "],ax");
	}

	/**
	 * Methode iconst
	 */
	@Override
	public void iconst(final int valeur) {
		presentation("");
		presentation("; iconst " + valeur);
		presentation("push word ptr " + valeur);
	}

	/**
	 * Methode ifeq
	 */
	@Override
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
	 *            l'etiquette de saut
	 */
	@Override
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
	 *            l'etiquette de saut
	 */
	@Override
	public void gotoYVM(final String etiquette) {
		presentation("");
		presentation("; goto " + etiquette);
		presentation("jmp " + etiquette);
	}

	/**
	 * methode pour afficher les instructions de fin
	 */
	@Override
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
	 *            l'etiquette
	 */
	@Override
	public void etiquette(final String etiquette) {
		indent = 0;
		presentation("");
		presentation(etiquette + ":");
		indent = 1;

	}

	@Override
	public void ecrireChaine(final String var) {
		String mess = "mess" + EcrireChaine.nouveauMess();
		String chaine = var.substring(0, (var.length() >= 1) ? var.length() - 1
				: 0)
				+ "$" + '"';

		presentation("");
		presentation(";ecrireChaine " + var);
		presentation(".DATA");
		presentation(mess + " DB " + chaine);
		presentation(".CODE");
		presentation("lea dx," + mess);
		presentation("push dx");
		presentation("call ecrch");
	}

	/**
	 * Ecriture d'un entier
	 */
	public void ecrireEnt() {
		presentation("");
		presentation("; ecrireEnt");
		presentation("call ecrent");
	}

	/**
	 * Ecriture d'un booleen
	 */
	public void ecrireBool() {
		presentation("");
		presentation("; ecrireBool");
		presentation("call ecrBool");
	}

	@Override
	public void aLaLigne() {
		presentation("; alaligne");
		presentation("call ligsuiv");
	}

	@Override
	public void lire(final int offset) {
		Ecriture.ecrireString(fichierSortie, "\n; ");
		super.lire(offset);
		presentation("lea dx,[bp" + offset + "]");
		presentation("push dx");
		presentation("call lirent");

	}

	/**
	 * Affiche ireturn et l'offset ou stocker le resultat
	 * 
	 * @param offset
	 *            l'offset pour stocker le resultat
	 */
	@Override
	public void ireturn(final int offset) {
		presentation("");
		presentation("; ireturn " + offset);
		presentation("pop ax");
		presentation("mov [bp+" + offset + "],ax");
	}

	/**
	 * Instruction a appeller avant l'appel a une fonction pour reserver la
	 * place pour le retour
	 */
	@Override
	public void reserveRetour() {
		presentation("");
		presentation("; reserveRetour");
		presentation("sub sp,2");
	}

	/**
	 * Instruction pour appeller une fonction avec son nom
	 * 
	 * @param nom
	 *            nom de la fonction
	 */
	@Override
	public void call(final String nom) {
		presentation("");
		presentation("; call " + nom);
		presentation("call " + nom);
	}
}