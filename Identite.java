package TD2_CPOA_CAPPELLINA_MARZOUK;

import java.util.*;

public class Identite {

    private String nip;
    private String nom;
    private String prenom;

    public Identite(String ni, String no, String pr){
        this.nip = ni;
        this.nom = no;
        this.prenom = pr;
    }

    public String getNip(){
        return this.nip;
    }

    public String getNom(){
        return this.nom;
    }

    public String getPrenom(){
        return this.prenom;
    }

    @Override
    public String toString() {
        return "Identite{" +
                "nip='" + nip + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identite identite = (Identite) o;
        return Objects.equals(nip, identite.nip) && Objects.equals(nom, identite.nom) && Objects.equals(prenom, identite.prenom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nip, nom, prenom);
    }
}
