import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PassagerTest {

    @Test
    void passagerStandardPaieLePrixDeBase() {
        Passager p = new PassagerStandard("ZARE", "Oumou", "P12345");
        assertEquals(300000, p.calculerReduction(300000), 0.01);
    }

    @Test
    void passagerVipPaieAvecLaReduction() {
        Passager p = new PassagerVIP("Traore", "Tariq", "P67890", 0.20);
        assertEquals(240000, p.calculerReduction(300000), 0.01);
    }

    @Test
    void polymorphismeLeVipPaieMoinsQueLeStandard() {
        Passager standard = new PassagerStandard("ZARE", "Oumou", "P1");
        Passager vip = new PassagerVIP("Traore", "Tariq", "P2", 0.20);
        assertTrue(vip.calculerReduction(300000) < standard.calculerReduction(300000));
    }

    @Test
    void lesGettersRenvoientLesBonnesValeurs() {
        Passager p = new PassagerStandard("ZARE", "Oumou", "P12345");
        assertEquals("ZARE", p.getNom());
        assertEquals("Oumou", p.getPrenom());
        assertEquals("P12345", p.getPasseport());
    }

    // ----- Invariants refusés par des exceptions -----

    @Test
    void reductionVipSuperieureAUnEstRefusee() {
        assertThrows(DonneeInvalideException.class, () -> new PassagerVIP("Traore", "Tariq", "P2", 1.5));
    }

    @Test
    void reductionVipNegativeEstRefusee() {
        assertThrows(DonneeInvalideException.class, () -> new PassagerVIP("Traore", "Tariq", "P2", -0.2));
    }

    @Test
    void passagerSansNomEstRefuse() {
        assertThrows(DonneeInvalideException.class, () -> new PassagerStandard("", "Oumou", "P1"));
    }
}
