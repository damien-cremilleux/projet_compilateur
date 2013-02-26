/**
 * Projet compilateur - 2012/2013
 * date : 22/02/2013
 * 
 */
package compilateur;

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
    public Stack<Object> pileVal = new Stack<Object>();

    /**
     * Pile contenant les operateurs (exemple : +, -, etc)
     */
    public Stack<Integer> pileOp = new Stack<Integer>();    
    
    /**
     * ajouteType : ajoute le type à la pile de type
     */
    public void ajouteType(int typeConstante){
    	Yaka.controleT.ajouteType(typeConstante);
    }
    /**
     * ajouteType : ajoute le type de l'ident dont le nom est clef à la pile de type s'il existe
     */
    public void ajouteType(String clef){
    	if(Yaka.tabIdent.existeIdent(clef)){
    		Ident id = Yaka.tabIdent.chercheIdent(clef);
    		Yaka.controleT.ajouteType(id.getType());
    	}else{
    		Yaka.erreur.ajouterErreur("Identificateur "+clef+" non défini");
    	}
    }
    
    /**
     * ajouteOp : ajoute l'operateur à la pile d'op
     */
    public void ajouteOp(int typeOp){
    	pileOp.push(typeOp);
    }
    
    /**
     * ajouteVal : ajoute l'opérande entier à la pile de val
     */
    public void ajouteVal(int valeur){
    	pileVal.push(valeur);
    }
    /**
     * ajouteVal : ajoute l'opérande booleen à la pile de val
     */
    public void ajouteVal(boolean valeur){
    	pileVal.push(valeur);
    }
    
    
    /**
     * affiche : à la fin de la ligne, vide les piles et ecrit dans le fichier
     */
    public void affiche(){
    	
    }
}