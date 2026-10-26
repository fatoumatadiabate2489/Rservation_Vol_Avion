public class Reservation {
    protected String numeroBillet;
    protected Vol vol;
    protected Passager passager;
    protected boolean estConfirmee;

    public Reservation(String numeroBillet, Vol vol, Passager passager) {
        this.numeroBillet = numeroBillet;
        this.vol = vol;
        this.passager = passager;
        this.estConfirmee = false;
    }

    public void confirmerReservation() {
        if (vol.reserverPlace()) {
            this.estConfirmee = true;
            System.out.println("Réservation " + numeroBillet + " confirmée avec succès !");
        } else {
            System.out.println("Échec de la réservation.");
        }
    }

    public void afficherBillet() {
        System.out.println("=== BILLET D'AVION ===");
        System.out.println("Billet N° : " + numeroBillet);
        passager.afficherPassager();
        vol.afficherVol();
        System.out.println("Statut : " + (estConfirmee ? "CONFIRMÉ" : "EN ATTENTE"));
        System.out.println("======================");
    }
}
