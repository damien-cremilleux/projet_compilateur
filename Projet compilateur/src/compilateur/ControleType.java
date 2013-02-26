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
	 * @param type le type à ajouter
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
			if( pileT.pop() == pileT.pop() == Constante.ENTIER
			int b = pileT.pop()
			break;
		case Constante.OP_MOINS:
			break;
		case Constante.OP_FOIS:
			break;
		case Constante.OP_DIV:
			break;
		case Constante.OP_INF:
			break;
		case Constante.OP_INFEQ:
			break;
		case Constante.OP_SUP:
			break;
		case Constante.OP_SUPEQ:
			break;
		case Constante.OP_EQ:
			break;
		case Constante.OP_DIF:
			break;
		case Constante.OP_ET:
			break;
		case Constante.OP_OU:
			break;
		default:
			break;
		}
	}

}