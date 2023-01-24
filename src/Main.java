import objet.Arme;
import objet.Armure;
import objet.Objet;
import objet.PotiondeVie;
import personnages.Ennemis;
import personnages.Heros;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Heros hero = new Heros("Leroooooy");
        Ennemis orc = new Ennemis("Orc",20);
        Ennemis gobelin = new Ennemis("Gobelin",10);
        Ennemis zombie = new Ennemis("Zombie",20);
        Ennemis murlocs = new Ennemis("Murlocs",15);
        Objet objet = new Objet("Casque ailé",260,6,1);
        Arme epee1 = new Arme("Excalibur",1000,5,100,100,1);
        Arme epee2 = new Arme("Zsword",500,10,50,100,1);
        Arme epee3 = new Arme("Masamune",700,3,70,100,1);
        Armure armure = new Armure("Tissu usé",5,1,5,100,1);
        Armure armure1 = new Armure("Cuir renforcé",20,3,15,100,1);
        Armure armure2 = new Armure("Mythril",200,5,50,100,1);

        hero.inventaire.add(epee1);
        hero.inventaire.add(epee2);
        hero.inventaire.add(epee3);
        hero.inventaire.add(objet);
        hero.inventaire.add(armure);
        hero.inventaire.add(armure1);
        hero.inventaire.add(armure2);

        hero.afficheInventaire();
        hero.recupArme();
        hero.recupArmure();
        hero.afficheInventaire();

        hero.combatCac(murlocs);
        hero.combatCac(zombie);
        hero.combatCac(orc);
        hero.afficheInventaire();




    }
}