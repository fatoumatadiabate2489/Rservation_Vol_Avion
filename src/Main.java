public class Main {
    public static void main(String[] args) {

        // Création du vol
        Vol vol1 = new Vol( "AF720", "Ouagadougou","Paris", 450000,2);
        // Création du passager
        Passager passager1 = new Passager( "Diabaté","Fatoumata","B1234567" );

        // Affichage de l'état initial du vol
        System.out.println("--- État du vol ---");
        vol1.afficherVol();

        // Création de la réservation
        System.out.println("\n--- Réservation ---");
        Reservation res1 = new Reservation("TKT-001",vol1,passager1);
      
        // Confirmation de la réservation
        res1.confirmerReservation();

        // Affichage du billet
        System.out.println("\n--- Détails du billet ---");
        res1.afficherBillet();

        // Affichage de l'état du vol après réservation
        System.out.println("\n--- État du vol après réservation ---");
        vol1.afficherVol();
    }
}
