/**
 * Projet compilateur - 2012/2013
 * date : 22/02/2013
 * 
 */
package compilateur;

import java.util.List;
import java.util.Stack;

/**
 * Classe Expression, contient les fonctions nécessaires à la gestion des déclarations et des expressions
 * 
 * @author Samuel COZ - Damien CRÉMILLEUX - Lauriane HOLY - Arnaud TROUCHE
 */
public class Expression {
    
    /**
     * Pile contenant les types des expressions (exemple : entier, booleens, etc)
     */
    public List<String> PileType = new Stack<String>();

    /**
     * Pile contenant les opérateurs (exemple : +, -, etc)
     */
    public List<String> PileOp = new Stack<String>();

    /**
     * Méthode ajoute
     */
    public void ajoute() {
    }

    /**
     * Méthode soustraire
     */
    public void soustraire() {
    }

    /**
     * Méthode multiplier
     */
    public void multiplier() {
    }

    /**
     * Méthode diviser
     */
    public void diviser() {
    }

    /**
     * Méthode inférieur
     */
    public void inferieur() {
    }

    /**
     * Méthode supérieur
     */
    public void superieur() {
    }

    /**
     * Méthode infouegal
     */
    public void infouegal() {
    }

    /**
     * Méthode supouegal
     */
    public void supouegal() {
    }

    /**
     * Méthode egal
     */
    public void egal() {
    }

    /**
     * Méthode nonegal
     */
    public void nonegal() {
    }

    /**
     * Méthode et
     */
    public void et() {
    }

    /**
     * Méthode ou
     */
    public void ou() {
    }

    /**
     * Méthode negationEntier
     */
    public void negationEntier() {
    }

    /**
     * Méthode negationBool
     */
    public void negationBool() {
    }

}