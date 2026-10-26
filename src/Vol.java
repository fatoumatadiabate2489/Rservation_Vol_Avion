public class Vol {
    private String numeroVol;
    private String villeDepart;
    private String villeArrivee;
    private double prixBase;
    private int placesDisponibles;

    public Vol(String numeroVol, String villeDepart, String villeArrivee, double prixBase, int placesDisponibles) {
        this.numeroVol = numeroVol;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.prixBase = prixBase;
        this.placesDisponibles = placesDisponibles;
    }

    public boolean reserverPlace() {
        if (placesDisponibles > 0) {
            placesDisponibles--;
            return true;
        } else {
            System.out.println("Plus de places disponibles !");
            return false;
        }
    }

    public void afficherVol() {
        System.out.println("Vol " + numeroVol + " : " + villeDepart + " -> " + villeArrivee + " | Prix : " + prixBase + " FCFA | Places restantes : " + placesDisponibles);
    }

    public double getPrixBase() {
        return prixBase;
    }
}
