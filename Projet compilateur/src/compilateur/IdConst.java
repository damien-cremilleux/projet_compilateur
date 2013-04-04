/**
 * Projet compilateur - 2012/2013
 * date : 19/02/2013
 * 
 */
package compilateur;

/**
 * Classe IdConst, representation des identificateurs de constante
 * 
 * @author Samuel COZ - Damien CREMILLEUX - Lauriane HOLY - Arnaud TROUCHE
 */
public class IdConst extends Ident {

	/**
	 * Valeur de la constante
	 */
	private int valeur;

	/**
	 * Constructeur d'un IdConst
	 * 
	 * @param type
	 *            , le type (entier, booleen)
	 * @param nom
	 *            , le nom de la constante
	 * @param valeur
	 *            , la valeur de la constante
	 */
	public IdConst(int type, String nom, int valeur) {
		super(type, nom);
		this.valeur = valeur;
	}

	/**
	 * Accesseur de la valeur
	 * 
	 * @return la valeur de la constante
	 */
	public int getValeur() {
		return this.valeur;
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
		return " = CONSTANTE : " + t + " valeur : " + this.valeur;

	}

	/**
	 * Accesseur de la valeur
	 */
	@Override
	public int getVal() {
		return this.valeur;
	}

	/**
	 * Generation de l'instruction pour les constantes
	 */
	@Override
	public void chargerInstr() {
		Yaka.yVM.iconst(this.getValeur());

	}

}