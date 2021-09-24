package TD2_CPOA_CAPPELLINA_MARZOUK.src;

import java.util.*;

public class Etudiant implements Comparable<Etudiant> {

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

    public Identite getIdentite(){
        return this.id;
    }

    public Formation getFormation(){
        return this.fo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Etudiant etudiant = (Etudiant) o;
        return Objects.equals(notes, etudiant.notes) && Objects.equals(id, etudiant.id) && Objects.equals(fo, etudiant.fo);
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
            ArrayList<Float> noteTemp = new ArrayList<>();
            noteTemp.add(note);
            notes.put(m, noteTemp);
        }
    }

    public float calculMoyenneMatiere(String m){
        float sum = 0;
        if (notes.containsKey(m)) {
            for (int i = 0; i < notes.get(m).size(); i++) {
                sum += notes.get(m).get(i);
            }
            return sum / notes.get(m).size();
        } else {
            return 0;
        }
    }

    public float calculMoyenneGeneral(){
        float sum = 0;
        for (String matiere : notes.keySet()){
            sum += this.calculMoyenneMatiere(matiere);
        }
        return sum / notes.keySet().size();
    }

    @Override
    public int compareTo(Etudiant o) {
        return o.getIdentite().getNom().compareTo(id.getNom());
    }
}