/**
 * Projet compilateur - 2012/2013
 * date : 22/02/2013
 * 
 */
package compilateur;

/**
 * Classe IdVar, représentation des identificateurs de variables
 * 
 * @author Samuel COZ - Damien Crémilleux - Lauriane HOLY - Arnaud TROUCHE
 * 
 */
public class IdVar extends Ident {

    /**
     * L'offset de la variable
     */
    private int offset;

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

	    break;

	default:
	    break;
	}
	if (this.type == Constante.T_BOOLEEN) {
	    t = "BOOLEEN";
	} else

	    return "VARIABLE :" + this.nom;
    }

}