/**
 * Projet compilateur - 2012/2013
 * date : 20/03/2013
 * 
 */
package compilateur;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Classe Fonction
 * 
 * @author Samuel COZ - Damien CREMILLEUX - Lauriane HOLY - Arnaud TROUCHE
 * 
 */
public class Fonction {

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
	private ArrayList<Integer> tabType = new ArrayList<Integer>();

	/**
	 * Nom de la fonction
	 */
	private String nomFonc;

	/**
	 * Type retour de la fonction
	 */
	private int typeFonc;

	/**
	 * Nombre de parametres
	 */
	private int nbParam;

	/**
	 * Nombre de variables
	 */
	private int nbVar;

	/**
	 * Fonction actuellement appelee
	 */
	private String fonctionActuelleAppel;

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
		for (int i = nbParam - 1; i >= 0; i--) {
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
			tabType.add(pilePara.get(i).getType());
		}
	}

	/**
	 * Initialise le nombre de variable et genere les instructions pour le debut
	 * d'une fonction
	 */
	public void ouvreFonction() {
		nbVar = Yaka.tabIdent.getSizeLocaux() - nbParam;
		Yaka.yVM.ouvreBloc(nbVar * 2);

	}

	/**
	 * Genere les instruction pour la fin d'une fonction
	 */
	public void finFonction() {
		Yaka.yVM.fermeBloc(nbParam * 2);
		Yaka.tabIdent.viderLocaux();
		Yaka.declaration.reinitialiserOffset();
		pilePara.clear();
		tabType.clear();
	}

	/**
	 * Reservation d'une place pour le retour de la fonction
	 */
	public void reserver() {
		Yaka.yVM.reserveRetour();
	}

	/**
	 * Verification de l'existence d'une fonction
	 * 
	 * @param ident
	 *            nom de la fonction a verifiee
	 * @return vrai si la fonction existe, faux sinon (et genere un message
	 *         d'erreur)
	 */
	public boolean existe(String ident) {
		if (!Yaka.tabIdent.existeIdentGlobaux(ident)) {
			Erreur.ajouterErreur("Fonction " + ident + " pas definie");
			fonctionActuelleAppel = ident;
			return false;
		}
		return true;
	}

	/**
	 * Genere l'appel de la fonction (en effectuant le controle de type)
	 */
	public void appelFonc() {
		IdFonct id = (IdFonct) Yaka.tabIdent
				.chercheIdentGlobaux(fonctionActuelleAppel);
		Yaka.controleT.controleFonction(id); // TODO crash a l'execution
		Yaka.yVM.call(fonctionActuelleAppel);
	}

	/**
	 * Controle le type de retour de la fonction
	 */
	public void testRetour() {
		if (Yaka.tabIdent.existeIdentGlobaux(nomFonc)) {
			IdFonct id = (IdFonct) Yaka.tabIdent.chercheIdentGlobaux(nomFonc);
			Yaka.controleT.controleRetourFonction(id);
		} else {
			Erreur.ajouterErreur("Fonction " + nomFonc + " pas definie");
		}
	}

}
