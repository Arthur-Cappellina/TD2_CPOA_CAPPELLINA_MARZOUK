package TD2_CPOA_CAPPELLINA_MARZOUK;

import java.util.*;

public class Etudiant extends Groupe {

    private Map<String, ArrayList<Float>> notes;
    private Identite id;
    private Formation fo;

    public Etudiant(Identite identite, Formation formation){
        this.notes = new HashMap<>();
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
        if(note > 20 || note < 0) return;
        if(notes.containsKey(m)) notes.get(m).add(note);
        else {
            ArrayList<Float> noteTemp = new ArrayList<Float>();
            noteTemp.add(note);
            notes.put(m, noteTemp);
        }
    }

    public void ajouterListeNote(String m, List<Float> listeNote){
        getNotes().put(m, (ArrayList<Float>) listeNote);
    }

    public float calculMoyenneMatiere(String m){
        float sum = 0;
        for (int i = 0; i < getNotes().get(m).size(); i++) {
            sum += getNotes().get(m).size();
        }
        return sum/getNotes().get(m).size() ;
    }

    public float calculMoyenneGeneral(){
        float sum = 0;
        Set<String> ks = this.getNotes().keySet();
        for (String m:ks){
            sum += this.calculMoyenneMatiere(m);
        }
        return sum;
    }
}
