import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReservationTest {

    @Test
    void uneReservationNEstPasConfirmeeAuDebut() {
        Vol vol = new Vol("VOL101", "Ouagadougou", "Paris", 300000, 2);
        Passager p = new PassagerStandard("ZARE", "Oumou", "P12345");
        Reservation res = new Reservation("RES-001", vol, p);
        assertFalse(res.isEstConfirmee());
        assertEquals(2, vol.getPlacesDisponibles());
    }

    @Test
    void confirmerPrendUnePlaceSurLeVol() {
        Vol vol = new Vol("VOL101", "Ouagadougou", "Paris", 300000, 2);
        Passager p = new PassagerStandard("ZARE", "Oumou", "P12345");
        Reservation res = new Reservation("RES-001", vol, p);
        res.confirmerReservation();
        assertTrue(res.isEstConfirmee());
        assertEquals(1, vol.getPlacesDisponibles());
    }

    @Test
    void annulerRemetLaPlaceEtRepasseEnAttente() {
        Vol vol = new Vol("VOL101", "Ouagadougou", "Paris", 300000, 2);
        Passager p = new PassagerStandard("ZARE", "Oumou", "P12345");
        Reservation res = new Reservation("RES-001", vol, p);
        res.confirmerReservation();
        res.annulerReservation();
        assertFalse(res.isEstConfirmee());
        assertEquals(2, vol.getPlacesDisponibles());
    }

    @Test
    void lePrixFinalDuVipTientCompteDeLaReduction() {
        Vol vol = new Vol("VOL101", "Ouagadougou", "Paris", 300000, 2);
        Passager vip = new PassagerVIP("Traore", "Tariq", "P67890", 0.20);
        Reservation res = new Reservation("RES-002", vol, vip);
        assertEquals(240000, res.getPrixFinal(), 0.01);
    }

    @Test
    void laReservationEstLieeAuBonVolEtAuBonPassager() {
        Vol vol = new Vol("VOL101", "Ouagadougou", "Paris", 300000, 2);
        Passager p = new PassagerVIP("Traore", "Tariq", "P67890", 0.20);
        Reservation res = new Reservation("RES-002", vol, p);
        assertSame(vol, res.getVol());
        assertSame(p, res.getPassager());
        assertEquals("RES-002", res.getNumeroBillet());
    }

    // ----- Cas d'échec : exception ET état vérifié après -----

    @Test
    void confirmerSurUnVolCompletLanceConflitEtLaReservationResteNonConfirmee() {
        Vol vol = new Vol("VOL999", "Ouaga", "Bobo", 50000, 0);
        Passager p = new PassagerStandard("ZARE", "Oumou", "P12345");
        Reservation res = new Reservation("RES-003", vol, p);
        assertThrows(ConflitPlacesException.class, () -> res.confirmerReservation());
        assertFalse(res.isEstConfirmee());
        assertEquals(0, vol.getPlacesDisponibles());
    }

    @Test
    void confirmerDeuxFoisLanceUneExceptionEtNePrendQuUnePlace() {
        Vol vol = new Vol("VOL101", "Ouagadougou", "Paris", 300000, 2);
        Passager p = new PassagerStandard("ZARE", "Oumou", "P12345");
        Reservation res = new Reservation("RES-001", vol, p);
        res.confirmerReservation();
        assertThrows(ReservationException.class, () -> res.confirmerReservation());
        assertTrue(res.isEstConfirmee());
        assertEquals(1, vol.getPlacesDisponibles());
    }

    @Test
    void annulerUneReservationNonConfirmeeLanceUneExceptionEtNeChangeRien() {
        Vol vol = new Vol("VOL101", "Ouagadougou", "Paris", 300000, 2);
        Passager p = new PassagerStandard("ZARE", "Oumou", "P12345");
        Reservation res = new Reservation("RES-001", vol, p);
        assertThrows(ReservationException.class, () -> res.annulerReservation());
        assertEquals(2, vol.getPlacesDisponibles());
    }

    @Test
    void reservationSansVolEstRefusee() {
        Passager p = new PassagerStandard("ZARE", "Oumou", "P12345");
        assertThrows(DonneeInvalideException.class, () -> new Reservation("RES-009", null, p));
    }
}
