# jeux java like RPG
 AVA et POO – TP1 – Création de classes, instanciation d’objets, attributs, méthodes et constructeurs
Nous allons manipuler la conception de classes et toutes les notions associées. Pour cela, nous allons nous
lancer dans la réalisation d’un jeu vidéo (malheureusement (ou heureusement pour nous) sans interface
graphique). L’intérêt d’un tel exemple réside dans les nombreuses interactions qui peuvent exister entre les
différents composants du jeu : joueur, ennemis, objets… Ce projet sera le fil rouge de notre apprentissage
de la POO et sera progressivement amélioré au fur et à mesure des séances. Libre à vous d’aller plus loin
que ce qui est proposé et d’ajouter d’autres fonctionnalités auxquelles vous auriez pensé.
Quel que soit le langage que vous utilisez, n’oubliez de tester le plus souvent possible votre code ! Votre IDE
vous donne également des conseils précieux et vous signale les problèmes de syntaxe (soulignés entre
rouge) qui doivent être résolus immédiatement. On ne programme jamais de la bonne façon du premier
coup, n’hésitez pas à réarranger ou à réorganiser votre code souvent. C’est d’ailleurs ce que nous allons faire
pendant ce projet. Faites également attention à la façon de nommer les éléments (choisissez des noms qui
ont du sens) et prenez l’habitude de bien mettre une majuscule au début des classes et mettre les noms de
package en minuscules entre autres.
N’hésitez pas à afficher du texte dans vos méthodes pour avoir un retour sur toutes les actions que vous
effectuez.
Force et honneur !
1 – Création d’un personnage
Commençons par le plus important : le héros. Pour ce projet, je propose que l’on utilise des noms de
package, de classe, d’objet, de méthode et d’attribut en français. Créer un package personnages qui
regroupera tous les personnages que vous pourriez créer. Dans ce package, créer une classe Heros. Cette
classe devra avoir un constructeur permettant de spécifier le nom de votre héros. Il possèdera les
caractéristiques suivantes : un nombre de points de vie (entier), un nombre de points d’endurance (entier),
un nombre de points de magie (entier), un niveau (entier), un nombre de points d’expérience (entier), une
valeur de force (entier), une valeur d’intelligence (entier), une valeur d’agilité (entier), une arme équipée
(une chaîne de caractères pour le moment) et un inventaire (tableau dynamique de chaînes de caractères
pour le moment). Ces attributs seront initialisés automatiquement lors de la création du héros. Les
caractéristiques principales (force, intelligence et agilité) auront une valeur entre 0 et 20. Les points de vie,
d’endurance et de magie seront fixés à 100.
Ensuite, le héros pourra effectuer un certain nombre d’actions (dans la plupart de cas, ne remplir qu’avec
un « sout » rappelant ce que doit faire la méthode) :
- Attaquer (cela consomme de l’endurance),
- Lancer un sort (cela consomme de la magie),
- Se reposer (cela restaure l’endurance),
- Boire une potion de soin (cela restaure les points de vie),
- Boire une potion de magie (cela restaure les points de magie),
- Gagner de l’expérience,
- Monter de niveau (remarque : cette méthode devra être privée),
- Consulter son inventaire.
On créera aussi une méthode pour afficher toutes les caractéristiques essentielles du héros.
Les actions vertes peuvent être entièrement implémentées, les méthodes oranges seront complétées au fur
et à mesure de notre progression.
Par rapport aux actions listées ci-dessus, on s’attachera à réaliser précisément celles qui consistent à gagner
de l’expérience et à monter de niveau. En effet, gagner de l’expérience peut entrainer une montée de niveau.
Ainsi, la première méthode prendra comme paramètre un nombre de points d’expérience (entier) et
augmentera le niveau du héros si ce montant permet de dépasser le nombre de points d’expérience requis
pour monter d’un niveau, sinon il s’ajoutera simplement au nombre de points d’expérience actuel. Le héros
a besoin d’un nombre de points d’expérience égal à 50 x son niveau, c’est-à-dire qu’au niveau 1, le héros a
besoin de 50 points d’expérience pour monter niveau 2, qu’au niveau 2, le héros a besoin de 100 points
d’expérience pour monter niveau 3, etc. Si le nombre de points d’expérience est suffisant pour monter de
plusieurs niveaux, alors il le fait. La montée de niveau entraine le regain de tous ses points de vie,
d’endurance et de magie, ainsi que l’augmentation aléatoire d’une des caractéristiques principales (entre
force, intelligence et agilité). Pour cela, on pourra utiliser la méthode Math.random qui retourne un nombre
flottant entre 0 et 1.
Ensuite, on pourra réaliser facilement les autres actions vertes qui ne nécessitent pas de logique particulière.
Attention toutefois à ne pas dépasser les seuils de vie, d’endurance et de magie lorsqu’on les remonte.
Enfin, Attaquer et lancer un sort se contenteront dans un premier temps d’afficher le nombre de dégâts
infligés. Ce nombre sera calculé pour l’instant par rapport aux valeurs de force et d’intelligence,
respectivement. Le calcul est le suivant : pour attaquer, le nombre de dégâts infligés sera égal à 0.5 x la force
du héros et pour lancer un sort, le nombre de dégâts infligés sera égal à 0.25 x l’intelligence du héros. Ces
deux actions consomment des points d’endurance et de magie, respectivement. Le nombre de points
d’endurance requis pour effectuer une attaque est égal à 50 – l’agilité du héros et le nombre de points de
magie requis pour lancer un sort est égal à 50 – l’intelligence du héros. Évidemment, sans point d’endurance
ou de magie, impossible d’attaquer ou de lancer un sort, respectivement. Notre seul choix alors sera la fuite !
Notre héros semble être en état de fonctionner. J’espère que vous avez bien tester toutes les méthodes que
vous avez réalisées ainsi que tous les cas de figure (nombre de points d’expérience négatif par exemple…).
2 – Création d’un ennemi
Que serait-ce un héros sans un ennemi ? Vite, réparons ça ! Créer dans le package personnages une nouvelle
classe Ennemi. Cet ennemi sera instancié automatiquement, sans que nous ayons besoin de lui donner un
nom ou autre chose. Il possèdera les caractéristiques suivantes : un nombre de points de vie (entier), une
valeur d’attaque maximale (entier) et un nombre de points d’expérience octroyés au héros lors de sa mort.
Plutôt rudimentaire, mais suffisant pour le moment. Nous allons le faire combattre avec notre héros.
3 – Combat
Le combat se déroulera manuellement dans un premier temps, mais plus tard, la phase de combat se fera
automatiquement. Pour le moment, modifier les méthodes Attaquer et Lancer un sort pour qu’elles
prennent en paramètre un objet de la classe Ennemi. L’utilisation d’une de ces méthodes devra diminuer les
points de vie de l’ennemi d’un montant égal à la valeur calculée précédemment. Si l’ennemi se retrouve sans
point de vie, il meurt. Pour cela, modifier la classe Ennemi en rajoutant un attribut privé « vivant » (booléen)
et une méthode mourir qui change sa valeur (un setter en quelques sortes). Lors de sa mort, l’ennemi
transmet au héros les points d’expérience qu’il possède.
Bon, on n’est pas en mode bisounours nous, l’ennemi a quand même le droit d’attaquer. Ajouter une
méthode attaquer à la classe Ennemi qui prend en paramètre un objet de la classe Heros et qui diminue ses
points de vie d’un montant aléatoire inférieur ou égal à sa valeur d’attaque maximale. De la même manière,
ajouter l’attribut privé « vivant » et la méthode mourir au héros. Lorsqu’il meurt, le héros perd toute sa
progression (expérience, niveau, inventaire…) et son état est réinitialisé.
4 – Combat automatique
Passons à l’étape supérieure. Le combat doit être automatique, les attaques doivent s’enchaîner jusqu’à la
mort d’un des deux combattants. Ajouter à la classe Heros une méthode combat qui se chargera de cela. Elle
devra utiliser les méthodes attaquer des deux classes ainsi que les méthodes mourir quand nécessaire. On
pourra créer une seconde méthode pour effectuer le combat avec de la magie si on le souhaite.
Instancier 2-3 ennemis et lancer vous dans la bataille ! Buvez quelques potions pour restaurer vos points de
vie et de magie et repose-vous entre les combats.
5 – Inventaire
Pour l’instant, notre inventaire est rudimentaire. Les objets sont simplement des chaînes de caractères.
Remédions cela. Nous allons placer tous nos objets dans un package objets et y créer une classe Objet. Un
objet possèdera les caractéristiques suivantes : un nom (chaîne de caractères), une valeur en or (entier), un
poids (entier). Pour l’instant, on ne distingue pas les différents types d’objets (armes, armures,
consommables, etc.). Plus tard, il faudra considérer que les potions de vie ou de magie sont des
consommables et que nous n’en avons qu’un nombre limité. Et d’autres choses viendront se rajouter…
Modifier alors la classe Heros pour que son inventaire ne soit plus un tableau dynamique de chaînes de
caractères mais un tableau dynamique d’objets de la classe Objet. Il conviendra aussi de modifier la méthode
qui affiche l’inventaire pour détailler les différentes caractéristiques des objets. On spécifiera également le
poids total de notre inventaire et le nombre d’objets qu’il comporte.
Ensuite, on ajoutera à la classe Heros une méthode pour gagner un objet et une pour retirer un objet
particulier. On gagnera un nouvel objet à la fin de chaque combat. Cet objet est stocké dans un nouvel
attribut de la classe Ennemi sous le nom « loot ». Lors de sa mort, cet objet sera ajouté automatiquement à
notre inventaire.
Voilà, les premiers éléments ont été réalisés, nous avons bien manipulé les attributs et les méthodes. A
présent, nous allons commencer à utiliser l’héritage et créer des classes issues de la classe Objet pour
spécifier le type d’objet que nous possédons.
