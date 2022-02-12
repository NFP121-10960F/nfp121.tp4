package question3;

import question3.tp3.*;
import question3.tp3.PilePleineException;
import question3.tp3.PileVideException;

/**
 * Classe-test PileModeleTest.
 * 
 * @author (votre nom)
 * @version (un num�?ro de version ou une date)
 * 
 *          Les classes-test sont document�?es ici :
 *          http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html
 *          et sont bas�?es sur le document �? 2002 Robert A. Ballance intitul�?
 *          �JUnit: Unit Testing Framework�.
 * 
 *          Les objets Test (et TestSuite) sont associ�?s aux classes � tester
 *          par la simple relation yyyTest (e.g. qu'un Test de la classe
 *          Name.java se nommera NameTest.java); les deux se retrouvent dans le
 *          m�me paquetage. Les "engagements" (anglais : "fixture") forment un
 *          ensemble de conditions qui sont vraies pour chaque m�?thode Test �
 *          ex�?cuter. Il peut y avoir plus d'une m�?thode Test dans une classe
 *          Test; leur ensemble forme un objet TestSuite. BlueJ d�?couvrira
 *          automatiquement (par introspection) les m�?thodes Test de votre
 *          classe Test et g�?n�?rera la TestSuite cons�?quente. Chaque appel d'une
 *          m�?thode Test sera pr�?c�?d�? d'un appel de setUp(), qui r�?alise les
 *          engagements, et suivi d'un appel � tearDown(), qui les d�?truit.
 */
public class PileModeleTest extends junit.framework.TestCase {
    // D�?finissez ici les variables d'instance n�?cessaires � vos engagements;
    // Vous pouvez �?galement les saisir automatiquement du pr�?sentoir
    // � l'aide du menu contextuel "Pr�?sentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du pr�?sentoir (les objets sans constructeur, comme int, float, etc.).
    PileModele <Integer> p;
    /**
     * Constructeur de la classe-test PileModeleTest
     */
    public PileModeleTest() {
    }

    /**
     * Met en place les engagements.
     * 
     * M�?thode appel�?e avant chaque appel de m�?thode de test.
     */
    protected void setUp() // throws java.lang.Exception
    {
        p = new PileModele<Integer>(new Pile2<Integer>(3));

    }

    /**
     * Supprime les engagements
     * 
     * M�?thode appel�?e apr�s chaque appel de m�?thode de test.
     */
    protected void tearDown() // throws java.lang.Exception
    {
        p = null;
    }

    /**
     * Il ne vous reste plus qu'� d�?finir une ou plusieurs m�?thodes de test. Ces
     * m�?thodes doivent v�?rifier les r�?sultats attendus � l'aide d'assertions
     * assertTrue(<boolean>). Par convention, leurs noms devraient d�?buter par
     * "test". Vous pouvez �?baucher le corps gr�ce au menu contextuel
     * "Enregistrer une m�?thode de test".
     */
    
    public void test_Pile_capacite() {
        assertEquals(3, p.capacite());
    }
    
    public void test_Pile_estPleine() throws Exception {
        p.empiler(3);
        assertEquals(1, p.taille());
        p.empiler(2);
        assertEquals(2, p.taille());
        p.empiler(1);
        assertEquals(3, p.taille());

        assertEquals(true, p.estPleine());
        assertEquals(p.taille(), p.capacite());
        try {
            p.empiler(0);
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question3.tp3.PilePleineException);
        }
    }
    
    public void test_Pile_sommet() throws Exception {
        assertEquals(true, p.estVide());

        p.empiler(new Integer(3));
        assertEquals(" sommet ?? ", new Integer(3), p.sommet());
        assertEquals(1, p.taille());
        assertEquals(" depiler ?? ", new Integer(3), p.depiler());
        assertEquals(0, p.taille());
    }
    
    public void test_Pile_estVide() throws Exception {
        assertEquals(true, p.estVide());
        try {
            Object r = p.depiler();
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question3.tp3.PileVideException);
        }
    }

}