/**
 * Projet compilateur - 2012/2013
 * date : 26/02/2013
 * 
 */
package compilateur;

import java.util.ArrayList;
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
	 * Pile contenant le type des parametres
	 */
	public static Stack<Stack<Integer>> pileP = new Stack<Stack<Integer>>();

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
			if (pileT.peek() == Constante.T_ENTIER) {
				if (pileT.pop() == Constante.T_ENTIER
						&& pileT.pop() == Constante.T_ENTIER) {
					pileT.push(Constante.T_BOOLEEN);
				}
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
			if (pileT.peek() == Constante.T_ENTIER) {
				if (pileT.pop() == Constante.T_ENTIER
						&& pileT.pop() == Constante.T_ENTIER) {
					pileT.push(Constante.T_BOOLEEN);
				}
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
			break;
		case Constante.OP_AFFEC:
			if (pileT.pop() != pileT.pop()) {
				Erreur.ajouterErreur("Probleme de type : une affectation doit prendre le meme type de chaque cote de l'affectation.");
			}
			break;
		default:
			break;
		}
	}

	/**
	 * Crée une nouvelle pile de param pour la fonction
	 */
	public void ajoutePile() {
		pileP.push(new Stack<Integer>());
	}

	/**
	 * Ajoute un type de parametre sur la pile
	 * 
	 * @param type
	 *            le type a ajouter
	 */
	public void transfertTypeParam() {
		int type = pileT.pop();
		Stack<Integer> pile = pileP.pop();
		pile.push(type);
		pileP.push(pile);
	}

	/**
	 * Controle des parametres pour une fonction
	 * 
	 * @param fonction
	 *            l'IdFonct de la fonction a controler
	 */
	public void controleFonction(IdFonct fonction) {
		ArrayList<Integer> paramsDefinition = fonction.getTabParam();
		Stack<Integer> pileAppel = pileP.pop();

		if (pileAppel.size() != paramsDefinition.size()) {
			Erreur.ajouterErreur("Nombre de parametres errone : la fonction attend "
					+ paramsDefinition.size() + " parametres");
		} else {
			for (int i = paramsDefinition.size() - 1; i >= 0; i--) {
				int type = pileAppel.pop();
				if (paramsDefinition.get(i) != type) {
					Erreur.ajouterErreur("Probleme de type de parametres : le parametre numero "
							+ i + " ne correspond pas au type attendu");
					break;
				}

			}
			pileT.push(fonction.getType());
		}
	}

	/**
	 * Controle du retour d'une fonction
	 * 
	 * @param fonction
	 *            l'IdFonct de la fonction a controler
	 * 
	 * 
	 */
	public void controleRetourFonction(IdFonct fonction) {
		if (fonction.getType() != pileT.pop()) {
			Erreur.ajouterErreur("Parametre de retour incorrect pour la fonction "
					+ fonction);
		}
	}

	/**
	 * Verifie si une expression est booleenne (et la supprime de la pile)
	 * 
	 * @return vrai si une expression est booleenne, faux sinon
	 * 
	 */
	public boolean isBoolean() {
		return (pileT.pop() == Constante.T_BOOLEEN);
	}

}