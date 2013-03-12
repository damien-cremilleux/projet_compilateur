/**
 * Projet compilateur - 2012/2013
 * date : 19/02/2013
 * 
 */

package compilateur;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe TabIdent : representation de la table des identificateurs
 * 
 * @author Samuel COZ - Damien CREMILLEUX - Lauriane HOLY - Arnaud TROUCHE
 * 
 */
public class TabIdent {

    /**
     * La table contenant les identificateurs
     */
    private Map<String, Ident> table = new HashMap<String, Ident>();

    /**
     * Accesseur de la table des identificateurs
     * 
     * @return la hashmap contenant les identificteurs
     */
    public Map<String, Ident> getTable() {
	return this.table;
    }

    /**
     * Constructeur d'un TabIdent
     * 
     * @param taille
     */
    public TabIdent() {
	table = new HashMap<String, Ident>();
    }

    /**
     * Recherche d'un Ident dans tabIdent a l'aide d'une clef
     * 
     * @param clef
     *            , la clef de l'Ident a chercher
     * @return l'Ident associe a la clef
     */
    public Ident chercheIdent(final String clef) {
	return table.get(clef);
    }

    /**
     * Test de l'existence d'un Ident
     * 
     * @param clef
     *            , la clef de l'Ident a chercher
     * @return vrai si l'Ident existe, faux sinon
     */
    public boolean existeIdent(final String clef) {
	return table.containsKey(clef);
    }

    /**
     * Ajout d'un Ident dans tabIdent
     * 
     * @param clef
     *            , la clef de l'Ident a ajouter
     * @param id
     *            , l'Ident a ajouter
     */
    public void rangeIdent(String clef, Ident id) {
	table.put(clef, id);
    }

    /**
     * Methode toString
     */
    public String toString() {
	String affich = "";
	for (Map.Entry<String, Ident> entry : table.entrySet()) {
	    affich = "Clef : " + entry.getKey() + "; Ident :"
		    + entry.getValue() + "\n";
	}
	return affich;
    }

}