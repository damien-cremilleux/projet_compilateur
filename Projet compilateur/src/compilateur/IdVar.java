/**
 * Projet compilateur - 2012/2013
 * date : 22/02/2013
 * 
 */
package compilateur;

/**
 * Classe IdVar, representation des identificateurs de variables
 * 
 * @author Samuel COZ - Damien CREMILLEUX - Lauriane HOLY - Arnaud TROUCHE
 * 
 */
public class IdVar extends Ident {

	/**
	 * L'offset de la variable
	 */
	private int offset;

	/**
	 * Constructeur d'un IdVar
	 * 
	 * @param type
	 *            , le type (entier, booleen)
	 * @param nom
	 *            le nom de la variable)
	 * @param offset
	 *            l'offset de la variable
	 */
	public IdVar(int type, String nom, int offset) {
		super(type, nom);
		this.offset = offset;
	}

	/**
	 * Accesseur de l'offset
	 * 
	 * @return l'offset
	 */
	public int getOffset() {
		return this.offset;
	}

	/**
	 * Methode toString
	 */
	@Override
	public String toString() {
		String t = new String();
		switch (this.type) {
		case Constante.T_BOOLEEN:
			t = "BOOLEEN";
			break;
		case Constante.T_ENTIER:
			t = "ENTIER";
			break;

		default:
			break;
		}
		return " = VARIABLE : " + t + " offset : " + this.offset;

	}

	@Override
	public int getVal() {
		return this.offset;
	}

	@Override
	public void chargerInstr() {
		Yaka.yVM.iload(this.getOffset());

	}
}