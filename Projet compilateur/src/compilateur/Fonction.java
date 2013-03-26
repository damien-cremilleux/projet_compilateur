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
	/**
	 * Pile des parametres
	 */
	private Stack<IdParam> pilePara = new Stack<IdParam>();
	
	/**
	 * Dernier nom vu
	 */
	private String nom;
	
	/**
	 * Dernier type vu (booleen, entier, etc)
	 */
	public int type;	
	
	/**
	 * IdFonct Courant
	 */
	public IdFonct fonctionCourante;
	
	/**
	 * Pointeur des locaux
	 */
	public int ptl=0;
	
	/**
	 * Ancien pointeur
	 */
	public int ancptl = 0;
	int adretour = 0;

	/**
	 * Mise a jour du dernier nom lu
	 * @param ident ident lu
	 */
	public void majNom(String ident){
		nom = ident;
	}
	
	/**
	 * Mise a jour du dernier type lu
	 * @param typeF le type lu
	 */
	public void majType(int typeF){
		type=typeF;
	}
	
	/**
	 * Cree un nouvel idFonc
	 */
	public void initFonc(){
		fonctionCourante = new IdFonct(type, nom); 
	}
	
	/**
	 * Methode pour ajouter des parametres dans la pile
	 * On met l offset a 0 pour le gerer une fois qu'on aura tous les parametres
	 * @param para
	 */	
	public void ajouterParam(){
		IdParam idP = new IdParam(type, nom, 0);
		pilePara.push(idP);
	}
	
	/**
	 * Mise a jour de l'offset des parametres a la fin de la lecture de ceux ci
	 */
	public void majParam(){
		int nbParam = pilePara.size();
		int offset = 4 ;
		for(int i = nbParam - 1  ; i>=0 ; i++){
			IdParam idTmp = pilePara.get(i);
			idTmp.setOffset(offset);
			pilePara.set(i, idTmp);
			offset +=2;
		}
	}


}
