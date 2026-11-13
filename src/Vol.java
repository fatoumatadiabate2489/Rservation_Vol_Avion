public class Vol implements Reservable {
    private String numeroVol;
    private String villeDepart;
    private String villeArrivee;
    private double prixBase;
    private int placesDisponibles;

    public Vol(String numeroVol, String villeDepart, String villeArrivee, double prixBase, int placesDisponibles) {
        if (numeroVol == null || numeroVol.equals("")) {
            System.out.println("Le numéro de vol est obligatoire.");
        }
        if (prixBase <= 0) {
            System.out.println("Le prix doit être supérieur à 0.");
        }
        if (placesDisponibles < 0) {
            System.out.println("Le nombre de places disponibles ne peut pas être négatif.");
        }
        this.numeroVol = numeroVol;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.prixBase = prixBase;
        this.placesDisponibles = placesDisponibles;
    }

    public String getNumeroVol() {
        return numeroVol;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public String getVilleArrivee() {
        return villeArrivee;
    }

    public int getPlacesDisponibles() {
        return placesDisponibles;
    }

    public double getPrixBase() {
        return prixBase;
    }

    // --- Méthodes de l'interface Reservable ---

    @Override
    public boolean estDisponible() {
        return placesDisponibles > 0;
    }

    @Override
    public boolean reserver(int nombrePlaces) {
        if (nombrePlaces <= 0) {
            System.out.println("-> [REFUSÉ] Nombre de places invalide : " + nombrePlaces);
            return false;
        }
        if (placesDisponibles >= nombrePlaces) {
            placesDisponibles = placesDisponibles - nombrePlaces;
            System.out.println("-> [SUCCÈS] " + nombrePlaces + " place(s) réservée(s) sur le vol " + numeroVol);
            return true;
        }
        System.out.println("-> [REFUSÉ] Vol complet ou pas assez de places. Restant : " + placesDisponibles);
        return false;
    }

    @Override
    public void annuler(int nombrePlaces) {
        if (nombrePlaces > 0) {
            placesDisponibles = placesDisponibles + nombrePlaces;
            System.out.println("-> [ANNULATION] " + nombrePlaces + " place(s) remise(s) sur le vol " + numeroVol);
        } else {
            System.out.println("-> [REFUSÉ] Nombre de places à annuler invalide : " + nombrePlaces);
        }
    }

    public void afficherVol() {
        System.out.println("Vol " + numeroVol + " : " + villeDepart + " -> " + villeArrivee
                + " | Prix : " + prixBase + " FCFA | Places restantes : " + placesDisponibles);
    }
}


