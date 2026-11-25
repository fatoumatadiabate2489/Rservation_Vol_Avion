public interface Reservable {
    // Réserve des places.
    // Lance DonneeInvalideException si nombrePlaces <= 0.
    // Lance ConflitPlacesException s'il n'y a pas assez de places.
    // Dans les deux cas, rien n'est modifié.
    void reserver(int nombrePlaces);

    // Remet des places en stock.
    // Lance DonneeInvalideException si nombrePlaces <= 0.
    void annuler(int nombrePlaces);

    boolean estDisponible();
}
