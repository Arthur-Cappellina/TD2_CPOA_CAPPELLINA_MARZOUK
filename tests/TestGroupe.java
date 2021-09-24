package TD2_CPOA_CAPPELLINA_MARZOUK.tests;


import TD2_CPOA_CAPPELLINA_MARZOUK.src.Etudiant;
import TD2_CPOA_CAPPELLINA_MARZOUK.src.Formation;
import TD2_CPOA_CAPPELLINA_MARZOUK.src.Groupe;
import TD2_CPOA_CAPPELLINA_MARZOUK.src.Identite;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestGroupe {

    Groupe g;
    Formation f;

    @Before
    public void before(){
        f = new Formation();
        g = new Groupe(f);
    }

    @Test
    public void test_ajoutEtudiant(){
        String id = "13";
        String nom = "Kaaris";
        String prenom = "Booba";
        Etudiant e = new Etudiant(new Identite(id, nom, prenom), f);
        g.ajouterEtudiant(e);
        assertTrue("L etudiant a été ajouté", g.getEtudiants().get(0) == e);
    }

    @Test
    public void test_supprimerEtudiant(){
        String id = "13";
        String nom = "Kaaris";
        String prenom = "Booba";
        Etudiant e = new Etudiant(new Identite(id, nom, prenom), f);
        g.ajouterEtudiant(e);
        g.supprimerEtudiant(e);
        assertTrue("L etudiant a été supprimé", g.getEtudiants().size() == 0);
    }

    @Test
    public void test_calculerMoyenneMatiereGroupe(){
        Etudiant e = new Etudiant(new Identite("13", "Kaaris", "Booba"), f);
        g.ajouterEtudiant(e);
        e.ajouterNote("Sport", 10f);
        e.ajouterNote("Sport", 8f);
        e.ajouterNote("Sport", 18f);
        e.ajouterNote("Sport", 6f);
        float moyenne = g.calculerMoyenneMatiereGroupe("Sport");
        assertTrue("La reponse devrait etre 10.5.", 10.5f == moyenne);
    }

    @Test
    public void test_triAlpha(){
        Etudiant e1 = new Etudiant(new Identite("2", "Aaron", "Booba"), f);
        Etudiant e2 = new Etudiant(new Identite("3", "Carlos", "Dori"), f);
        g.ajouterEtudiant(e1);
        g.ajouterEtudiant(e2);
        g.triAlpha();
        assertTrue("L'étudiant numéro 2 doit etre le 1er", g.getEtudiants().get(0) == e2);
    }

    @Test
    public void test_triParMerite(){
        Etudiant e1 = new Etudiant(new Identite("2", "Aaron", "Booba"), f);
        Etudiant e2 = new Etudiant(new Identite("3", "Carlos", "Dori"), f);
        g.ajouterEtudiant(e1);
        g.ajouterEtudiant(e2);
        e1.ajouterNote("Sport", 10f);
        e1.ajouterNote("Sport", 18f);
        e2.ajouterNote("Sport", 8f);
        e2.ajouterNote("Sport", 6f);
        g.triParMerite();
        assertTrue("L'étudiant numéro 2 doit etre le 1er", g.getEtudiants().get(0) == e2);
    }
}