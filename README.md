# Projet de Réservation de Vol 
1. Présentation du projet
Ce projet consiste à développer une application Java permettant de simuler un système simple de réservation de vol.

L'application permet de créer un vol, d'enregistrer les informations d'un passager, de créer une réservation, de vérifier la disponibilité d'une place et de confirmer la réservation.

Le projet met en pratique les principaux concepts de la programmation orientée objet en Java.

2. Membres du groupe et répartition du travail
OUALBEOGO Julie
A réalisé :

le fichier Main.java ;

le fichier README.md.

DIABATÉ Fatoumata
A réalisé :

la partie Vol.java.

ZARE Lamine
A réalisé :

la partie Passager.java ;

le diagramme UML.

TRAORE Houd Tariq
A réalisé :

la partie Reservation.java.

Chaque membre a contribué à une partie du projet afin de réaliser l'application complète de réservation de vol.

3. Objectifs du projet
Les objectifs principaux sont :

créer et gérer un vol ;

enregistrer les informations d'un passager ;

gérer les places disponibles ;

effectuer une réservation ;

confirmer une réservation lorsque le vol dispose encore de places ;

afficher les informations du billet ;

mettre en pratique la programmation orientée objet ;

représenter la structure du système avec un diagramme UML.

4. Structure du projet
ProjetReservationVol/
│
├── Passager.java
├── Vol.java
├── Reservation.java
├── Main.java
├── diagramme_UML.png
└── README.md

6. Description des classes
5.1 Passager.java
La classe Passager représente le passager qui effectue une réservation.

Elle contient trois attributs :

nom : nom du passager ;

prenom : prénom du passager ;

passeport : numéro de passeport.

La méthode afficherPassager() permet d'afficher les informations du passager.

Exemple :

Passager : Fatoumata Diabaté (Passeport : B1234567)
5.2 Vol.java
La classe Vol représente un vol disponible.

Elle contient :

numeroVol : numéro du vol ;

villeDepart : ville de départ ;

villeArrivee : ville d'arrivée ;

prixBase : prix du billet ;

placesDisponibles : nombre de places disponibles.

Les principales méthodes sont :

reserverPlace() : vérifie s'il reste une place et diminue le nombre de places disponibles lorsqu'une réservation est effectuée ;

afficherVol() : affiche les informations du vol ;

getPrixBase() : retourne le prix de base.

5.3 Reservation.java
La classe Reservation représente une réservation effectuée pour un passager sur un vol.

Elle contient :

numeroBillet : numéro du billet ;

vol : vol concerné ;

passager : passager concerné ;

estConfirmee : indique si la réservation est confirmée.

Les principales méthodes sont :

confirmerReservation() : vérifie la disponibilité d'une place et confirme la réservation si une place est disponible ;

afficherBillet() : affiche les informations du billet et son statut.

5.4 Main.java
La classe Main contient la méthode main() qui permet d'exécuter et de tester le programme.

Le programme :

crée un vol ;

crée un passager ;

affiche l'état initial du vol ;

crée une réservation ;

confirme la réservation ;

affiche le billet ;

affiche l'état du vol après la réservation.

6. Fonctionnement du programme
Le programme crée un vol avec les caractéristiques suivantes :

Numéro du vol : AF720

Ville de départ : Ouagadougou

Ville d'arrivée : Paris

Prix : 450000 FCFA

Nombre de places disponibles : 2

Un passager est ensuite créé avec les informations suivantes :

Nom : Diabaté

Prénom : Fatoumata

Passeport : B1234567

Une réservation portant le numéro TKT-001 est créée pour ce passager.

Lors de la confirmation, la méthode reserverPlace() vérifie si une place est disponible.

Comme le vol possède deux places disponibles au départ, la réservation est confirmée. Le nombre de places restantes passe alors de 2 à 1.

7. Diagramme UML
Le diagramme UML permet de représenter la structure du système et les relations entre les différentes classes.



Le diagramme présente notamment :

la classe Vol ;

la classe Passager ;

la classe Reservation ;

les classes PassagerVIP et PassagerStandard ;

les relations entre les classes ;

les multiplicités entre les objets.

Le diagramme permet ainsi de visualiser la conception générale du système de réservation de vol.

Remarque
Le diagramme UML présente une conception plus complète que les quatre classes Java actuellement fournies.

Les classes effectivement implémentées dans le code sont :

Passager ;

Vol ;

Reservation ;

Main.

Les classes PassagerVIP et PassagerStandard apparaissant dans le diagramme UML ne sont pas présentes dans les codes Java fournis dans cette version du projet.

8. Relations entre les classes
La classe Reservation est liée à la classe Passager et à la classe Vol.

Une réservation concerne donc :

un passager ;

un vol.

Le vol contient un nombre limité de places disponibles. Lorsqu'une réservation est confirmée, une place est retirée du nombre de places disponibles.

9. Concepts de programmation orientée objet utilisés
Encapsulation
Les attributs des classes sont déclarés private. Ils sont donc protégés et ne peuvent pas être directement manipulés depuis les autres classes.

Constructeurs
Les constructeurs permettent d'initialiser les objets lors de leur création.

Objets
Le programme crée plusieurs objets, notamment un objet Vol, un objet Passager et un objet Reservation.

Association
La classe Reservation utilise des objets Vol et Passager. Cela représente une association entre les classes.

Héritage et abstraction dans le diagramme UML
Le diagramme UML présente également une classe Passager pouvant être spécialisée en PassagerVIP et PassagerStandard.

Cette partie appartient à la conception UML présentée dans le projet et n'est pas encore implémentée dans les quatre fichiers Java fournis.

10. Exemple d'exécution
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
11. Technologies utilisées
Langage : Java

Paradigme : Programmation Orientée Objet (POO)

Modélisation : UML

Environnement de développement : Visual Studio Code, IntelliJ IDEA, Eclipse ou NetBeans

12. Conclusion
Ce projet permet de mettre en pratique les notions fondamentales de la programmation orientée objet à travers un système simple de réservation de vol.

La réalisation du projet a été répartie entre les différents membres du groupe. Chaque membre a participé à une partie du développement ou de la conception afin de construire l'application complète.

Le projet permet ainsi de comprendre comment plusieurs classes Java peuvent collaborer pour représenter un système réel composé de vols, de passagers et de réservations.
