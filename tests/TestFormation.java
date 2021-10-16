package TD2_CPOA_CAPPELLINA_MARZOUK.tests;

import TD2_CPOA_CAPPELLINA_MARZOUK.src.Formation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestFormation {

    Formation f;

    @Before
    public void before(){
        f = new Formation();
    }

    @Test
    public void test_ajouterMatiere_normal(){
        // preparation
        String matiere = "Maths";
        Float coefficient = 2f;

        // Execution
        f.ajouterMatiere(matiere, coefficient);

        // Verification
        assertTrue("Une matiere a été ajouté", f.matiereEstDansLaListe(matiere));
    }

    @Test
    public void test_ajouterMatiere_coeffNegatif(){
        // preparation
        String matiere = "Maths";
        Float coefficient = -2f;

        // Execution
        f.ajouterMatiere(matiere, coefficient);

        // Verification
        assertFalse("La matiere n'aurait pas du etre ajoutee", f.matiereEstDansLaListe(matiere));
    }

    @Test
    public void test_supprimerMatiere_normal(){
        // preparation
        String matiere = "Maths";
        Float coefficient = 1F;

        // Execution
        f.ajouterMatiere(matiere, coefficient);
        f.supprimerMatiere(matiere);

        // Verification
        assertFalse("Une matiere a été supprimé", f.matiereEstDansLaListe(matiere));
    }

    @Test
    public void test_supprimerMatiere_inexistante(){
        // preparation
        String matiere = "Maths";
        Float coefficient = 1F;

        // Execution
        f.ajouterMatiere(matiere, coefficient);
        f.supprimerMatiere("Sport");

        // Verification
        assertTrue("Une matiere n'aurait pas du etre supprimee", f.nombreDeMatiere() == 1);
    }

    @Test
    public void test_getCoeff_normal(){
        // preparation
        String matiere = "Maths";
        Float coefficient = 5F;

        // Execution
        f.ajouterMatiere(matiere, coefficient);

        // Verification
        assertTrue("Le coefficient des maths n'est pas bon", f.getCoeff(matiere) == 5f);
    }

    @Test
    public void test_getCoeff_inexistant(){
        // preparation
        String matiere = "Maths";
        Float coefficient = 5F;

        // Execution
        f.ajouterMatiere(matiere, coefficient);

        // Verification
        assertTrue("Il n'y aurait pas du avoir de coefficient retourne", f.getCoeff("Francais") == -1f);
    }
}
