public class Reservation {
    private String numeroBillet;
    private Vol vol;
    private Passager passager;
    private boolean estConfirmee;

    public Reservation(String numeroBillet, Vol vol, Passager passager) {
        if (numeroBillet == null || numeroBillet.trim().isEmpty()) {
            throw new DonneeInvalideException("Le numéro de billet est obligatoire.");
        }
        if (vol == null || passager == null) {
            throw new DonneeInvalideException("Une réservation a besoin d'un vol et d'un passager.");
        }
        this.numeroBillet = numeroBillet;
        this.vol = vol;
        this.passager = passager;
        this.estConfirmee = false;
    }

    // Confirme la réservation et prend une place sur le vol.
    // Si le vol est complet, vol.reserver lance ConflitPlacesException :
    // on n'arrive donc jamais à la ligne "estConfirmee = true" et l'état reste cohérent.
    public void confirmerReservation() {
        if (estConfirmee) {
            throw new ReservationException("La réservation " + numeroBillet + " est déjà confirmée.");
        }
        vol.reserver(1);
        this.estConfirmee = true;
    }

    // Annule une réservation confirmée et remet la place sur le vol.
    public void annulerReservation() {
        if (!estConfirmee) {
            throw new ReservationException("La réservation " + numeroBillet + " n'est pas confirmée.");
        }
        vol.annuler(1);
        this.estConfirmee = false;
    }

    // Prix réellement payé par ce passager (réduction VIP comprise)
    public double getPrixFinal() {
        return passager.calculerReduction(vol.getPrixBase());
    }

    public void afficherBillet() {
        System.out.println("=== BILLET D'AVION ===");
        System.out.println("Billet N° : " + numeroBillet);
        passager.afficherPassager();
        vol.afficherVol();
        System.out.println("Prix à payer : " + getPrixFinal() + " FCFA");
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
