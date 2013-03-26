/**
 * Projet compilateur - 2012/2013
 * date : 22/02/2013
 * 
 */
package compilateur;

/**
 * Classe Declaration, contenant les fonctions necessaires a la gestion des
 * declarations
 * 
 * @author Samuel COZ - Damien CREMILLEUX - Lauriane HOLY - Arnaud TROUCHE
 * 
 */
public class Declaration {
	/**
	 * Le nom de l'Ident courant
	 */
	public String nomIdent;

	/**
	 * Le type de la variable (exemple : entier, booleen, etc)
	 */
	private int typeVar;

	/**
	 * L'offset en cours, utilise par les variables. Il commence a 0
	 */
	private int offsetCourant = 0;

	/**
	 * Methode pour modifier le nom de l'Ident courant
	 * 
	 * @param name
	 *            , le nouveau nom
	 */
	public void setNomIdent(String name) {
		nomIdent = name;
	}

	/**
	 * Methode pour affecter une constante
	 * 
	 * @param val
	 *            la valeur de la constante
	 * @param type
	 *            le type de la constante
	 */
	public void affectationConst(final int val, final int type) {
		if (existe()) {
			Erreur.ajouterErreur("Constante " + nomIdent + " deja definie");
		} else {
			/* Cree l'ident */
			IdConst id = new IdConst(type, nomIdent, val);
			Yaka.tabIdent.rangeIdentLocaux(nomIdent, id);
		}
	}

	/**
	 * Methode pour affecter une constante
	 * 
	 * @param clefACopier
	 *            , le nom de la constante
	 */
	public void affectationConstCopie(final String clefACopier) {
		if (Yaka.tabIdent.existeIdentLocaux(clefACopier)) {
			IdConst id = (IdConst) Yaka.tabIdent.chercheIdentLocaux(clefACopier);
			this.affectationConst(id.getValeur(), id.getType());
		} else {
			Erreur.ajouterErreur("Constante " + clefACopier + " pas definie");
		}
	}

	/**
	 * Modifier le type de l'Ident courant
	 * 
	 * @param type
	 *            le nouveau type
	 */
	public void setTypeVar(final int type) {
		typeVar = type;
	}

	/**
	 * Methode pour affecter une variable
	 * 
	 * @param clef
	 *            le nom de la variable
	 */
	public void affectationVal(final String clef) {
		if (Yaka.tabIdent.existeIdentLocaux(clef)) {
			Erreur.ajouterErreur("Variable " + clef + " deja definie");
		} else {
			/* Cree l'ident */
			offsetCourant -= 2;
			IdVar id = new IdVar(typeVar, clef, offsetCourant);
			Yaka.tabIdent.rangeIdentLocaux(clef, id);
		}
	}

	/**
	 * Test de l'existence prealable de l'identificateur
	 * 
	 * @return vrai si l'identificateur existait deja, faux sinon
	 */
	public boolean existe() {
		return Yaka.tabIdent.existeIdentLocaux(nomIdent);
	}

	/**
	 * Appelle la methode ouvrePrinc de yVM avec le nombre de variables du
	 * programme
	 */
	public void ouvrePrinc() {
		Yaka.yVM.entete();
		Yaka.yVM.ouvrePrinc(-offsetCourant); // La variable offsetCourant nous
		// donne le dernier offset utilise,
		// le nombre a envoyer a ouvrePrinc correspond exactement a son oppose
	}

}