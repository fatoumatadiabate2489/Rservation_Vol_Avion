# Projet de Réservation de Vol

## Description

Ce projet est une application Java simple permettant de gérer une réservation de vol.

L'application permet de créer un vol, d'enregistrer les informations d'un passager, de créer une réservation et de confirmer cette réservation lorsqu'une place est disponible.

Le projet met en pratique les notions fondamentales de la programmation orientée objet (POO) en Java, notamment la création de classes, les attributs privés, les constructeurs, les méthodes et les relations entre objets.

## Objectif du projet

L'objectif est de simuler le fonctionnement d'un système simple de réservation de billets d'avion.

Le programme permet notamment de :

* créer un vol ;
* définir la ville de départ et la ville d'arrivée ;
* définir le prix du billet ;
* gérer le nombre de places disponibles ;
* enregistrer un passager ;
* créer une réservation ;
* confirmer une réservation si une place est disponible ;
* afficher les informations du billet ;
* afficher le nombre de places restantes après une réservation.

## Structure du projet

Le projet est composé de quatre classes principales :

```text
ProjetReservationVol/
│
├── Passager.java
├── Vol.java
├── Reservation.java
├── Main.java
└── README.md

## 1. Classe Passager

La classe `Passager` représente une personne qui souhaite effectuer une réservation.

Elle contient trois informations :

* `nom` : nom du passager ;
* `prenom` : prénom du passager ;
* `passeport` : numéro de passeport du passager.

### Méthode principale

`afficherPassager()` permet d'afficher les informations du passager.

Exemple :

```text
Passager : Fatoumata Diabaté (Passeport : B1234567)
```

## 2. Classe Vol

La classe `Vol` représente un vol disponible.

Elle contient les informations suivantes :

* `numeroVol` : numéro du vol ;
* `villeDepart` : ville de départ ;
* `villeArrivee` : ville d'arrivée ;
* `prixBase` : prix du billet ;
* `placesDisponibles` : nombre de places encore disponibles.

### Méthodes principales

`reserverPlace()` permet de réserver une place.

Si une place est disponible, le nombre de places disponibles est diminué de 1 et la méthode retourne `true`.

Si aucune place n'est disponible, un message est affiché et la méthode retourne `false`.

`afficherVol()` permet d'afficher les informations du vol.

`getPrixBase()` permet de récupérer le prix de base du vol.

## 3. Classe Reservation

La classe `Reservation` représente une réservation effectuée par un passager pour un vol.

Elle contient :

* `numeroBillet` : numéro du billet ;
* `vol` : vol concerné par la réservation ;
* `passager` : passager concerné ;
* `estConfirmee` : indique si la réservation est confirmée.

### Méthodes principales

`confirmerReservation()` permet de confirmer la réservation.

La méthode vérifie d'abord si une place est disponible dans le vol grâce à la méthode `reserverPlace()` de la classe `Vol`.

Si une place est disponible, la réservation est confirmée.

Sinon, la réservation échoue.

`afficherBillet()` permet d'afficher toutes les informations du billet, notamment le numéro du billet, le passager, le vol et le statut de la réservation.

## 4. Classe Main

La classe `Main` contient la méthode `main()` qui permet d'exécuter le programme.

Dans le programme principal :

1. Un vol `AF720` est créé.
2. Le vol part de Ouagadougou et arrive à Paris.
3. Le prix du billet est fixé à 450 000 FCFA.
4. Le vol possède initialement 2 places disponibles.
5. Un passager nommé Fatoumata Diabaté est créé.
6. Une réservation portant le numéro `TKT-001` est créée.
7. La réservation est confirmée.
8. Le billet est affiché.
9. Le nombre de places restantes est affiché.

## Exemple d'exécution

```text
===== ÉTAT INITIAL DU VOL =====
Vol AF720 : Ouagadougou -> Paris | Prix : 450000.0 FCFA | Places restantes : 2

===== RÉSERVATION =====
Réservation TKT-001 confirmée avec succès !

===== DÉTAILS DU BILLET =====
=== BILLET D'AVION ===
Billet N° : TKT-001
Passager : Fatoumata Diabaté (Passeport : B1234567)
Vol AF720 : Ouagadougou -> Paris | Prix : 450000.0 FCFA | Places restantes : 1
Statut : CONFIRMÉ
======================

===== ÉTAT DU VOL APRÈS RÉSERVATION =====
Vol AF720 : Ouagadougou -> Paris | Prix : 450000.0 FCFA | Places restantes : 1
```

## Concepts de programmation utilisés

Ce projet utilise plusieurs concepts de la programmation orientée objet :

### Encapsulation

Les attributs des classes sont déclarés `private`. Ils ne sont donc pas directement accessibles depuis les autres classes.

### Constructeurs

Les constructeurs permettent d'initialiser les objets lors de leur création.

### Objets

Le programme crée plusieurs objets, notamment un objet `Vol`, un objet `Passager` et un objet `Reservation`.

### Association entre objets

La classe `Reservation` est associée aux classes `Vol` et `Passager`.

Une réservation concerne donc :

* un passager ;
* un vol.

### Condition

Le programme utilise une condition pour vérifier si une place est disponible avant de confirmer la réservation.

## Technologies utilisées

* Langage : Java
* Paradigme : Programmation Orientée Objet (POO)
* Environnement possible : IntelliJ IDEA, Eclipse, NetBeans ou Visual Studio Code

## Conclusion

Ce projet constitue une simulation simple d'un système de réservation de vol.

Il permet de comprendre comment plusieurs classes peuvent collaborer dans une application Java. La classe `Passager` représente le client, la classe `Vol` représente le trajet disponible, la classe `Reservation` gère la réservation et la classe `Main` permet d'exécuter et de tester l'ensemble du système.
