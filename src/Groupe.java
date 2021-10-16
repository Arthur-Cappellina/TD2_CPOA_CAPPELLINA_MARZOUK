package TD2_CPOA_CAPPELLINA_MARZOUK.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Classe representant un groupe d'etudiant
 */
public class Groupe {

    private List<Etudiant> etudiants;

    private Formation formation;

    /**
     * Constructeur de la classe
     * @param f
     *      La formation suivie par le groupe
     */
    public Groupe(Formation f){
        etudiants = new ArrayList<>();
        formation = f;
    }

    /**
     * Methode ajoutant un etudiant
     * @param etudiant
     *      L'etudiant a ajouter
     */
    public void ajouterEtudiant(Etudiant etudiant){
        if(formation.equals(etudiant.getFormation())){
            etudiants.add(etudiant);
        }
    }

    /**
     * Methode retirant un eleve du groupe
     * @param etudiant
     *      L'etudiant a enlever
     */
    public void supprimerEtudiant(Etudiant etudiant){
        etudiants.remove(etudiant);
    }

    /**
     * Methode calculant la moyenne d'une matiere du groupe
     * @param matiere
     *      La matiere a calculer
     * @return
     *      la moyenne
     */
    public float calculerMoyenneMatiereGroupe(String matiere){
        if(etudiants.size() <= 0) return 0;
        float somme = 0;
        for(Etudiant e : etudiants){
            somme += e.calculMoyenneMatiere(matiere);
        }
        return somme/etudiants.size();
    }

    /**
     * Methode calculant la moyenne generale du groupe
     * @return
     *      La moyenne general
     */
    public float calculerMoyenneGeneraleGroupe(){
        if(etudiants.size() <= 0) return 0;
        float somme = 0;
        for(Etudiant e : etudiants){
            somme += e.calculMoyenneGeneral();
        }

        return somme/etudiants.size();
    }

    /**
     * Methode qui trie les etudiants par odre alphabetique
     */
    public void triAlpha(){
        Collections.sort(etudiants);
        Collections.reverse(etudiants);
    }

    /**
     * Methode qui trie les etudiants par leurs moyennes
     */
    public void triParMerite(){
        Collections.sort(etudiants, new Comparator<Etudiant>() {
            @Override
            public int compare(Etudiant o1, Etudiant o2) {
                if(o1.calculMoyenneGeneral() > o2.calculMoyenneGeneral()) return -1;
                else if(o1.calculMoyenneGeneral() < o2.calculMoyenneGeneral()) return  1;
                return 0;
            }
        });
    }

    /**
     * Methodant retournant un etudiant a un index donne
     * @param index
     *      l'index de l'etudiant
     * @return
     *      l'etudiant retourne
     */
    public Etudiant getEtudiantAtIndex(int index){
        return etudiants.get(index);
    }

    /**
     * Methode retournant le nombre d'etudiant du groupe
     * @return
     *  le nombre d'etudiant
     */
    public int getNombreEtudiants(){
        return etudiants.size();
    }
}
