public class Vol {
    private String numeroVol;
    private String villeDepart;
    private String villeArrivee;
    private double prixBase;
    private int placesDisponibles;

    public Vol(String numeroVol, String villeDepart, String villeArrivee, double prixBase, int placesDisponibles) {
        if (numeroVol==null|| numeroVol.equals("")){
            System.out.println("Le numero de vol est obligatoire.");
        }
        if (prixBase<=0){
            System.out.println("Le prix doit etre superieur à 0.");
        }
        if (placesDisponibles<0){
            System.out.println("Le nombre de places disponibles ne peut pas etre négatif.");
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

