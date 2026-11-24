// Il n'y a pas assez de places : vol complet ou demande trop grande.
public class ConflitPlacesException extends ReservationException {
    public ConflitPlacesException(String message) {
        super(message);
    }
}
