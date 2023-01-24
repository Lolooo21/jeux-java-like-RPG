package objet;

public class Objet {
    public String nom;
    public int or;
    public int poids;

    public int quantite;

    public Objet(String nom, int or, int poids, int quantite) {
        this.nom = nom;
        this.or = or;
        this.poids = poids;
        this.quantite = quantite;
    }

    public int getOr() {
        return or;
    }

    public int getPoids() {
        return poids;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
