/**
 * Projet compilateur - 2012/2013
 * date : 22/02/2013
 * 
 */
package compilateur;

import java.util.Stack;

/**
 * Classe Expression, contient les fonctions necessaires a la gestion des
 * declarations et des expressions
 * 
 * @author Samuel COZ - Damien CREMILLEUX - Lauriane HOLY - Arnaud TROUCHE
 */
public class Expression {

    /**
     * Pile contenant les operateurs (exemple : +, -, etc)
     */
    public Stack<Integer> pileOp = new Stack<Integer>();

    /**
     * ajouteType : ajoute le type a la pile de type
     * 
     * @param type
     *            le type a ajouter
     */
    public void ajouteType(int type) {
	Yaka.controleT.ajouteType(type);
    }

    /**
     * ajouteType : ajoute le type et la valeur de l'ident dont le nom est clef
     * a la pile de type s'il existe
     * 
     * @param clef
     *            nom de l'ident
     */
    public void ajoute(String clef) {
	if (Yaka.tabIdent.existeIdent(clef)) {
	    Ident id = Yaka.tabIdent.chercheIdent(clef);
	    int type = id.getType();
	    Yaka.controleT.ajouteType(type);
	    if (id instanceof IdConst) {
		Yaka.yVM.iconst(((IdConst) id).getValeur());
	    }
	    if (id instanceof IdVar) {
		Yaka.yVM.iload(((IdVar) id).getOffset());
	    }
	} else {
	    Erreur.ajouterErreur("Identificateur " + clef + " non dÃ©fini");
	}
    }

    /**
     * ajouteOp : ajoute l'operateur Ã  la pile d'op
     * 
     * @param typeOp
     *            le type de l'opÃ©rateur
     */
    public void ajouteOp(int typeOp) {
	pileOp.push(typeOp);
    }

    /**
     * ajouteVal : ajoute l'operande au fichier yVM
     * 
     * @param val
     *            le booleen a empiler
     */
    public void ajouteVal(boolean val) {
	if (val) {
	    Yaka.yVM.iconst(Constante.V_VRAI);
	} else {
	    Yaka.yVM.iconst(Constante.V_FAUX);
	}

    }

    /**
     * ajouteVal : ajoute l'operande au fichier yVM
     * 
     * @param val
     *            le booleen a empiler
     */
    public void ajouteVal(int val) {
	Yaka.yVM.iconst(val);

    }

    /**
     * operation : Ã  la fin de la ligne, vide les piles et ecrit dans le fichier
     */
    public void operation() {
	int operateur = pileOp.pop();
	Yaka.controleT.controlerType(operateur);

	switch (operateur) {
	case Constante.OP_PLUS:
	    Yaka.yVM.iadd();
	    break;

	case Constante.OP_MOINS:
	    Yaka.yVM.isub();
	    break;

	case Constante.OP_FOIS:
	    Yaka.yVM.imul();
	    break;

	case Constante.OP_DIV:
	    Yaka.yVM.idiv();
	    break;

	case Constante.OP_SUP:
	    Yaka.yVM.isup();
	    break;

	case Constante.OP_INF:
	    Yaka.yVM.iinf();
	    break;

	case Constante.OP_SUPEQ:
	    Yaka.yVM.isupegal();
	    break;

	case Constante.OP_INFEQ:
	    Yaka.yVM.iinfegal();
	    break;

	case Constante.OP_EQ:
	    Yaka.yVM.iegal();
	    break;

	case Constante.OP_DIF:
	    Yaka.yVM.idiff();
	    break;

	case Constante.OP_ET:
	    Yaka.yVM.iand();
	    break;

	case Constante.OP_OU:
	    Yaka.yVM.ior();
	    break;

	case Constante.OP_NEG:
	    Yaka.yVM.ineg();
	    break;

	case Constante.OP_NON:
	    Yaka.yVM.inot();
	    break;
	}
    }
    
   /**
    * methode pour affecter une valeur à une variable
    * @param clef : l'identificateur de la variable
    */
    public void affectation(String clef){
    	//Yaka.controleT.controlerType(Constante.OP_AFFEC);
    	
    	if(Yaka.tabIdent.existeIdent(clef)) {
    	    Ident id = Yaka.tabIdent.chercheIdent(clef);
    	    int type = id.getType();
    	    Yaka.controleT.ajouteType(type);
    	    if (id instanceof IdVar) {
    		System.out.println(clef);
    	    	Yaka.yVM.istore(((IdVar) id).getOffset());
    	    }else{
    	    	Erreur.ajouterErreur("Affectation à une constante impossible");
    	    }
    	} else {
    	    Erreur.ajouterErreur("Identificateur " + clef + " non defini");
    	}
    }
    
}