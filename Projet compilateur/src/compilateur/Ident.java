/**
 * Project compilateur - 2012/2013
 * date : 19/02/2013
 * 
 */
package compilateur;

/**
 * Classe abstraite Ident
 * 
 * @author Samuel COZ - Damien CREMILLEUX - Lauriane HOLY - Arnaud TROUCHE
 * 
 */
public abstract class Ident {

	/**
	 * Nom de l'identificateur
	 */
	protected String nom;

	/**
	 * Le type de l'Ident est defini par un int, indique dans la classe
	 * Constante
	 */
	protected int type;

	/**
	 * Chaque Ident peut appartenir a un tabIdent
	 */
	public TabIdent tabIdent;

	/**
	 * Constructeur d'un Ident
	 * 
	 * @param type
	 *            le type de l'ident
	 * @param nom
	 *            le nom de l'ident
	 */
	public Ident(int type, String nom) {
		this.nom = nom;
		this.type = type;
	}

	/**
	 * Accesseur du type de l'Ident
	 * 
	 * @return le type de l'Ident
	 */
	protected int getType() {
		return this.type;
	}

	/**
	 * Setteur pour le type
	 * 
	 * @param type
	 *            le type de l'ident
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * Methode toString
	 */
	@Override
	public abstract String toString();

	/**
	 * Accesseur a la valeur ou a l'offset
	 * 
	 * @return la valeur ou l'offset
	 */
	public abstract int getVal();

	/**
	 * Instruction associee a l'ident
	 */
	public abstract void chargerInstr();

}