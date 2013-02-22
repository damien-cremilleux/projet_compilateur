/**
 * Projet compilateur - 2012/2013
 * date : 22/02/2013
 * 
 */
package compilateur;

/**
 * Classe Declaration, contenant les fonctions nécessaires à la gestion des
 * déclarations
 * 
 * @author Samuel COZ - Damien CRÉMILLEUX - Lauriane HOLY - Arnaud TROUCHE
 * 
 */
public class Declaration {
    /**
     * Le nom de l'Ident courant
     */
    private static String nomIdent;

    /**
     * Le type de la variable (exemple : entier, booleen, etc)
     */
    private static int typeVar;

    /**
     * L'offset en cours, utilisé par les variables. Il commence à 0
     */
    private static int offsetCourant = 0;

    /**
     * Méthode pour modifier le nom de l'Ident courant
     * 
     * @param name
     *            , le nouveau nom
     */
    public void setNomIdent(String name) {
	nomIdent = name;
    }

    /**
     * Méthode pour affecter une constante
     * 
     * @param val
     *            la valeur de la constante
     * @param type
     *            le type de la constante
     */
    public void affectationConst(final int val, final int type) {
	if (existe()) {
	    Yaka.erreur
		    .ajouterErreur("Constante " + nomIdent + " deja definie"); // TODO
	    // rajouter
	    // le
	    // numéro
	    // de
	    // la
	    // ligne
	    // provoquant
	    // l'erreur
	} else {
	    /* Cree l'ident */
	    IdConst id = new IdConst(type, nomIdent, val);
	    Yaka.tabIdent.rangeIdent(nomIdent, id);
	}
    }

    /**
     * Méthode pour affecter une constante
     * 
     * @param clefACopier
     *            , le nom de la constante
     */
    public void affectationConstCopie(final String clefACopier) {
	if (Yaka.tabIdent.existeIdent(clefACopier)) {
	    IdConst id = (IdConst) Yaka.tabIdent.chercheIdent(clefACopier);
	    this.affectationConst(id.getValeur(), id.getType());
	} else {
	    Yaka.erreur.ajouterErreur("Constante " + clefACopier
		    + " pas definie");
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
     * Méthode pour affecter une variable
     * 
     * @param clef
     *            le nom de la variable
     */
    public void affectationVal(final String clef) {
	if (Yaka.tabIdent.existeIdent(clef)) {
	    Yaka.erreur.ajouterErreur("Variable " + clef + " deja definie");
	} else {
	    /* Cree l'ident */
	    offsetCourant -= 2;
	    IdVar id = new IdVar(typeVar, nomIdent, offsetCourant); // TODO que
								    // devient
								    // la clef ?
	    Yaka.tabIdent.rangeIdent(nomIdent, id);
	}
    }

    /**
     * Test de l'existence préalable de l'identificateur
     * 
     * @return vrai si l'identificateur existait deja, faux sinon
     */
    public boolean existe() {
	return Yaka.tabIdent.existeIdent(nomIdent);
    }

}