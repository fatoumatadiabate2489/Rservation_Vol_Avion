// Une donnée n'est pas acceptable : prix négatif, nom vide, 0 place demandée...
public class DonneeInvalideException extends ReservationException {
    public DonneeInvalideException(String message) {
        super(message);
    }
}
