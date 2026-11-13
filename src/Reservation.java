public class Reservation {
    private String numeroBillet;
    private Vol vol;
    private Passager passager;
    private boolean estConfirmee;

    public Reservation(String numeroBillet, Vol vol, Passager passager) {
        this.numeroBillet = numeroBillet;
        this.vol = vol;
        this.passager = passager;
        this.estConfirmee = false;
    }

    public void confirmerReservation() {
        if (estConfirmee) {
            System.out.println("Cette réservation est déjà confirmée.");
        } else if (vol.reserver(1)) {
            this.estConfirmee = true;
            System.out.println("Réservation " + numeroBillet + " confirmée avec succès !");
        } else {
            System.out.println("Échec de la réservation.");
        }
    }

    public void annulerReservation() {
        if (estConfirmee) {
            vol.annuler(1);
            this.estConfirmee = false;
            System.out.println("Réservation " + numeroBillet + " annulée.");
        } else {
            System.out.println("Cette réservation n'est pas confirmée, rien à annuler.");
        }
    }

    public void afficherBillet() {
        System.out.println("=== BILLET D'AVION ===");
        System.out.println("Billet N° : " + numeroBillet);
        passager.afficherPassager();
        vol.afficherVol();
        System.out.println("Prix à payer : " + passager.calculerReduction(vol.getPrixBase()) + " FCFA");
        System.out.println("Statut : " + (estConfirmee ? "CONFIRMÉ" : "EN ATTENTE"));
        System.out.println("======================");
    }

    // Getters
    public String getNumeroBillet() {
        return numeroBillet;
    }

    public Vol getVol() {
        return vol;
    }

    public Passager getPassager() {
        return passager;
    }

    public boolean isEstConfirmee() {
        return estConfirmee;
    }
}
