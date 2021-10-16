package TD2_CPOA_CAPPELLINA_MARZOUK.tests;

import TD2_CPOA_CAPPELLINA_MARZOUK.src.Formation;
import TD2_CPOA_CAPPELLINA_MARZOUK.src.Identite;
import org.junit.Before;
import org.junit.Test;
import TD2_CPOA_CAPPELLINA_MARZOUK.src.Etudiant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestEtudiant {

    Etudiant e;
    Formation f;

    @Before
    public void before(){
        f = new Formation();
        f.ajouterMatiere("Sport", 2);
        f.ajouterMatiere("Francais", 3);
        f.ajouterMatiere("Maths", 1);
        e = new Etudiant(new Identite("123", "Martin", "Jean"), f);
    }

    @Test
    public void test_ajouterNote_normal(){
        // Préparations des données
        String matiere = "Sport";
        Float note = 5f;

        // Execution
        e.ajouterNote(matiere, note);

        // Verification
        assertTrue("La note n'a pas ete ajoutee", e.getNotes().get(matiere).get(0) == note);

    }

    @Test
    public void test_ajouterNote_negatives(){
        // Préparations des données
        String matiere = "Sport";
        Float note = -5f;

        // Execution
        e.ajouterNote(matiere, note);

        // Verification
        assertTrue("La note n'a pas ete ajoutee", e.getNotes().size() == 0);
    }

    @Test
    public void test_ajouterNote_superieures(){
        // Préparations des données
        String matiere = "Sport";
        Float note = 25f;

        // Execution
        e.ajouterNote(matiere, note);

        // Verification
        assertTrue("La note n'a pas ete ajoutee", e.getNotes().size() == 0);
    }

    @Test
    public void test_calculerMoyenneMatiere(){
        // Préparation des données
        e.ajouterNote("Sport", 10f);
        e.ajouterNote("Sport", 8f);
        e.ajouterNote("Sport", 18f);
        e.ajouterNote("Sport", 6f);

        // Execution
        float moyenne = e.calculMoyenneMatiere("Sport");

        // Verification
        assertTrue("La moyenne devrait valoir 10,5.", 10.5f == moyenne);
    }

    @Test
    public void test_calculerMoyenneGenerale(){
        // Préparation des données
        e.ajouterNote("Sport", 20f);
        e.ajouterNote("Francais", 4f);
        e.ajouterNote("Maths", 8f);

        // Execution
        float moyenne = e.calculMoyenneGeneral();

        // Verification, devrait valoir (20 * 2 + 4 * 3 + 8 * 1)  / 6 =10
        assertTrue("La moyenne devrait valoir 10.", 10f == moyenne);
    }
}
