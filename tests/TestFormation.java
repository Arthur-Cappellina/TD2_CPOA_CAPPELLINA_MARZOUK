package TD2_CPOA_CAPPELLINA_MARZOUK.tests;

import TD2_CPOA_CAPPELLINA_MARZOUK.src.Formation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestFormation {

    Formation f;

    @Before
    public void before(){f = new Formation();}

    @Test
    public void test_ajoutMatiere(){
        String matiere = "Maths";
        Float coefficient = 1F;
        f.ajouterMatiere(matiere, coefficient);
        assertTrue("Une matiere a été ajouté", f.getCoeff(matiere) != -1);
    }

    @Test
    public void test_supprMatiere(){
        String matiere = "Maths";
        Float coefficient = 1F;
        //f.ajouterMatiere(matiere, coefficient);
        f.supprimerMatiere(matiere, coefficient);
        assertTrue("Une matiere a été supprimé", f.getCoeff(matiere) == -1);
    }
}
