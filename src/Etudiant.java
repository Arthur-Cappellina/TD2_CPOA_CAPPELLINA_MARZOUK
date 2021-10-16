package TD2_CPOA_CAPPELLINA_MARZOUK.src;

import java.util.*;

/**
 * Classe representant un etudiant
 */
public class Etudiant implements Comparable<Etudiant> {

    private Map<String, ArrayList<Float>> notes;
    private Identite id;
    private Formation formation;

    /**
     * Constructeur d'un etudiant
     * @param identite  son identite
     * @param formation sa formation
     */
    public Etudiant(Identite identite, Formation formation){
        this.notes = new HashMap<>();
        this.id = identite;
        this.formation = formation;
    }

    /**
     * Getter des notes de l'etudiant
     * @return ses notes
     */
    public Map<String, ArrayList<Float>> getNotes(){
        return this.notes;
    }

    /**
     * Getter de l'identite de l'etudiant
     * @return son identité
     */
    public Identite getIdentite(){
        return this.id;
    }

    /**
     * Getter de la formation de l'etudiant
     * @return sa formation
     */
    public Formation getFormation(){
        return this.formation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Etudiant etudiant = (Etudiant) o;
        return Objects.equals(notes, etudiant.notes) && Objects.equals(id, etudiant.id) && Objects.equals(formation, etudiant.formation);
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "notes=" + notes +
                ", id=" + id +
                ", fo=" + formation +
                '}';
    }

    /**
     * Methode qui permet d'ajouter une note a l'etudiant
     * @param m
     *      La matiere de la note
     * @param note
     *      La note a ajoutee
     */
    public void ajouterNote(String m, Float note){
        if(note > 20 || note < 0 || !formation.matiereEstDansLaListe(m)) return;
        if(notes.containsKey(m)) notes.get(m).add(note);
        else {
            ArrayList<Float> noteTemp = new ArrayList<>();
            noteTemp.add(note);
            notes.put(m, noteTemp);
        }
    }

    /**
     * Methode permettant de calculer la moyenne de l'etudiant dans une matiere
     * @param m
     *      la matiere en question
     * @return
     *      la moyenne calculee
     */
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

    /**
     * Methode calculant la moyenne general de l'etudiant
     * @return
     *      la moyenne general
     */
    public float calculMoyenneGeneral(){
        float sum = 0;
        float coeffTotaux = 0;
        for (String matiere : notes.keySet()){
            sum += calculMoyenneMatiere(matiere) * formation.getCoeff(matiere);
            coeffTotaux += formation.getCoeff(matiere);
        }
        System.out.println(sum/coeffTotaux);
        return sum / coeffTotaux;
    }

    /**
     * Methode permettant de comparer deux etudiants par leurs noms
     * @param o
     *      l'etudiant a comparer avec this
     * @return
     *      1 si this est avant dans l'ordre alphabetique
     */
    @Override
    public int compareTo(Etudiant o) {
        return o.getIdentite().getNom().compareTo(id.getNom());
    }
}
