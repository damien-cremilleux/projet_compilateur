/**
 * Projet compilateur - 2012/2013
 * date : 22/02/2013
 * 
 */
package compilateur;

/**
 * Classe IdVar, représentation des identificateurs de variables
 * 
 * @author Samuel COZ - Damien CRÉMILLEUX - Lauriane HOLY - Arnaud TROUCHE
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
     * Accesseur à l'offset
     * 
     * @return l'offset
     */
    public int getOffset() {
	return this.offset;
    }

    /**
     * Méthode toString
     */
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
	return "VARIABLE : " + this.nom + ", " + t + " offset : " + this.offset;

    }
}