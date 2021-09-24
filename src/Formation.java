package TD2_CPOA_CAPPELLINA_MARZOUK.src;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Formation {

    private int identifiant;

    private Map<String, Float> coefficientsMatieres;

    private static int DERNIER_NUMERO = 1;

    public Formation(){
        identifiant = DERNIER_NUMERO;
        DERNIER_NUMERO++;
        coefficientsMatieres = new HashMap<String, Float>();
    }

    public void ajouterMatiere(String matiere, float coefficient){
        if(!coefficientsMatieres.containsKey(coefficient))
            coefficientsMatieres.put(matiere, coefficient);
    }

    public void supprimerMatiere(String matiere, float coefficient){
        if(coefficientsMatieres.containsKey(coefficient))
            coefficientsMatieres.remove(matiere);
    }

    public float getCoeff(String matiere){
        return coefficientsMatieres.containsKey(matiere) ? coefficientsMatieres.get(matiere) : -1;
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
