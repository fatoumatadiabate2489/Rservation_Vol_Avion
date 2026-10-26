# Projet de réservation de vol

## 1. Présentation du projet

Ce projet est une application Java simple qui simule la réservation d'un
billet d'avion. Elle permet de créer un vol, d'enregistrer un passager,
de créer une réservation et de la confirmer lorsqu'une place est
disponible.

Le projet met en pratique les notions fondamentales de la programmation
orientée objet (POO) en Java : classes et objets, attributs privés,
constructeurs, méthodes et collaboration entre objets.

## 2. Objectifs

L'application permet de :

-   créer un vol et préciser ses villes de départ et d'arrivée ;
-   définir le prix de base et le nombre de places disponibles ;
-   enregistrer les informations d'un passager ;
-   créer une réservation associant un passager à un vol ;
-   confirmer la réservation si une place est disponible ;
-   afficher les informations du vol, du passager et du billet ;
-   consulter le nombre de places restantes après une réservation.

## 3. Structure du projet

``` text
ProjetReservationVol/
├── src/
│   ├── Passager.java
│   ├── Vol.java
│   ├── Reservation.java
│   └── Main.java
├── docs/
│   └── diagramme-classes.png
└── README.md
```

> Si les fichiers Java se trouvent actuellement à la racine du dépôt,
> vous pouvez soit les y laisser et adapter cette arborescence, soit les
> déplacer dans `src/`. Le chemin du diagramme dans ce README suppose
> que l'image est enregistrée dans `docs/diagramme-classes.png`.

## 4. Diagramme UML des classes

Le diagramme ci-dessous présente les attributs, les constructeurs, les
méthodes et les relations entre les trois classes du modèle. La classe
`Reservation` référence un objet `Vol` et un objet `Passager` : elle
utilise ces objets pour confirmer et afficher une réservation. Il n'y a
pas de relation directe entre `Vol` et `Passager` dans le code fourni.

![Uploading diagramme-classes.png…]()



## 5. Description des classes

### 5.1. Classe `Passager`

La classe `Passager` représente une personne qui souhaite voyager.

**Attributs privés :**

-   `nom : String` --- nom du passager ;
-   `prenom : String` --- prénom du passager ;
-   `passeport : String` --- numéro de passeport.

**Constructeur :**

-   `Passager(String nom, String prenom, String passeport)` ---
    initialise les informations du passager.

**Méthode :**

-   `afficherPassager() : void` --- affiche le prénom, le nom et le
    numéro de passeport.

### 5.2. Classe `Vol`

La classe `Vol` représente un vol proposé aux passagers.

**Attributs privés :**

-   `numeroVol : String` --- numéro du vol ;
-   `villeDepart : String` --- ville de départ ;
-   `villeArrivee : String` --- ville d'arrivée ;
-   `prixBase : double` --- prix de base du billet, en FCFA dans
    l'exemple ;
-   `placesDisponibles : int` --- nombre de places encore disponibles.

**Constructeur :**

-   `Vol(String numeroVol, String villeDepart, String villeArrivee, double prixBase, int placesDisponibles)`
    --- initialise les informations du vol.

**Méthodes :**

-   `reserverPlace() : boolean` --- retire une place si le nombre de
    places disponibles est supérieur à zéro et renvoie `true`; sinon,
    affiche un message et renvoie `false` ;
-   `afficherVol() : void` --- affiche les informations du vol ;
-   `getPrixBase() : double` --- renvoie le prix de base.

### 5.3. Classe `Reservation`

La classe `Reservation` représente une réservation pour un passager et
un vol.

**Attributs privés :**

-   `numeroBillet : String` --- numéro du billet ;
-   `vol : Vol` --- objet représentant le vol réservé ;
-   `passager : Passager` --- objet représentant le passager ;
-   `estConfirmee : boolean` --- indique si la réservation est
    confirmée.

**Constructeur :**

-   `Reservation(String numeroBillet, Vol vol, Passager passager)` ---
    associe le billet au vol et au passager, puis initialise son état à
    `false` (non confirmé).

**Méthodes :**

-   `confirmerReservation() : void` --- demande au vol de réserver une
    place et confirme la réservation si l'opération réussit ;
-   `afficherBillet() : void` --- affiche le numéro du billet, les
    informations du passager, celles du vol et le statut de la
    réservation.

## 6. Déroulement de l'exemple

