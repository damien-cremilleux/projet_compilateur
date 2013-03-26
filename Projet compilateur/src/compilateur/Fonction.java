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
	
	private int nbParam;
	
	private int nbVar;

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
		nbParam = pilePara.size();
		int offset = 4;
		for (int i = nbParam - 1; i >= 0; i++) {
			IdParam idTmp = pilePara.get(i);
			idTmp.setOffset(offset);
			pilePara.set(i, idTmp);
			offset += 2;
			Yaka.tabIdent.rangeIdentLocaux(idTmp.getNom(), idTmp);
		}
		
		creerTabType();
		IdFonct id = new IdFonct(typeFonc, nomFonc, tabType);
		Yaka.tabIdent.rangeIdentGlobaux(nomFonc, id);
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
	
	public void ouvreFonction(){
		nbVar =  Yaka.tabIdent.getSizeLocaux() - nbParam;
		Yaka.yVM.ouvreBloc(nbVar*2);
		
	}
	
	public void finFonction(){
		Yaka.yVM.fermeBloc(nbParam*2);
		Yaka.tabIdent.viderLocaux();
		Yaka.declaration.reinitialiserOffset();
		pilePara.clear();
	}
	
}
