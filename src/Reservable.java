public interface Reservable {
    boolean reserver(int nombrePlaces);
    void annuler(int nombrePlaces);
    boolean estDisponible();
}
