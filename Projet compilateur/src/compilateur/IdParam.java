/**
 * Projet compilateur - 2012/2013
 * date : 22/02/2013
 * 
 */
package compilateur;

/**
 * Classe IdParam, representation des identificateurs de parametres
 * 
 * @author Samuel COZ - Damien CREMILLEUX - Lauriane HOLY - Arnaud TROUCHE
 * 
 */

public class IdParam extends Ident {
	private int offset;

	public IdParam(int type, String nom, int offset) {
		super(type, nom);
		this.offset = offset;
	}

	/**
	 * Methode toString
	 */
	@Override
	public String toString() {
		return "PARAMETRE : " + stringTypeFromConst(this.type) + " offset : "
				+ this.offset;
	}

	private String stringTypeFromConst(int cnst) {
		switch (cnst) {
		case Constante.T_BOOLEEN:
			return "BOOLEEN";
		case Constante.T_ENTIER:
			return "ENTIER";
		default:
			return "TYPE INCONNU";
		}
	}

	/**
	 * getVal : heritee de Ident, cette fonction doit renvoyer un int, or dans
	 * IdFonct, la "valeur" est un tableau donc methode inutile, renvoie 0
	 */
	@Override
	public int getVal() {
		return 0;
	}

	/**
	 * chargerInstr : heritee de Ident, cette fonction est methode inutile
	 */
	@Override
	public void chargerInstr() {
		//empty bloc
	}

	/**
	 * @return the offset
	 */
	public int getOffset() {
		return offset;
	}

	/**
	 * @param offset
	 *            the offset to set
	 */
	public void setOffset(int offset) {
		this.offset = offset;
	}

	/**
	 * @return le nom
	 */
	public String getNom() {
		return nom;
	}

}
