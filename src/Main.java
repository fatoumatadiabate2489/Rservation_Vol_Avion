public class Main {
    public static void main(String[] args) {

        Vol vol1 = new Vol( "AF720", "Ouagadougou","Paris", 450000,2);
        Passager passager1 = new Passager( "Diabaté","Fatoumata","B1234567" );

        System.out.println("--- État du vol ---");
        vol1.afficherVol();

        System.out.println("\n--- Réservation ---");
        Reservation res1 = new Reservation("TKT-001",vol1,passager1);
      
        res1.confirmerReservation();

        System.out.println("\n--- Détails du billet ---");
        res1.afficherBillet();

        System.out.println("\n--- État du vol après réservation ---");
        vol1.afficherVol();
    }
}
