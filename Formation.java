package tp2.git;

import java.util.HashMap;
import java.util.Map;

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
}
