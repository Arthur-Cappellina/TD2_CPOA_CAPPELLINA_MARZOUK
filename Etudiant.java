package TD2_CPOA_CAPPELLINA_MARZOUK;

import java.util.*;

public class Etudiant extends Groupe{

    private Map<String, ArrayList<Float>> notes;
    private Identite id;
    private Formation fo;

    public Etudiant(Identite identite, Formation formation){
        this.id = identite;
        this.fo = formation;
    }

    public Map<String, ArrayList<Float>> getNotes(){
        return this.notes;
    }

    public Identite getId(){
        return this.id;
    }

    public Formation getFo(){
        return this.fo;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "notes=" + notes +
                ", id=" + id +
                ", fo=" + fo +
                '}';
    }

    public void ajouterNote(String m, List<Float> note){

    }

    public int calculMoyenne(String m){
        return 0;
    }

    public int calculMoyenneMatiere(){
        return 0;
    }
}
