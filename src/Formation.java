package TD2_CPOA_CAPPELLINA_MARZOUK.src;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Classe représentant une formation
 */
public class Formation {

    private int identifiant;

    private Map<String, Float> coefficientsMatieres;

    private static int DERNIER_NUMERO = 1;

    /**
     * Constructeur de base de la classe formation
     */
    public Formation(){
        identifiant = DERNIER_NUMERO;
        DERNIER_NUMERO++;
        coefficientsMatieres = new HashMap<String, Float>();
    }

    /**
     * Methode qui permet d'ajouter une matiere a la formation avec son coefficient
     * @param matiere
     *      Le nom de la matiere
     * @param coefficient
     *      Son coefficient
     */
    public void ajouterMatiere(String matiere, float coefficient){
        if(coefficient > 0)
            coefficientsMatieres.put(matiere, coefficient);
    }

    /**
     * Methode permettant de supprimer une matiere de la formation
     * @param matiere
     */
    public void supprimerMatiere(String matiere){
        coefficientsMatieres.remove(matiere);
    }

    /**
     * Methode qui recupere le coefficient d'une matiere
     * @param matiere
     *      la matiere concernee
     * @return
     *      son coefficient
     */
    public float getCoeff(String matiere){
        return coefficientsMatieres.containsKey(matiere) ? coefficientsMatieres.get(matiere) : -1;
    }

    /**
     * Methode permettant de savoir si une matiere est dans une liste
     * @param matiere
     *      la matiere que l'on souhaite tester
     * @return
     *      vrai, si la matiere est dans la liste
     */
    public boolean matiereEstDansLaListe(String matiere){
        return coefficientsMatieres.containsKey(matiere);
    }

    /**
     * Retourne le nombre de matiere de la formation
     * @return
     *      le nombre de matiere
     */
    public int nombreDeMatiere(){
        return coefficientsMatieres.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Formation formation = (Formation) o;
        return identifiant == formation.identifiant && Objects.equals(coefficientsMatieres, formation.coefficientsMatieres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifiant, coefficientsMatieres);
    }
}
