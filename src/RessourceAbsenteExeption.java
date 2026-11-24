// On cherche quelque chose qui n'existe pas : vol ou billet introuvable.
public class RessourceAbsenteException extends ReservationException {
    public RessourceAbsenteException(String message) {
        super(message);
    }
}
