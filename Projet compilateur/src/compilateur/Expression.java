/**
 * Projet compilateur - 2012/2013
 * date : 22/02/2013
 * 
 */
package compilateur;

import java.util.List;
import java.util.Stack;

/**
 * Classe Expression, contient les fonctions necessaires Ã  la gestion des declarations et des expressions
 * 
 * @author Samuel COZ - Damien CRÃ‰MILLEUX - Lauriane HOLY - Arnaud TROUCHE
 */
public class Expression {
    
    /**
     * Pile contenant les opérandes 
     */
    public List<Integer> PileVal = new Stack<Integer>();

    /**
     * Pile contenant les operateurs (exemple : +, -, etc)
     */
    public List<Integer> PileOp = new Stack<Integer>();

    /**
     * Methode ajoute
     */
    public void ajoute() {
    }

    /**
     * Methode soustraire
     */
    public void soustraire() {
    }

    /**
     * Methode multiplier
     */
    public void multiplier() {
    }

    /**
     * Methode diviser
     */
    public void diviser() {
    }

    /**
     * Methode inferieur
     */
    public void inferieur() {
    }

    /**
     * Methode superieur
     */
    public void superieur() {
    }

    /**
     * Methode infouegal
     */
    public void infouegal() {
    }

    /**
     * Methode supouegal
     */
    public void supouegal() {
    }

    /**
     * Methode egal
     */
    public void egal() {
    }

    /**
     * Methode nonegal
     */
    public void nonegal() {
    }

    /**
     * Methode et
     */
    public void et() {
    }

    /**
     * Méthode ou
     */
    public void ou() {
    }

    /**
     * Methode negationEntier
     */
    public void negationEntier() {
    }

    /**
     * Methode negationBool
     */
    public void negationBool() {
    }
    
    
    /**
     * ajouteType : ajoute le type à la pile de type
     */
    public void ajouteType(int typeConstante){
    }
    /**
     * ajouteType : ajoute le type de l'ident dont le nom est clef à la pile de type s'il existe
     */
    public void ajouteType(String clef){
    }
    
    /**
     * ajouteOp : ajoute l'operateur à la pile d'op
     */
    public void ajouteOp(int typeOp){
    }
    
    /**
     * ajouteVal : ajoute l'opérande entier à la pile de val
     */
    public void ajouteVal(int valeur){
    }
    /**
     * ajouteVal : ajoute l'opérande booleen à la pile de val
     */
    public void ajouteVal(boolean valeur){
    }
    
    
    /**
     * affiche : à la fin de la ligne, vide les piles et ecrit dans le fichier
     */
    public void affiche(){
    	
    }
}