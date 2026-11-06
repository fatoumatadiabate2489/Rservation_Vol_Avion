## Système de réservation de vols

Application Java console modélisant la réservation de billets d'avion. Le projet met en œuvre les principes de la programmation orientée objet : héritage, abstraction, polymorphisme, encapsulation et composition.

## Table des matières

1.	Présentation
2.	Concepts de POO illustrés
3.	Structure du projet
4.	Description des classes
5.	Compilation et exécution
6.	Jeu de tests
7.	Limites connues et évolutions possibles
   
## Présentation
Le système permet de :
•	définir des vols (trajet, prix de base, nombre de places disponibles) ;
•	gérer deux catégories de passagers (standard et VIP) ;
•	calculer le prix d'un billet selon la catégorie du passager ;
•	créer et confirmer des réservations, avec gestion de la disponibilité des places ;
•	afficher un billet récapitulatif.
Les prix sont exprimés en francs CFA (FCFA).

## Concepts de POO illustrés
•	Abstraction : Passager est une classe abstraite qui déclare la méthode calculerReduction.
•	Héritage : PassagerStandard et PassagerVIP étendent Passager.
•	Polymorphisme : calculerReduction produit un résultat différent selon le type de passager.
•	Encapsulation : les attributs sont private ou protected et accessibles par des accesseurs.
•	Composition : une Reservation associe un Vol et un Passager.

## Structure du projet
.
├── Passager.java           Classe abstraite (nom, prénom, passeport)
├── PassagerStandard.java   Passager sans réduction
├── PassagerVIP.java        Passager avec taux de réduction
├── Vol.java                Vol (trajet, prix de base, places)
├── Reservation.java        Réservation liant un vol et un passager
└── Main.java               Programme principal et tests manuels

## Description des classes

Passager (classe abstraite)
Classe de base représentant un passager.
•	Attributs protégés : nom, prenom, passeport.
•	Accesseurs : getNom(), getPrenom(), getPasseport().
•	afficherPassager() : affiche l'identité et le numéro de passeport.
•	calculerReduction(double prixBase) : méthode abstraite retournant le prix final, implémentée par les sous-classes.
Le constructeur signale par un message console un nom ou un prénom vide.

PassagerStandard
Passager sans avantage tarifaire. La méthode calculerReduction retourne le prix de base inchangé.

PassagerVIP
Passager bénéficiant d'un taux de réduction fourni à la construction (par exemple 0.20 pour 20 %).
Prix final : prixBase × (1 − reduction)
Vol

## Représente un vol et la disponibilité de ses places.
•	Attributs : numeroVol, villeDepart, villeArrivee, prixBase, placesDisponibles.
•	reserverPlace() : décrémente le nombre de places et retourne true ; retourne false si le vol est complet.
•	afficherVol() : affiche le trajet, le prix et le nombre de places restantes.
•	Accesseurs : getNumeroVol(), getVilleDepart(), getVilleArrivee(), getPrixBase(), getPlacesDisponibles().
Le constructeur contrôle que le numéro de vol n'est pas vide, que le prix est strictement positif et que le nombre de places n'est pas négatif.

## Reservation
Associe un vol et un passager sous un numéro de billet.
•	Attributs : numeroBillet, vol, passager, estConfirmee (faux à la création).
•	confirmerReservation() : réserve une place sur le vol et met à jour l'état en cas de succès.
•	afficherBillet() : affiche le billet avec le statut CONFIRMÉ ou EN ATTENTE.
•	Accesseurs : getNumeroBillet(), getVol(), getPassager(), isEstConfirmee().

## Main
Point d'entrée de l'application. Exécute la série de tests décrite ci-dessous et affiche le bilan.
Compilation et exécution
Prérequis : Java Development Kit (JDK) 8 ou version ultérieure.
Compilation :
bash
javac *.java
Exécution :
bash
java Main

## Jeu de tests
La classe Main exécute huit tests manuels :
1.	Création d'un vol : l'objet est créé.
2.	Création d'un passager standard : le nom correspond à la valeur fournie.
3.	Création d'un passager VIP : l'objet est créé.
4.	Polymorphisme : le prix standard est de 300 000 et le prix VIP de 240 000.
5.	Composition : la réservation est correctement liée au vol et au passager.
6.	Confirmation d'une réservation : le statut passe à confirmé.
7.	Affichage du billet : le billet est affiché (vérification visuelle).
8.	Vol complet : la réservation est refusée et le statut reste non confirmé.
   
## Sortie attendue en fin d'exécution :

=== BILAN : 8/8 TESTS REUSSIS ===
Limites connues et évolutions possibles
•	Les contrôles de validité des constructeurs affichent un message sans empêcher la création de l'objet. Le lancement d'une IllegalArgumentException constituerait une gestion d'erreurs plus rigoureuse.
•	Le prix final n'est pas enregistré dans la Reservation.
•	Il n'existe pas de fonctionnalité d'annulation avec libération de place.
•	Le taux de réduction VIP n'est pas contrôlé (il devrait être compris entre 0 et 1).
•	Les tests sont manuels ; une migration vers JUnit permettrait de les automatiser.





## Membres et contributions

  -----------------------------------------------------------------------
  Membre                              Contribution
  ----------------------------------- -----------------------------------
  **ZARE Mouhammad Ridwane Lamine**   Développement de la classe
                                      `Main` et réalisation du
                                      diagramme UML.

  **DIABATE Fatoumata**               Développement des classes `passager et passager vip`.

  **TRAORE HOUD Tariq Ramadan Togo**  Développement de la classe
                                      `réservation et passager standard`.

  **OUALBEOGO Julie**                 Rédaction du `README.md` et
                                      développement de la classe `Vol`.
  -----------------------------------------------------------------------

