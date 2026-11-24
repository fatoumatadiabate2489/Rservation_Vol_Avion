import java.util.ArrayList;
import java.util.List;

// Point d'entrée pour réserver et annuler.
// Il garde la liste des vols et la liste des réservations.
// Règle importante : une réservation n'est ajoutée à la liste QUE si la place
// a bien été prise. Après une erreur, rien n'est enregistré à moitié.
public class ServiceReservation {
    private List<Vol> vols;
    private List<Reservation> reservations;

    public ServiceReservation() {
        this.vols = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    public void ajouterVol(Vol vol) {
        if (vol == null) {
            throw new DonneeInvalideException("Le vol est obligatoire.");
        }
        for (Vol v : vols) {
            if (v.getNumeroVol().equals(vol.getNumeroVol())) {
                throw new DonneeInvalideException("Le numéro de vol " + vol.getNumeroVol() + " existe déjà.");
            }
        }
        vols.add(vol);
    }

    public Vol chercherVol(String numeroVol) {
        for (Vol v : vols) {
            if (v.getNumeroVol().equals(numeroVol)) {
                return v;
            }
        }
        throw new RessourceAbsenteException("Vol introuvable : " + numeroVol);
    }

    public Reservation reserver(String numeroBillet, String numeroVol, Passager passager) {
        if (numeroBillet == null || numeroBillet.trim().isEmpty()) {
            throw new DonneeInvalideException("Le numéro de billet est obligatoire.");
        }
        if (passager == null) {
            throw new DonneeInvalideException("Le passager est obligatoire.");
        }
        for (Reservation r : reservations) {
            if (r.getNumeroBillet().equals(numeroBillet)) {
                throw new DonneeInvalideException("Le billet " + numeroBillet + " existe déjà.");
            }
        }

        Vol vol = chercherVol(numeroVol);                 // peut lancer RessourceAbsenteException
        Reservation reservation = new Reservation(numeroBillet, vol, passager);
        reservation.confirmerReservation();               // peut lancer ConflitPlacesException
        reservations.add(reservation);                    // seulement si tout a réussi
        return reservation;
    }

    public void annuler(String numeroBillet) {
        Reservation reservation = chercherReservation(numeroBillet);
        reservation.annulerReservation();
        reservations.remove(reservation);
    }

    public Reservation chercherReservation(String numeroBillet) {
        for (Reservation r : reservations) {
            if (r.getNumeroBillet().equals(numeroBillet)) {
                return r;
            }
        }
        throw new RessourceAbsenteException("Billet introuvable : " + numeroBillet);
    }

    public int nombreReservations() {
        return reservations.size();
    }

    // On renvoie une COPIE de la liste : l'extérieur ne peut pas modifier la liste interne
    public List<Vol> getVols() {
        return new ArrayList<>(vols);
    }
}
