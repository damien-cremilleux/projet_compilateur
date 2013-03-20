/**
 * Projet compilateur - 2012/2013
 * date : 20/03/2013
 * 
 */

package compilateur;

/**
 * Classe IdFonct, representation des identificateurs de fonctions
 * 
 * @author Samuel COZ - Damien CREMILLEUX - Lauriane HOLY - Arnaud TROUCHE
 * 
 */
public class IdFonct extends Ident {
	private int[] tabParam;
	
	/**
	 * IdFonct : contructeur d'IdFonct
	 * @param type le type de retour
	 * @param nom le nom de la fonction
	 */
	public IdFonct(int type, String nom, int ... params) {
		super(type, nom);  /*l'attribut type représente le type du retour*/
		this.tabParam = params;
	}

	
	public String toString() {
		String t = this.nom + " = FONCTION resultat : " + stringTypeFromConst(this.type) + " les parametres :";
		for(int i =0; i < this.tabParam.length ; i++){ t+= " "+stringTypeFromConst(this.tabParam[i]);}
		return t;
	}	
	private String stringTypeFromConst(int cnst){ 
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
	 * getVal : héritée de Ident, cette fonction doit renvoyer un int, or dans IdFonct, la "valeur" est un tableau donc methode inutile, renvoie 0
	 */
	public int getVal() {
		return 0;
	}

	/**
	 * chargerInstr : héritée de Ident, cette fonction est methode inutile
	 */
	public void chargerInstr() {
		
	}

	/**
	 * getTabParam : renvoie le tableau des types des paramètres
	 */
	public int[] getTabParam() {
		return tabParam;
	}

}
