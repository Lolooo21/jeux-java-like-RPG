package personnages;

import objet.*;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;


public class Heros {
    int ptsDeVie = 100;
    int ptsEndurance = 100;
    int ptsDeMagie = 100;
    int niveau = 1;
    int nombrePtsExperience = 0;
    int Force = 10;
    int Intelligence = 8;
    int agilite = 10;
    Arme arme = new Arme("Epée rouilléé", 10, 1, 2, 100,1);
    Armure armure = new Armure("tissu",8,2,6,100,1);
    PotiondeVie potionPv = new PotiondeVie("potionPV",20,1,2);
    PotionDeMagie potionPm = new PotionDeMagie("PotionPM",20,1,2);
    public ArrayList<Objet> inventaire = new ArrayList<>();
    String nom;
    private boolean vivant = true;

    int or = 20;

    //Contsructeur
    public Heros(String nom) {
        inventaire.add(potionPv);
        inventaire.add(potionPm);
        this.nom = nom;
    }

    public void attaquer(Ennemis nom) {
        if (nom.vivant) {
            if (this.ptsEndurance < (50 - this.agilite)) {
                System.out.println();
                System.out.println("Vous ne pouvez pas attaquer... pas assez d'endurance!");
            } else {
                this.ptsEndurance -= (50 - this.agilite);
                int random = (int) (Math.random() * 4);
                if (this.arme == null) {
                    nom.ptsDeVie -= (int) (this.Force * 0.5);
                } else {
                    this.arme.setDurabilite(this.arme.getDurabilite() - random);
                    nom.ptsDeVie -= this.Force * 0.5 + (int) (this.arme.getValAttaque());
                }
                System.out.println();
                System.out.println("Aiguise moi ça! , vous perdez " + (this.agilite - 50) + " points d'Endurance!");
                System.out.println("Vous infligez " + this.Force * 0.5 + (int) (this.arme.getValAttaque()) + " de dégat!");
            }
            nom.mourir(this);

        }
    }

    public void lancerUnSort(Ennemis nom) {
        if (nom.vivant) {
            if (this.ptsDeMagie < (50 - this.Intelligence)) {
                System.out.println();
                System.out.println("Vous ne pouvez pas lancer de sort... vous êtes à court de PM ");
            } else {
                this.ptsDeMagie -= (50 - this.Intelligence);
                nom.ptsDeVie -= (this.Intelligence * 0.25);
                System.out.println();
                System.out.println("Par les météores de Pégase !!!! yaaaa !! Vous perdez " + (this.Intelligence - 50) + " points de Magie");
                System.out.println("Vous infligez " + this.Intelligence * 0.25 + " de dégat magique!");
            }
            nom.mourir(this);

        }
    }

    public void seReposer() {
        this.ptsEndurance = 100;
        System.out.println();
        System.out.println("Vous êtes reposé");
        if (this.ptsEndurance > 100) {
            this.ptsEndurance = 100;
            System.out.println();
            System.out.println("Points d'endurance au maximum!");
        }
    }

    public void boireUnePotionDeSoin() {
        System.out.println("Attention vos PV sont bas! Buvez une potion de vie! ");
        if (this.potionPv.quantite <= 0){
            System.out.println("quantité insuffisante !!");
            this.potionPv.quantite = 0;
        }else{
            this.potionPv.quantite -=1;
            this.ptsDeVie += 50;
            System.out.println();
            System.out.println("Vous buvez une potion de soin...");
            System.out.println("Vous récupérez 50pts de vie");
            if (this.ptsDeVie > 100) {
                this.ptsDeVie = 100;
                System.out.println();
                System.out.println("Points de vie au maximum!");
            }

        }
    }

    public void boireUnePotionDeMagie() {
        System.out.println(" Attention vos PM sont bas! Buvez une potion de magie!");
        if (this.potionPm.quantite <= 0){
            System.out.println("quantité insuffisante !!");
            this.potionPm.quantite = 0;
        }else{
            this.potionPm.quantite -=1;
            this.ptsDeMagie += 50;
            System.out.println();
            System.out.println("Vous buvez une potion de magie...");
            System.out.println("Vous récupérez 50pts de magie");
            if (this.ptsDeMagie > 100) {
                this.ptsDeMagie = 100;
                System.out.println();
                System.out.println("Points de magie au maximum!");
            }

        }
    }

