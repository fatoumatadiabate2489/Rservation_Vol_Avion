public class Vol implements Reservable {
    private String numeroVol;
    private String villeDepart;
    private String villeArrivee;
    private double prixBase;
    private int placesDisponibles;

    public Vol(String numeroVol, String villeDepart, String villeArrivee, double prixBase, int placesDisponibles) {
        if (numeroVol == null || numeroVol.trim().isEmpty()) {
            throw new DonneeInvalideException("Le numéro de vol est obligatoire.");
        }
        if (villeDepart == null || villeDepart.trim().isEmpty()
                || villeArrivee == null || villeArrivee.trim().isEmpty()) {
            throw new DonneeInvalideException("Les villes de départ et d'arrivée sont obligatoires.");
        }
        if (prixBase <= 0) {
            throw new DonneeInvalideException("Le prix doit être supérieur à 0.");
        }
        if (placesDisponibles < 0) {
            throw new DonneeInvalideException("Le nombre de places disponibles ne peut pas être négatif.");
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
    public void reserver(int nombrePlaces) {
        if (nombrePlaces <= 0) {
            throw new DonneeInvalideException("Nombre de places invalide : " + nombrePlaces);
        }
        if (nombrePlaces > placesDisponibles) {
            throw new ConflitPlacesException("Vol " + numeroVol + " : places insuffisantes (restant : "
                    + placesDisponibles + ", demandé : " + nombrePlaces + ")");
        }
        // On ne modifie les places qu'après avoir vérifié les deux règles
        placesDisponibles = placesDisponibles - nombrePlaces;
    }

    @Override
    public void annuler(int nombrePlaces) {
        if (nombrePlaces <= 0) {
            throw new DonneeInvalideException("Nombre de places à annuler invalide : " + nombrePlaces);
        }
        placesDisponibles = placesDisponibles + nombrePlaces;
    }

    public void afficherVol() {
        System.out.println("Vol " + numeroVol + " : " + villeDepart + " -> " + villeArrivee
                + " | Prix : " + prixBase + " FCFA | Places restantes : " + placesDisponibles);
    }
}
