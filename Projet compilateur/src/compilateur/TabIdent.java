/**
 * Projet compilateur - 2012/2013
 * date : 20/03/2013
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
	 * La table contenant les identificateurs globaux
	 */    
	private Map<String, Ident> globaux = new HashMap<String, Ident>();

	/**
	 * La table contenant les identificateurs locaux
	 */    
	private Map<String, Ident> locaux = new HashMap<String, Ident>();

	/**
	 * Accesseur de la table des identificateurs locaux
	 * 
	 * @return la hashmap contenant les identificteurs locaux
	 */
	public Map<String, Ident> getGlobaux() {
		return this.globaux;
	}
	
	/**
	 * Accesseur de la table des identificateurs globaux
	 * 
	 * @return la hashmap contenant les identificteurs globaux
	 */
	public Map<String, Ident> getLocaux() {
		return this.locaux;
	}

	/**
	 * Constructeur de TabIdent
	 * 
	 * @param taille
	 */
	public TabIdent() {
		globaux = new HashMap<String, Ident>();
		locaux = new HashMap<String, Ident>();
	}
	

	/**
	 * Recherche d'un Ident dans Locaux a l'aide d'une clef
	 * 
	 * @param clef
	 *            , la clef de l'Ident a chercher
	 * @return l'Ident associe a la clef
	 */
	public Ident chercheIdentLocaux(final String clef) {
		return locaux.get(clef);
	}
	/**
	 * Recherche d'un Ident dans Locaux a l'aide d'une clef
	 * 
	 * @param clef
	 *            , la clef de l'Ident a chercher
	 * @return l'Ident associe a la clef
	 */
	public Ident chercheIdentGlobaux(final String clef) {
		return globaux.get(clef);
	}
	

	/**
	 * Test de l'existence d'un Ident
	 * 
	 * @param clef
	 *            , la clef de l'Ident a chercher
	 * @return vrai si l'Ident existe, faux sinon
	 */
	public boolean existeIdentLocaux(final String clef) {
		return globaux.containsKey(clef);
	}
	/**
	 * Test de l'existence d'un Ident
	 * 
	 * @param clef
	 *            , la clef de l'Ident a chercher
	 * @return vrai si l'Ident existe, faux sinon
	 */
	public boolean existeIdentGlobaux(final String clef) {
		return globaux.containsKey(clef);
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
		globaux.put(clef, id);
	}

	/**
	 * Methode toString
	 */
	public String toString() {
		String affich = "";
		for (Map.Entry<String, Ident> entry : globaux.entrySet()) {
			affich = "Clef : " + entry.getKey() + "; Ident :"
					+ entry.getValue() + "\n";
		}
		return affich;
	}

}
