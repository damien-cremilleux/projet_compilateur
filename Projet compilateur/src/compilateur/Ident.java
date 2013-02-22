/**
 * Project compilateur - 2012/2013
 * date : 19/02/2013
 * 
 */
package compilateur;

/**
 * Classe abstraite Ident
 * 
 * @author Samuel COZ - Damien Crémilleux - Lauriane HOLY - Arnaud TROUCHE
 * 
 */
public abstract class Ident {

    /**
     * Nom de l'identificateur
     */
    protected String nom;

    /**
     * Le type de l'Ident est défini par un int, indiqué dans la classe
     * Constante
     */
    protected int type;

    /**
     * Chaque Ident peut appartenir à un tabIdent
     */
    public TabIdent tabIdent;

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
     */
    public void setType(int type) {
	this.type = type;
    }

    /**
     * Méthode toString
     */
    public abstract String toString();

}