    public void gagnerExperience(int exp) {
        if (exp < 0) {
            System.out.println("pas de valeur négatives!");
        } else {
            this.nombrePtsExperience += exp;
            while (this.nombrePtsExperience >= this.niveau * 50) {
                this.nombrePtsExperience -= this.niveau * 50;
                this.monterNiveau();

            }
        }
    }

    public void caracteristiquesHero() {
        System.out.println();
        System.out.println("STATUT " + this.nom);
        System.out.println(" - Points de vie = " + this.ptsDeVie);
        System.out.println(" - Points d'endurance = " + this.ptsEndurance);
        System.out.println(" - Points de magie = " + this.ptsDeMagie);
        System.out.println(" - Niveau = " + this.niveau);
        System.out.println(" - Exp = " + this.nombrePtsExperience);
        System.out.println(" - Force = " + this.Force);
        System.out.println(" - Intelligence = " + this.Intelligence);
        System.out.println(" - Agilité = " + this.agilite);
        System.out.println(" - Arme équipée = " + this.arme.nom);
        System.out.println(" - Durabilité de l'arme " + this.arme.getDurabilite());

    }

    public void monterNiveau() {
        System.out.println();
        System.out.println("félicitations vous êtes au niveau supérieur !!!!");
        this.niveau++;
        this.ptsDeMagie = 100;
        this.ptsEndurance = 100;
        this.ptsDeVie = 100;
        int random = (int) (Math.random() * 3);
        if (random == 0) {
            this.Force += 1;
            System.out.println("+1 points de Force!");
        } else if (random == 1) {
            this.agilite += 1;
            System.out.println("+1 points d'Agilité!");
        } else if (random == 2) {
            this.Intelligence += 1;
            System.out.println("+1 points d'intelligence!");
        }
        this.caracteristiquesHero();
    }

    public void mourir() {
        if (this.ptsDeVie <= 0) {
            System.out.println();
            System.out.println("YOU DIED");
            System.out.println("Vous perdez toute votre progression et votre inventaire mwhahahahahaha!");
            this.vivant = false;
            this.reset();

        }
    }

    public void reset() {
        this.ptsDeVie = 100;
        this.ptsEndurance = 100;
        this.ptsDeMagie = 100;
        this.niveau = 1;
        this.nombrePtsExperience = 0;
        this.Force = 20;
        this.Intelligence = 20;
        this.agilite = 20;
        this.or = 0;
        ArrayList<String> inventaire = new ArrayList<String>();
        this.vivant = true;

    }

    public void combatCac(Ennemis nom) {
        System.out.println();
        System.out.println("Un combat commence!");
        while (true) {
            nom.attaque(this);
            this.attaquer(nom);
            if (!nom.vivant) {
                break;
            } else if (!this.vivant) {
                break;
            }
            if (this.ptsEndurance < (50 - this.agilite)) {
                System.out.println();
                System.out.println("Vous ne pouvez pas attaquer... pas assez d'endurance!");
                this.seReposer();
            }
            if (this.ptsDeVie <= 10) {
                this.boireUnePotionDeSoin();
            }

        }
    }

    public void combatMagique(Ennemis nom) {
        System.out.println();
        System.out.println("Attention un " + nom.nom + " vous attaque!!");
        while (true) {
            nom.attaque(this);
            this.lancerUnSort(nom);
            caracteristiquesHero();
            nom.caracteristiqueEnnemi();
            if (!nom.vivant) {
                break;
            } else if (!this.vivant) {
                break;
            }
            if (this.ptsDeMagie < (50 - this.Intelligence)) {
                System.out.println();
                System.out.println("Vous ne pouvez pas lancer de sort... vous êtes à court de PM");
                this.boireUnePotionDeMagie();
            }
            if (this.ptsDeVie <= 20) {
                this.boireUnePotionDeSoin();
            }

        }
    }

