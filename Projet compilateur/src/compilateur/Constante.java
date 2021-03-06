/**
 * Projet compilateur - 2012/2013
 * date : 22/02/2013
 * 
 */
package compilateur;

/**
 * Classe Constante
 * 
 * @author Samuel COZ - Damien CREMILLEUX - Lauriane HOLY - Arnaud TROUCHE
 * 
 */
public class Constante {

	/* CONSTANTES ASM */
	/**
	 * Definition du type Vrai pour YVM et ASM
	 */
	public static final int V_VRAI = -1;

	/**
	 * Definition du type Faux pour YVM et ASM
	 */
	public static final int V_FAUX = 0;

	/* CONSTANTES DE TYPES */
	/**
	 * Definition du type booleen
	 */
	public static final int T_BOOLEEN = 0;

	/**
	 * Definition du type entier
	 */
	public static final int T_ENTIER = 1;

	/**
	 * Definition du type erreur
	 */
	public static final int T_ERREUR = -1;

	/* CONSTANTES DE TYPES */
	/**
	 * Definition de l'operande +
	 */
	public static final int OP_PLUS = 0;

	/**
	 * Definition de l'operande -
	 */
	public static final int OP_MOINS = 1;

	/**
	 * Definition de l'operande *
	 */
	public static final int OP_FOIS = 2;

	/**
	 * Definition de l'operande /
	 */
	public static final int OP_DIV = 3;

	/**
	 * Definition de l'operande <
	 */
	public static final int OP_INF = 4;

	/**
	 * Definition de l'operande >
	 */
	public static final int OP_SUP = 5;

	/**
	 * Definition de l'operande <=
	 */
	public static final int OP_INFEQ = 6;

	/**
	 * Definition de l'operande >=
	 */
	public static final int OP_SUPEQ = 7;

	/**
	 * Definition de l'operande =
	 */
	public static final int OP_EQ = 8;

	/**
	 * Definition de l'operande !=
	 */
	public static final int OP_DIF = 9;

	/**
	 * Definition de l'operande et
	 */
	public static final int OP_ET = 10;

	/**
	 * Definition de l'operande ou
	 */
	public static final int OP_OU = 11;

	/**
	 * Definition de l'operande non
	 */
	public static final int OP_NON = 12;

	/**
	 * Definition de l'operande neg
	 */
	public static final int OP_NEG = 13;

	/**
	 * Definition de l'operande pour l'affectation
	 */
	public static final int OP_AFFEC = 14;

	/**
	 * Definition de l'operande pour l'ecriture
	 */
	public static final int OP_ECRIRE = 15;

	/**
	 * Definition de l'operande pour la lecture
	 */
	public static final int OP_LIRE = 16;

	/**
	 * Definition de l'operande pour aller a la ligne
	 */
	public static final int OP_ALALIGNE = 17;
}