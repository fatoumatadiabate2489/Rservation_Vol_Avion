import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ServiceReservationTest {

    private ServiceReservation creerService(int places) {
        ServiceReservation service = new ServiceReservation();
        service.ajouterVol(new Vol("VOL101", "Ouagadougou", "Paris", 300000, places));
        return service;
    }

    @Test
    void reserverEnregistreLaReservationEtPrendUnePlace() {
        ServiceReservation service = creerService(2);
        Passager p = new PassagerStandard("ZARE", "Oumou", "P12345");
        Reservation res = service.reserver("RES-001", "VOL101", p);
        assertTrue(res.isEstConfirmee());
        assertEquals(1, service.nombreReservations());
        assertEquals(1, service.chercherVol("VOL101").getPlacesDisponibles());
    }

    @Test
    void annulerRemetLaPlaceEtSupprimeLaReservation() {
        ServiceReservation service = creerService(2);
        Passager p = new PassagerStandard("ZARE", "Oumou", "P12345");
        service.reserver("RES-001", "VOL101", p);
        service.annuler("RES-001");
        assertEquals(0, service.nombreReservations());
        assertEquals(2, service.chercherVol("VOL101").getPlacesDisponibles());
    }

    @Test
    void chercherUnVolExistantLeRetrouve() {
        ServiceReservation service = creerService(2);
        assertEquals("VOL101", service.chercherVol("VOL101").getNumeroVol());
    }

    @Test
    void getVolsRenvoieUneCopieQuiNeModifiePasLeService() {
        ServiceReservation service = creerService(2);
        List<Vol> copie = service.getVols();
        copie.clear();
        assertEquals(1, service.getVols().size());
    }

    // ----- Cas d'échec : exception ET rien d'enregistré à moitié (atomicité) -----

    @Test
    void reserverSurUnVolCompletLanceConflitEtN_enregistreRien() {
        ServiceReservation service = creerService(1);
        Passager p = new PassagerStandard("ZARE", "Oumou", "P12345");
        service.reserver("RES-001", "VOL101", p);
        assertThrows(ConflitPlacesException.class, () -> service.reserver("RES-002", "VOL101", p));
        assertEquals(1, service.nombreReservations());
        assertEquals(0, service.chercherVol("VOL101").getPlacesDisponibles());
    }

    @Test
    void reserverSurUnVolInconnuLanceRessourceAbsenteEtN_enregistreRien() {
        ServiceReservation service = creerService(2);
        Passager p = new PassagerStandard("ZARE", "Oumou", "P12345");
        assertThrows(RessourceAbsenteException.class, () -> service.reserver("RES-001", "VOL000", p));
        assertEquals(0, service.nombreReservations());
        assertEquals(2, service.chercherVol("VOL101").getPlacesDisponibles());
    }

    @Test
    void unNumeroDeBilletDejaUtiliseEstRefuseSansPrendreDePlace() {
        ServiceReservation service = creerService(2);
        Passager p = new PassagerStandard("ZARE", "Oumou", "P12345");
        service.reserver("RES-001", "VOL101", p);
        assertThrows(DonneeInvalideException.class, () -> service.reserver("RES-001", "VOL101", p));
        assertEquals(1, service.nombreReservations());
        assertEquals(1, service.chercherVol("VOL101").getPlacesDisponibles());
    }

    @Test
    void annulerUnBilletInconnuLanceRessourceAbsente() {
        ServiceReservation service = creerService(2);
        assertThrows(RessourceAbsenteException.class, () -> service.annuler("RES-404"));
        assertEquals(2, service.chercherVol("VOL101").getPlacesDisponibles());
    }

    @Test
    void ajouterDeuxVolsAvecLeMemeNumeroEstRefuse() {
        ServiceReservation service = creerService(2);
        Vol doublon = new Vol("VOL101", "Bobo", "Abidjan", 80000, 3);
        assertThrows(DonneeInvalideException.class, () -> service.ajouterVol(doublon));
        assertEquals(1, service.getVols().size());
    }
}
