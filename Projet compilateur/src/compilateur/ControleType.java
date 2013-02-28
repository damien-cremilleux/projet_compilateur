/**
 * Projet compilateur - 2012/2013
 * date : 26/02/2013
 * 
 */
package compilateur;

import java.util.Stack;

/**
 * Classe ControleType
 * 
 * @author Samuel COZ - Damien CREMILLEUX - Lauriane HOLY - Arnaud TROUCHE
 * 
 */
public class ControleType {
    /**
     * Pile contenant les types (entier, booleen, erreur, etc)
     */
    public static Stack<Integer> pileT = new Stack<Integer>();

    /**
     * Ajoute un type sur la pile
     * 
     * @param type
     *            le type a ajouter
     */
    public void ajouteType(int type) {
	pileT.push(type);
    }

    /**
     * Controle du type pour une operation
     * 
     * @param op
     *            l'operateur
     * 
     * 
     */
    public void controlerType(int op) {
	switch (op) {
	case Constante.OP_PLUS:
	    if (pileT.pop() == Constante.T_ENTIER
		    && pileT.pop() == Constante.T_ENTIER) {
		pileT.push(Constante.T_ENTIER);
	    } else {
		pileT.push(Constante.T_ERREUR);
		Erreur.ajouterErreur("Probleme de type : une addition doit prendre deux entiers en parametres.");
	    }
	    break;
	case Constante.OP_MOINS:
	    if (pileT.pop() == Constante.T_ENTIER
		    && pileT.pop() == Constante.T_ENTIER) {
		pileT.push(Constante.T_ENTIER);
	    } else {
		pileT.push(Constante.T_ERREUR);
		Erreur.ajouterErreur("Probleme de type : une soustraction doit prendre deux entiers en parametres.");
	    }
	    break;
	case Constante.OP_FOIS:
	    if (pileT.pop() == Constante.T_ENTIER
		    && pileT.pop() == Constante.T_ENTIER) {
		pileT.push(Constante.T_ENTIER);
	    } else {
		pileT.push(Constante.T_ERREUR);
		Erreur.ajouterErreur("Probleme de type : une multiplication doit prendre deux entiers en parametres.");
	    }
	    break;
	case Constante.OP_DIV:
	    if (pileT.pop() == Constante.T_ENTIER
		    && pileT.pop() == Constante.T_ENTIER) {
		pileT.push(Constante.T_ENTIER);
	    } else {
		pileT.push(Constante.T_ERREUR);
		Erreur.ajouterErreur("Probleme de type : une division doit prendre deux entiers en parametres.");
	    }
	    break;
	case Constante.OP_INF:
	    if (pileT.pop() == Constante.T_ENTIER
		    && pileT.pop() == Constante.T_ENTIER) {
		pileT.push(Constante.T_BOOLEEN);
	    } else {
		pileT.push(Constante.T_ERREUR);
		Erreur.ajouterErreur("Probleme de type : une comparaison doit prendre deux entiers en parametres.");
	    }
	    break;
	case Constante.OP_INFEQ:
	    if (pileT.pop() == Constante.T_ENTIER
		    && pileT.pop() == Constante.T_ENTIER) {
		pileT.push(Constante.T_BOOLEEN);
	    } else {
		pileT.push(Constante.T_ERREUR);
		Erreur.ajouterErreur("Probleme de type : une comparaison doit prendre deux entiers en parametres.");
	    }
	    break;
	case Constante.OP_SUP:
	    if (pileT.pop() == Constante.T_ENTIER
		    && pileT.pop() == Constante.T_ENTIER) {
		pileT.push(Constante.T_BOOLEEN);
	    } else {
		pileT.push(Constante.T_ERREUR);
		Erreur.ajouterErreur("Probleme de type : une comparaison doit prendre deux entiers en parametres.");
	    }
	    break;
	case Constante.OP_SUPEQ:
	    if (pileT.pop() == Constante.T_ENTIER
		    && pileT.pop() == Constante.T_ENTIER) {
		pileT.push(Constante.T_BOOLEEN);
	    } else {
		pileT.push(Constante.T_ERREUR);
		Erreur.ajouterErreur("Probleme de type : une comparaison doit prendre deux entiers en parametres.");
	    }
	    break;
	case Constante.OP_EQ:
	    if (pileT.pop() == Constante.T_ENTIER
		    && pileT.pop() == Constante.T_ENTIER) {
		pileT.push(Constante.T_BOOLEEN);
	    } else {
		if (pileT.pop() == Constante.T_BOOLEEN
			&& pileT.pop() == Constante.T_BOOLEEN) {
		    pileT.push(Constante.T_BOOLEEN);
		} else {
		    pileT.push(Constante.T_ERREUR);
		    Erreur.ajouterErreur("Probleme de type : une egalite doit prendre deux entiers ou deux booleens en parametres.");
		}
	    }
	    break;
	case Constante.OP_DIF:
	    if (pileT.pop() == Constante.T_ENTIER
		    && pileT.pop() == Constante.T_ENTIER) {
		pileT.push(Constante.T_BOOLEEN);
	    } else {
		if (pileT.pop() == Constante.T_BOOLEEN
			&& pileT.pop() == Constante.T_BOOLEEN) {
		    pileT.push(Constante.T_BOOLEEN);
		} else {
		    pileT.push(Constante.T_ERREUR);
		    Erreur.ajouterErreur("Probleme de type : une difference doit prendre deux entiers ou deux booleens en parametres.");
		}
	    }
	    break;
	case Constante.OP_ET:
	    if (pileT.pop() == Constante.T_BOOLEEN
		    && pileT.pop() == Constante.T_BOOLEEN) {
		pileT.push(Constante.T_BOOLEEN);
	    } else {
		pileT.push(Constante.T_ERREUR);
		Erreur.ajouterErreur("Probleme de type : un et doit prendre deux booleens en parametres.");
	    }
	    break;
	case Constante.OP_OU:
	    if (pileT.pop() == Constante.T_BOOLEEN
		    && pileT.pop() == Constante.T_BOOLEEN) {
		pileT.push(Constante.T_BOOLEEN);
	    } else {
		pileT.push(Constante.T_ERREUR);
		Erreur.ajouterErreur("Probleme de type : un ou doit prendre deux booleens en parametres.");
	    }
	    break;
	case Constante.OP_NON:
	    if (pileT.pop() == Constante.T_BOOLEEN) {
		pileT.push(Constante.T_BOOLEEN);
	    } else {
		pileT.push(Constante.T_ERREUR);
		Erreur.ajouterErreur("Probleme de type : un non doit prendre un booleen en parametres.");
	    }
	    break;
	case Constante.OP_NEG:
	    if (pileT.pop() == Constante.T_ENTIER) {
		pileT.push(Constante.T_ENTIER);
	    } else {
		pileT.push(Constante.T_ERREUR);
		Erreur.ajouterErreur("Probleme de type : une negation doit prendre un entier en parametres.");
	    }
	case Constante.OP_AFFEC:
	    if (pileT.pop() == pileT.pop()) {
		pileT.push(Constante.T_ENTIER);
	    } else {
		pileT.push(Constante.T_ERREUR);
		Erreur.ajouterErreur("Probleme de type : une affectation doit prendre le meme type de chaque cote de l'affectation.");
	    }
	default:
	    break;
	}
    }

}