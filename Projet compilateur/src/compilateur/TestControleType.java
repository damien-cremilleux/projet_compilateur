/**
 * Projet compilateur - 2012/2013
 * date : 26/02/2013
 * 
 */
package compilateur;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Classe TestControleType - Test JUnit de ControleType
 * 
 * @author Samuel COZ - Damien CREMILLEUX - Lauriane HOLY - Arnaud TROUCHE
 * 
 */
public class TestControleType {

    /**
     * Construction d'un objet de type ControleType
     */
    public ControleType t = new ControleType();

    /**
     * Test method for {@link compilateur.ControleType#ajouteType(int)}.
     */
    @Test
    public void testAjouteType() {
	t.ajouteType(Constante.T_BOOLEEN);
	assertTrue(ControleType.pileT.pop().equals(Constante.T_BOOLEEN));
	t.ajouteType(Constante.T_ENTIER);
	assertTrue(ControleType.pileT.pop().equals(Constante.T_ENTIER));
	t.ajouteType(Constante.T_ERREUR);
	assertTrue(ControleType.pileT.pop().equals(Constante.T_ERREUR));

    }

    /**
     * Test method for {@link compilateur.ControleType#controlerType(int)}.
     */
    @Test
    public void testControlerType() {
	t.ajouteType(Constante.T_BOOLEEN);
	t.ajouteType(Constante.T_BOOLEEN);
	t.controlerType(Constante.OP_PLUS);
	assertTrue(ControleType.pileT.pop().equals(Constante.T_ERREUR));

	t.ajouteType(Constante.T_ENTIER);
	t.ajouteType(Constante.T_ENTIER);
	t.controlerType(Constante.OP_PLUS);
	assertTrue(ControleType.pileT.pop().equals(Constante.T_ENTIER));
    }

}
