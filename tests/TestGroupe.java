package TD2_CPOA_CAPPELLINA_MARZOUK.tests;

import TD2_CPOA_CAPPELLINA_MARZOUK.Formation;
import TD2_CPOA_CAPPELLINA_MARZOUK.Identite;
import org.junit.Before;
import org.junit.Test;
import TD2_CPOA_CAPPELLINA_MARZOUK.Etudiant;
import TD2_CPOA_CAPPELLINA_MARZOUK.Groupe;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestGroupe {

    Groupe g;

    @Before
    public void before(){
        g = new Groupe(new Formation());
    }

    @Test
    public void test_ajoutEtudiant(){
        String id = "13";
        String nom = "Kaaris";
        String prenom = "Booba";
        Etudiant e = new Etudiant(new Identite(id, nom, prenom), new Formation());
        g.ajouterEtudiant(e);
        assertEquals("L etudiant a été ajouté", g.getEtudiants().get(0) == e);
    }
}
