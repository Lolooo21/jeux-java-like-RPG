package objet;

public class Arme extends Objet{
    int valAttaque;
    int durabilite;

    public Arme(String nom, int or, int poids, int valattaque, int durabilite, int quantite) {
        super(nom, or, poids,quantite);
        this.valAttaque = valattaque;
        this.durabilite = durabilite;
    }
    public void setDurabilite(int durable){
        this.durabilite=durable;

    }

    public int getDurabilite() {
        return durabilite;
    }

    public int getValAttaque() {
        return valAttaque;
    }


}
