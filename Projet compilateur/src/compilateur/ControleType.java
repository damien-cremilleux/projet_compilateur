/**
 * Project compilateur - 2012/2013
 * date : 26/02/2013
 * 
 */
package compilateur;

/**
 * Classe ControleType
 * 
 * @author Samuel COZ - Damien CREMILLEUX - Lauriane HOLY - Arnaud TROUCHE
 * 
 */

import java.util.Stack;

public class ControleType {
	/**
	 * Pile contenant les types (entier, booleen, erreur, etc)
	 */
	public static Stack<Integer> pileT = new Stack<Integer>();

	/**
	 * Ajoute un type sur la pile
	 * 
	 * @param type
	 *            le type à ajouter
	 */
	public void ajouteType(int type) {
		pileT.push(type);
	}

	/**
	 * Controle du type pour une opération
	 * 
	 * @param op
	 *            l'opérateur
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
			}
			break;
		case Constante.OP_MOINS:
			if (pileT.pop() == Constante.T_ENTIER
			&& pileT.pop() == Constante.T_ENTIER) {
				pileT.push(Constante.T_ENTIER);
			} else {
				pileT.push(Constante.T_ERREUR);
			}
			break;
		case Constante.OP_FOIS:
			if (pileT.pop() == Constante.T_ENTIER
			&& pileT.pop() == Constante.T_ENTIER) {
				pileT.push(Constante.T_ENTIER);
			} else {
				pileT.push(Constante.T_ERREUR);
			}
			break;
		case Constante.OP_DIV:
			if (pileT.pop() == Constante.T_ENTIER
			&& pileT.pop() == Constante.T_ENTIER) {
				pileT.push(Constante.T_ENTIER);
			} else {
				pileT.push(Constante.T_ERREUR);
			}
			break;
		case Constante.OP_INF:
			if (pileT.pop() == Constante.T_ENTIER
			&& pileT.pop() == Constante.T_ENTIER) {
				pileT.push(Constante.T_BOOLEEN);
			} else {
				pileT.push(Constante.T_ERREUR);
			}
			break;
		case Constante.OP_INFEQ:
			if (pileT.pop() == Constante.T_ENTIER
			&& pileT.pop() == Constante.T_ENTIER) {
				pileT.push(Constante.T_BOOLEEN);
			} else {
				pileT.push(Constante.T_ERREUR);
			}
			break;
		case Constante.OP_SUP:
			if (pileT.pop() == Constante.T_ENTIER
			&& pileT.pop() == Constante.T_ENTIER) {
				pileT.push(Constante.T_BOOLEEN);
			} else {
				pileT.push(Constante.T_ERREUR);
			}
			break;
		case Constante.OP_SUPEQ:
			if (pileT.pop() == Constante.T_ENTIER
			&& pileT.pop() == Constante.T_ENTIER) {
				pileT.push(Constante.T_BOOLEEN);
			} else {
				pileT.push(Constante.T_ERREUR);
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
				}
			}
			break;
		case Constante.OP_ET:
			if (pileT.pop() == Constante.T_BOOLEEN
			&& pileT.pop() == Constante.T_BOOLEEN) {
				pileT.push(Constante.T_BOOLEEN);
			} else {
				pileT.push(Constante.T_ERREUR);
			}
			break;
		case Constante.OP_OU:
			if (pileT.pop() == Constante.T_BOOLEEN
			&& pileT.pop() == Constante.T_BOOLEEN) {
				pileT.push(Constante.T_BOOLEEN);
			} else {
				pileT.push(Constante.T_ERREUR);
			}
			break;
		case Constante.OP_NON:
			if (pileT.pop() == Constante.T_BOOLEEN) {
				pileT.push(Constante.T_BOOLEEN);			
			} else {
				pileT.push(Constante.T_ERREUR);
			}
			break;
		case Constante.OP_NEG:
			if (pileT.pop() == Constante.T_ENTIER) {
				pileT.push(Constante.T_ENTIER);
			} else {
				pileT.push(Constante.T_ERREUR);
			}
		default:
			break;
		}
	}

}