import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int testsReussis = 0;

        // Une liste pour ranger les vols
        List<Vol> catalogueVols = new ArrayList<>();
        Vol volNormal = new Vol("VOL101", "Ouagadougou", "Paris", 300000, 2);
        Vol volLimite = new Vol("VOL999", "Ouaga", "Bobo", 50000, 1);
        catalogueVols.add(volNormal);
        catalogueVols.add(volLimite);

        // TEST 1 : un vol disponible
        System.out.println("--- Test 1 : vol disponible ---");
        boolean reservation1 = volNormal.reserver(1);
        if (volNormal.estDisponible() && reservation1 && volNormal.getPlacesDisponibles() == 1) {
            System.out.println("[TEST 1 SUCCES] Vol disponible, réservation réussie.");
            testsReussis++;
        } else {
            System.out.println("[TEST 1 ECHEC]");
        }

        // TEST 2 : un vol complet
        System.out.println("\n--- Test 2 : vol complet ---");
        volLimite.reserver(1); // on prend la dernière place
        boolean reservation2 = volLimite.reserver(1); // il n'y a plus de place
        if (!volLimite.estDisponible() && !reservation2) {
            System.out.println("[TEST 2 SUCCES] Vol complet, réservation bloquée.");
            testsReussis++;
        } else {
            System.out.println("[TEST 2 ECHEC]");
        }

        // TEST 3 : une réservation refusée (0 place demandée)
        System.out.println("\n--- Test 3 : réservation refusée ---");
        boolean reservation3 = volNormal.reserver(0);
        if (!reservation3) {
            System.out.println("[TEST 3 SUCCES] Réservation refusée (nombre de places invalide).");
            testsReussis++;
        } else {
            System.out.println("[TEST 3 ECHEC]");
        }

        // Affichage de la liste
        System.out.println("\n--- État des vols ---");
        for (Vol v : catalogueVols) {
            v.afficherVol();
        }

        System.out.println("\nBILAN : " + testsReussis + "/3 tests réussis");
    }
}
