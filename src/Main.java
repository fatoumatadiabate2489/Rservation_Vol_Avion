public class Main {
    public static void main(String[] args) {
        System.out.println("=== LANCEMENT DES 8 TESTS MANUELS (JALON 2) ===\n");

        int testsReussis = 0;

        // TEST 1 : Création d'un vol
        Vol vol1 = new Vol("VOL101", "Ouagadougou", "Paris", 300000, 2);
        if (vol1 != null) {
            System.out.println("[TEST 1 SUCCES] Vol créé avec succès.");
            testsReussis++;
        }

        // TEST 2 : Création d'un passager standard
        Passager pStd = new PassagerStandard("ZARE", "Oumou", "P12345");
        if (pStd.getNom().equals("Diabaté")) {
            System.out.println("[TEST 2 SUCCES] Passager standard créé.");
            testsReussis++;
        }

        // TEST 3 : Création d'un passager VIP
        PassagerVIP pVip = new PassagerVIP("Traore", "Tariq", "P67890", 0.20);
        if (pVip != null) {
            System.out.println("[TEST 3 SUCCES] Passager VIP créé.");
            testsReussis++;
        }

        // TEST 4 : Test Polymorphisme (calcul des prix)
        double prixStd = pStd.calculerReduction(vol1.getPrixBase());
        double prixVip = pVip.calculerReduction(vol1.getPrixBase());
        if (prixStd == 300000 && prixVip == 240000) {
            System.out.println("[TEST 4 SUCCES] Polymorphisme validé (Std = 300k, VIP = 240k).");
            testsReussis++;
        }

        // TEST 5 : Création d'une réservation (Composition)
        Reservation res1 = new Reservation("RES-001", vol1, pStd);
        if (res1.getVol() == vol1 && res1.getPassager() == pStd) {
            System.out.println("[TEST 5 SUCCES] Composition validée (vol et passager liés).");
            testsReussis++;
        }

        // TEST 6 : Confirmation de la réservation
        res1.confirmerReservation();
        if (res1.isEstConfirmee()) {
            System.out.println("[TEST 6 SUCCES] Réservation confirmée et statut mis à jour.");
            testsReussis++;
        }

        // TEST 7 : Affichage du billet (Vérification visuelle)
        System.out.println("\n[TEST 7] Affichage du billet :");
        res1.afficherBillet();
        testsReussis++;

        // TEST 8 : Vol complet (Vérification de la gestion des places)
        Vol volPlein = new Vol("VOL999", "Ouaga", "Bobo", 50000, 0);
        Reservation res3 = new Reservation("RES-003", volPlein, pStd);
        res3.confirmerReservation();
        if (!res3.isEstConfirmee()) {
            System.out.println("\n[TEST 8 SUCCES] Échec géré correctement : impossible de réserver un vol complet.");
            testsReussis++;
        }

        System.out.println("\n=== BILAN : " + testsReussis + "/8 TESTS REUSSIS ===");
    }
}
