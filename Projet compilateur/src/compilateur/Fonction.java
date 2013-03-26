/**
 * Projet compilateur - 2012/2013
 * date : 20/03/2013
 * 
 */
package compilateur;

import java.util.Stack;

/**
 * Classe Fonction
 * 
 * @author Samuel COZ - Damien CREMILLEUX - Lauriane HOLY - Arnaud TROUCHE
 * 
 */
public class Fonction {
	public Stack<String> pileF = new Stack<String>();
	/**
	 * Pile des parametres
	 */
	private Stack<IdParam> pilePara = new Stack<IdParam>();

	/**
	 * Dernier nom vu
	 */
	private String nom;

	/**
	 * Dernier type vu (booleen, entier, etc)
	 */
	private int type;

	/**
	 * Pointeur des locaux
	 */
	private int ptl = 0;

	/**
	 * Ancien pointeur
	 */
	private int ancptl = 0;

	/**
	 * adresse de retour
	 */
	private int adretour = 0;

	/**
	 * tableau des types des parametres
	 */
	private int tabType[];

	/**
	 * Nom de la fonction
	 */
	private String nomFonc;

	/**
	 * Type retour de la fonction
	 */
	private int typeFonc;

	/**
	 * Mise a jour du dernier nom lu
	 * 
	 * @param ident
	 *            ident lu
	 */
	public void majNom(String ident) {
		nom = ident;
	}

	/**
	 * Mise a jour du dernier type lu
	 * 
	 * @param typeF
	 *            le type lu
	 */
	public void majType(int typeF) {
		type = typeF;
	}

	/**
	 * Initialise typefonc et nomfonc
	 */
	public void initFonc() {
		typeFonc = type;
		nomFonc = nom;
	}

	/**
	 * Methode pour ajouter des parametres dans la pile On met l offset a 0 pour
	 * le gerer une fois qu'on aura tous les parametres
	 * 
	 * @param para
	 */
	public void ajouterParam() {
		IdParam idP = new IdParam(type, nom, 0);
		pilePara.push(idP);
	}

	/**
	 * Mise a jour de l'offset des parametres a la fin de la lecture de ceux ci
	 */
	public void majParam() {
		int nbParam = pilePara.size();
		int offset = 4;
		for (int i = nbParam - 1; i >= 0; i++) {
			IdParam idTmp = pilePara.get(i);
			idTmp.setOffset(offset);
			pilePara.set(i, idTmp);
			offset += 2;
		}
		
		creerTabType();
		IdFonct id = new IdFonct(typeFonc, nomFonc, tabType);
	}

	/**
	 * Creation du tableau des types des parametres
	 */
	public void creerTabType() {
		int nbParam = pilePara.size();
		for (int i = 0; i < nbParam; i++) {
			tabType[i] = pilePara.get(i).getType();
		}

	}
	
}