    //INVENTAIRE
    public void loot(Objet objet,int or) {
        //if (this.inventaire.contains(objet)){
            //this.inventaire.get(this.inventaire.indexOf(objet)).quantite++;
        //}else{
            this.inventaire.add(objet);
            this.or = this.or + or;
        //}


    }

    public void retirerObjet (Objet objet){
        this.inventaire.remove(objet);
    }

    public void afficheInventaire() {
        System.out.println();
        System.out.println("INVENTAIRE contient " + this.inventaire.size() + " objets");
        addPoidsInventaire();
        System.out.println("Vous possédez " + this.or + " pièces d'or");
        for (Objet objet : this.inventaire) {
            //if (this.inventaire.contains(objet)){
                //this.inventaire.get(this.inventaire.indexOf(objet)).quantite++;}
            System.out.println();
            System.out.println("NOM            GOLD       POIDS     QUANTITE");
            System.out.print(objet.nom);
            System.out.print("      " + objet.or);
            System.out.print("        " + objet.poids + "kg");
            System.out.println("        " + objet.quantite);
        }
    }

    public void addPoidsInventaire() {
        int i = 0;
        for (Objet objet : this.inventaire) {
            i += objet.poids;
        }
        System.out.println("Poid de l'inventaire = " + i + " Kg");
    }

   /* public void addQuantite() {
        int q = 0;
        for (Objet objet : this.inventaire){
            if (objet == objet){
                objet.quantite+=1;
            }
        }
    }*/

    //ARME
    public void equipeArme(Arme epee) {
        this.arme = epee;

    }

    public void equipeArme() {
        this.arme = null;

    }

    public void changerArme(Arme nouvelle) {
        System.out.println(this.arme.nom + " ajoutée à l'inventaire");
        this.inventaire.add(this.arme);
        this.inventaire.remove(nouvelle);
        this.equipeArme(nouvelle);
        System.out.println(nouvelle.nom + " est équipée!");

    }

    public void triInventaire(ArrayList<Objet> objet) {
        ArrayList<Arme> armes = new ArrayList<>();
        System.out.println();
        System.out.println();
        System.out.println("Merci de choisir une Arme : ");
        for (Objet i : objet) {
            if (i instanceof Arme) {
                armes.add((Arme)i);
            }
        }
        int i = 1;
        for (Arme arme : armes) {
            System.out.println();
            System.out.println(" - " + i + " " + arme.nom);
            i += 1;
        }
        Scanner scanner = new Scanner(System.in);
        int choix = scanner.nextInt();
        if (choix < 1 || choix > i){
            System.out.println("Gros nullos");
        }else{
            this.changerArme(armes.get(choix - 1));

        }

    }

    public void recupArme(){
        triInventaire(this.inventaire);

    }

    public void equipeArmure(Armure armure) {
        this.armure = armure;

    }

    public void equipeArmure() {
        this.armure = null;

    }

    //ARMURE
    public void changerArmure(Armure nouvelle) {
        System.out.println(this.armure.nom + " ajoutée à l'inventaire");
        this.inventaire.add(this.armure);
        this.inventaire.remove(nouvelle);
        this.equipeArmure(nouvelle);
        System.out.println(nouvelle.nom + " est équipée!");

    }

    public void triInventaire1(ArrayList<Objet> objet) {
        ArrayList<Armure> armures = new ArrayList<>();
        System.out.println();
        System.out.println();
        System.out.println("Merci de choisir une Armure : ");
        for (Objet i : objet) {
            if (i instanceof Armure) {
                armures.add((Armure)i);
            }
        }
        int i = 1;
        for (Armure armure : armures) {
            System.out.println();
            System.out.println(" - " + i + " " + armure.nom);
            i += 1;
        }
        Scanner scanner = new Scanner(System.in);
        int choix = scanner.nextInt();
        if (choix < 1 || choix > i){
            System.out.println("Gros nullos");
        }else{
            this.changerArmure(armures.get(choix - 1));
        }


    }

    public void recupArmure(){
        triInventaire1(this.inventaire);

    }



}
