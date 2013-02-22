/**
 * Projet compilateur - 2012/2013
 * date : 19/02/2013
 * 
 */
package compilateur;

/**
 * Classe IdConst, représentation des identificateurs de constante
 * 
 * @author Samuel COZ - Damien Crémilleux - Lauriane HOLY - Arnaud TROUCHE
 * 
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
	return "CONSTANTE : " + this.nom + ", " + t + " VALEUR : "
		+ this.valeur;

    }

}