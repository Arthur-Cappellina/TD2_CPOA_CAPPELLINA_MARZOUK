package TD2_CPOA_CAPPELLINA_MARZOUK;

import java.util.*;

public class Etudiant extends Groupe{

    private Map<String, ArrayList<Float>> notes;
    private Identite id;
    private Formation fo;

    public Etudiant(Identite identite, Formation formation){
        this.notes = new HashMap<String, ArrayList<Float>>();
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

    public void ajouterNote(String m, Float note){
        getNotes().get(m).add(note);
    }

    public void ajouterListeNote(String m, List<Float> listeNote){
        getNotes().put(m, (ArrayList<Float>) listeNote);
    }

    public float calculMoyenne(String m){
        float sum = 0;
        for (int i = 0; i < getNotes().get(m).size(); i++) {
            sum += getNotes().get(m).size();
        }
        return sum/getNotes().get(m).size() ;
    }

    public int calculMoyenneMatiere(){
        return 0;
    }
}
