public class Main {
    public static void main(String[] args) {
        ServiceReservation service = new ServiceReservation();
        Vol vol1 = new Vol("VOL101", "Ouagadougou", "Paris", 300000, 2);
        service.ajouterVol(vol1);

        Passager pStd = new PassagerStandard("ZARE", "Oumou", "P12345");
        Passager pVip = new PassagerVIP("Traore", "Tariq", "P67890", 0.20);

        // ---------- SCENARIO NORMAL ----------
        System.out.println("=== SCENARIO : deux réservations réussies ===");
        Reservation r1 = service.reserver("RES-001", "VOL101", pStd);
        r1.afficherBillet();
        Reservation r2 = service.reserver("RES-002", "VOL101", pVip);
        r2.afficherBillet();
        System.out.println("Le vol est-il encore disponible ? " + vol1.estDisponible());

        // ---------- CAS D'ERREUR 1 : vol complet ----------
        // try = on essaie ; catch = si cette erreur arrive, on affiche un message au lieu de planter
        System.out.println("\n=== CAS D'ERREUR 1 : vol complet ===");
        try {
            service.reserver("RES-003", "VOL101", pStd);
            System.out.println("PROBLEME : la réservation aurait dû être refusée.");
        } catch (ConflitPlacesException e) {
            System.out.println("Refusé : " + e.getMessage());
        }
        System.out.println("Réservations enregistrées : " + service.nombreReservations() + " (inchangé)");

        // ---------- CAS D'ERREUR 2 : vol qui n'existe pas ----------
        System.out.println("\n=== CAS D'ERREUR 2 : vol inconnu ===");
        try {
            service.reserver("RES-004", "VOL000", pStd);
            System.out.println("PROBLEME : la réservation aurait dû être refusée.");
        } catch (RessourceAbsenteException e) {
            System.out.println("Refusé : " + e.getMessage());
        }

        // ---------- CAS D'ERREUR 3 : donnée invalide ----------
        System.out.println("\n=== CAS D'ERREUR 3 : 0 place demandée ===");
        try {
            vol1.reserver(0);
            System.out.println("PROBLEME : la demande aurait dû être refusée.");
        } catch (DonneeInvalideException e) {
            System.out.println("Refusé : " + e.getMessage());
        }

        // ---------- ANNULATION ----------
        System.out.println("\n=== ANNULATION de RES-002 ===");
        service.annuler("RES-002");
        vol1.afficherVol();
        System.out.println("Le vol est-il disponible ? " + vol1.estDisponible());
    }
}
