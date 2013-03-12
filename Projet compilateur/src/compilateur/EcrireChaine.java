/**
 * Projet compilateur - 2012/2013
 * date : 12/03/2013
 * 
 */
package compilateur;

/**
 * Classe EcrireChaine, gestion de l'écriture
 * 
 * @author Samuel COZ - Damien CREMILLEUX - Lauriane HOLY - Arnaud TROUCHE
 * 
 */
public class EcrireChaine {

    /**
     * Numero du message courant
     */
    private static int nbEcr = 0;

    /**
     * Accesseur a getNbEcr
     * 
     * @return nbEcr, le numero du message courant
     */
    public static int getNbEcr() {
	return nbEcr;
    }

    /**
     * Incremente le numero à chaque nouveau message
     * 
     * @return le numero du messaqe
     * 
     */
    public static int nouveauMess() {
	return nbEcr++;
    }

}
