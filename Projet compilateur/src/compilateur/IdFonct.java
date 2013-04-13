/**
 * Projet compilateur - 2012/2013
 * date : 20/03/2013
 * 
 */

package compilateur;

import java.util.ArrayList;

/**
 * Classe IdFonct, representation des identificateurs de fonctions
 * 
 * @author Samuel COZ - Damien CREMILLEUX - Lauriane HOLY - Arnaud TROUCHE
 * 
 */
public class IdFonct extends Ident {

	/**
	 * Tableau contenant les parametres
	 */
	private ArrayList<Integer> tabParam;

	/**
	 * IdFonct : contructeur d'IdFonct
	 * 
	 * @param type
	 *            le type de retour
	 * @param nom
	 *            le nom de la fonction
	 * @param params
	 *            le tableau de parametres
	 */
	public IdFonct(int type, String nom, ArrayList<Integer> params) {
		super(type, nom); /* l'attribut type represente le type du retour */
		this.tabParam = new ArrayList<Integer>();
		this.tabParam.addAll(params);
	}

	/**
	 * Methode toString
	 */
	@Override
	public String toString() {
		String t = " = FONCTION resultat : " + stringTypeFromConst(this.type)
				+ " les parametres :";
		for (int i = 0; i < this.tabParam.size(); i++) {
			t += " " + stringTypeFromConst(this.tabParam.get(i));
		}
		return t;
	}

	/**
	 * Obtention de la chaine de caractere decrivant le type
	 * 
	 * @param cnst
	 *            le type de l'IdFonct
	 * @return la chaine de caractere decrivant le type de l'IdFonct
	 * 
	 */
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
		// empty bloc
	}

	/**
	 * getTabParam : renvoie le tableau des types des parametres
	 * 
	 * @return le tableau des types de parametres
	 */
	public ArrayList<Integer> getTabParam() {
		return tabParam;
	}

}