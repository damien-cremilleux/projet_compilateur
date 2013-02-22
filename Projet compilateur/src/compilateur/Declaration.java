package compilateur;


public class Declaration {
    private static String nomIdent;
    private static int typeVar;
    private static int offsetCourant = 0;

    public void setNomIdent(String name){
    	nomIdent = name;
    }
    
    public void affectationConst(final int val, final int type) {
    	if(existe()){ Yaka.erreur.ajouterErreur("Constante "+nomIdent+" déjà définie");}
    	else{
    		/* Crée l'ident */
    		IdConst id = new IdConst(type, nomIdent, val);
    		Yaka.tabIdent.rangeIdent(nomIdent, id);
    	}
    }

    public void affectationConstCopie(final String clefACopier){
		if(Yaka.tabIdent.existeIdent(clefACopier)){
				IdConst id = (IdConst) Yaka.tabIdent.chercheIdent(clefACopier);
				this.affectationConst(id.getValeur(), id.getType());
		}else{ 
			Yaka.erreur.ajouterErreur("Constante "+clefACopier+" pas définie");
		}
    }
    
    public void setTypeVar(final int type){
    	typeVar = type;	
    }
    
    public void affectationVal(final String clef) {
    	if(Yaka.tabIdent.existeIdent(clef)){ Yaka.erreur.ajouterErreur("Variable "+clef+" déjà définie");}
    	else{
    		/* Crée l'ident */
    		offsetCourant -= 2;
    		IdVar id = new IdVar(typeVar, this.nomIdent, offsetCourant);
    		Yaka.tabIdent.rangeIdent(this.nomIdent, id);
    	}
    }

    public boolean existe() {        
        return Yaka.tabIdent.existeIdent(this.nomIdent);
    }

}