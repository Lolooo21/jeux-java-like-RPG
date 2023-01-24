package objet;

public class PotiondeVie extends Consommable{
    public PotiondeVie(String nom, int or, int poids, int quantite) {
        super(nom, or, poids, quantite);
        this.quantite = 2;
    }
}
