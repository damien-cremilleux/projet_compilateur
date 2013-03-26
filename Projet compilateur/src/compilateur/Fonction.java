/**
 * Projet compilateur - 2012/2013
 * date : 20/03/2013
 * 
 */
package compilateur;

import java.util.Stack;

/**
 * Classe Fonction
 * @author Samuel COZ - Damien CREMILLEUX - Lauriane HOLY - Arnaud TROUCHE
 * 
 */
public class Fonction {
	public Stack<String> pileF = new Stack<String>();
	private Stack<String> pilePara = new Stack<String>();
	
	public int type;			
	public int ptl=0;
	public int ancptl = 0;
	int adretour = 0;

	public void init(String ident){
		
		id = new IdFonct(ident, ); 
		adretour  = 0;
		ancptl = ptl;
		pileF.push("res");
	}

	/**
	 * Methode pour ajouter des parametres dans la pile
	 * @param para
	 */
	public void ajoutePara(String para){
		pileF.push(para);
		pile;
	}

	public void recupererType(int typeF){
		type=typeF;
		
	}


}
