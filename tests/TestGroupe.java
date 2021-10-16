package TD2_CPOA_CAPPELLINA_MARZOUK.tests;


import TD2_CPOA_CAPPELLINA_MARZOUK.src.Etudiant;
import TD2_CPOA_CAPPELLINA_MARZOUK.src.Formation;
import TD2_CPOA_CAPPELLINA_MARZOUK.src.Groupe;
import TD2_CPOA_CAPPELLINA_MARZOUK.src.Identite;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestGroupe {

    Formation f = new Formation();

    Groupe groupeF = new Groupe(f), groupe = new Groupe(new Formation());
    Etudiant jean = new Etudiant(new Identite("13", "Jean", "Martin"), f);
    Etudiant alphonse = new Etudiant(new Identite("14", "Bernard", "Alphonse"), f);

    @Before
    public void Before() {
        f.ajouterMatiere("Sport", 2f);
    }

    @Test
    public void test_ajoutEtudiant_normal(){
        // Execution
        groupeF.ajouterEtudiant(jean);
        assertTrue("L etudiant a été ajouté", groupeF.getEtudiantAtIndex(0) == jean);
    }

    @Test
    public void test_ajoutEtudiant_differentesFormations(){
        // Execution
        groupe.ajouterEtudiant(jean);

        // Verification
        assertTrue("L etudiant a été ajouté", groupe.getNombreEtudiants() == 0);
    }

    @Test
    public void test_supprimerEtudiant_normal(){
        // Execution
        groupeF.ajouterEtudiant(jean);
        groupeF.supprimerEtudiant(jean);

        // Verification
        assertTrue("L etudiant a été supprimé", groupeF.getNombreEtudiants() == 0);
    }

    @Test
    public void test_calculerMoyenneMatiereGroupe(){
        // Execution
        groupeF.ajouterEtudiant(jean);
        groupeF.ajouterEtudiant(alphonse);
        jean.ajouterNote("Sport", 10f);
        jean.ajouterNote("Sport", 10f);
        alphonse.ajouterNote("Sport", 14f);
        alphonse.ajouterNote("Sport", 6f);
        float moyenne = groupeF.calculerMoyenneMatiereGroupe("Sport");

        // Verification
        assertTrue("La reponse devrait etre 10.5.", 10f == moyenne);
    }

    @Test
    public void test_triAlpha(){
        // Execution
        groupeF.ajouterEtudiant(alphonse);
        groupeF.ajouterEtudiant(jean);
        groupeF.triAlpha();

        // Verification
        assertTrue("L'étudiant numéro 2 doit etre le 1er", groupeF.getEtudiantAtIndex(0) == alphonse);
    }

    @Test
    public void test_triParMerite(){
        // Preparation
        groupeF.ajouterEtudiant(jean);
        groupeF.ajouterEtudiant(alphonse);

        // Execution
        jean.ajouterNote("Sport", 10f);
        jean.ajouterNote("Sport", 18f);
        alphonse.ajouterNote("Sport", 8f);
        alphonse.ajouterNote("Sport", 6f);
        groupeF.triParMerite();
        assertTrue("L'étudiant numéro 2 doit etre le 1er", groupeF.getEtudiantAtIndex(0) == jean);
    }
}

