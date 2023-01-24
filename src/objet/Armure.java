package objet;

public class Armure extends Objet{

    int valDefense;

    int valDurabilite;

    public Armure(String nom, int or, int poids, int valDefense, int valDurabilite, int quantite) {
        super(nom, or, poids, quantite);
        this.valDefense = valDefense;
        this.valDurabilite = valDurabilite;
    }

    public int getValDefense() {
        return valDefense;
    }

    public int getValDurabilite() {
        return valDurabilite;
    }

    public void setValDefense(int valDefense) {
        this.valDefense = valDefense;
    }

    public void setValDurabilite(int valDurabilite) {
        this.valDurabilite = valDurabilite;
    }
}
