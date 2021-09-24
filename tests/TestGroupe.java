package TD2_CPOA_CAPPELLINA_MARZOUK.tests;


import TD2_CPOA_CAPPELLINA_MARZOUK.src.Etudiant;
import TD2_CPOA_CAPPELLINA_MARZOUK.src.Formation;
import TD2_CPOA_CAPPELLINA_MARZOUK.src.Groupe;
import TD2_CPOA_CAPPELLINA_MARZOUK.src.Identite;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
