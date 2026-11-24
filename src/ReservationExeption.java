// Erreur de base pour tout ce qui peut mal se passer dans une réservation.
// Elle sert aussi directement pour les erreurs d'état
// (confirmer deux fois, annuler ce qui n'est pas confirmé).
public class ReservationException extends RuntimeException {
    public ReservationException(String message) {
        super(message);
    }
}