La classe `Main` exécute le scénario de démonstration suivant :

1.  Création du vol `AF720`, de Ouagadougou à Paris, au prix de 450 000
    FCFA, avec deux places disponibles.
2.  Création du passager Fatoumata Diabaté.
3.  Création de la réservation `TKT-001`.
4.  Tentative de confirmation de la réservation.
5.  Affichage du billet et du nombre de places restantes.

Si la réservation est confirmée, le nombre de places disponibles passe
de deux à une.

## 7. Exemple de résultat attendu

``` text
--- État du vol ---
Vol AF720 : Ouagadougou -> Paris | Prix : 450000.0 FCFA | Places restantes : 2

--- Réservation ---
Réservation TKT-001 confirmée avec succès !

--- Détails du billet ---
=== BILLET D'AVION ===
Billet N° : TKT-001
Passager : Fatoumata Diabaté (Passeport : B1234567)
Vol AF720 : Ouagadougou -> Paris | Prix : 450000.0 FCFA | Places restantes : 1
Statut : CONFIRMÉ
======================

--- État du vol après réservation ---
Vol AF720 : Ouagadougou -> Paris | Prix : 450000.0 FCFA | Places restantes : 1
```

La mise en forme exacte dépend des instructions d'affichage présentes
dans la version de `Main.java` utilisée.

## 8. Concepts de programmation utilisés

-   **Encapsulation :** les attributs sont déclarés `private` afin de
    limiter leur accès direct depuis les autres classes.
-   **Constructeurs :** ils initialisent les objets au moment de leur
    création.
-   **Objets :** le programme crée des instances de `Vol`, `Passager` et
    `Reservation`.
-   **Collaboration entre objets :** `Reservation` possède des
    références vers un `Vol` et un `Passager`, qu'elle utilise pour
    réaliser ses opérations.
-   **Condition :** `reserverPlace()` vérifie la disponibilité d'une
    place avant de la retirer.
       ## 9. Choix de conception

**Choix 1 --- Séparer le vol, le passager et la réservation.**\
Chaque classe représente un concept distinct et possède une
responsabilité identifiable. La réservation relie le passager au vol
sans créer de relation directe entre `Vol` et `Passager`.

**Choix 2 --- Garder les attributs privés.**\
Les attributs sont déclarés `private`, ce qui applique le principe
d'encapsulation. Dans cette première version, le prix de base peut être
consulté avec `getPrixBase()` et la disponibilité est modifiée par
`reserverPlace()`.

## 10. Difficulté rencontrée et amélioration possible

Une difficulté consiste à maintenir la cohérence entre le nombre de
places disponibles et le statut de la réservation. La méthode
`confirmerReservation()` s'appuie sur le résultat de `reserverPlace()`
pour éviter de confirmer une réservation lorsque le vol est complet.

Cette première version pourrait être renforcée en vérifiant les valeurs
reçues par les constructeurs (par exemple, un prix négatif ou un nombre
de places négatif) et en empêchant la confirmation répétée d'une même
réservation. Ces améliorations pourront être réalisées dans une étape
ultérieure du projet.

## 11. Membres et contributions

  -----------------------------------------------------------------------
  Membre                              Contribution
  ----------------------------------- -----------------------------------
  **ZARE Mouhammad Ridwane Lamine**   Développement de la classe
                                      `Passager` et réalisation du
                                      diagramme UML.

  **DIABATE Fatoumata**               Développement de la classe `Vol`.

  **TRAORE HOUD Tariq Ramadan Togo**  Développement de la classe
                                      `Reservation`.

  **OUALBEOGO Julie**                 Rédaction du `README.md` et
                                      développement de la classe `Main`.
  -----------------------------------------------------------------------

## 12. Technologies utilisées

-   **Langage :** Java 17 ;
-   **Paradigme :** programmation orientée objet ;
-   **Outils possibles :** IntelliJ IDEA, Eclipse, NetBeans ou Visual
    Studio Code ;
-   **Gestion du code :** Git et GitHub.

## 13. Conclusion

Ce projet propose une première simulation de réservation de billets
d'avion. Il montre comment plusieurs classes Java peuvent collaborer :
`Passager` représente le voyageur, `Vol` décrit le trajet et ses places
disponibles, et `Reservation` relie le passager au vol et gère la
confirmation. La classe `Main` permet de lancer un scénario simple et
d'observer le résultat.
