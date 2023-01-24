package personnages;

import objet.Objet;

public class Ennemis {
    int ptsDeVie = 10;
    int attaque = 5;
    int experience = 10;
    public boolean vivant = true;
    String nom;
    public Objet loot = new Objet("poussières", 25, 3,1);

    int or;

    public Ennemis(String nom, int or) {
        this.nom = nom;
        this.or = or;
    }


    public void mourir(Heros hero) {
        if (this.ptsDeVie <= 0) {
            System.out.println();
            System.out.println(this.nom + " est mort");
            System.out.println("Vous gagnez " + this.experience + " d'exp!");
            System.out.println(" Vous récupérez " + this.or + " pièces d'or.");
            hero.gagnerExperience(this.experience);
            hero.loot(this.loot,this.or);
            this.experience = 0;
            this.ptsDeVie = 0;
            this.caracteristiqueEnnemi();
            this.vivant = false;
        }
    }

    public void caracteristiqueEnnemi() {
        System.out.println();
        System.out.println("STATUT ennemi");
        System.out.println(" - Points de vie = " + this.ptsDeVie);
        System.out.println(" - Points d'exp = " + this.experience);
        System.out.println(" - Loot = " + this.loot.nom);
    }

    public void attaque(Heros hero) {
        if (this.vivant) {
            System.out.println();
            System.out.println("Attention un " + this.nom + " vous attaque!!");
            int random = (int) (Math.random() * 6);
            System.out.println( this.nom + " fait une attaque!");
            hero.ptsDeVie -= random;
            System.out.println();
            System.out.println("Vous perdez " + random + " points de vie!");
            hero.mourir();

        }
    }

    }
