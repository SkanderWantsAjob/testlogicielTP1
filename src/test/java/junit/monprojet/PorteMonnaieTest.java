package junit.monprojet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PorteMonnaieTest {
    private PorteMonnaie porteMonnaie1;
    private PorteMonnaie porteMonnaie2;

    @Before
    public void setUp() {
        porteMonnaie1 = new PorteMonnaie();
        porteMonnaie2 = new PorteMonnaie();
    }

    @Test
    public void testAjouteSomme() {
        SommeArgent euro1 = new SommeArgent(5, "EUR");
        SommeArgent euro2 = new SommeArgent(5, "EUR");

        porteMonnaie1.ajouteSomme(euro1);
        porteMonnaie1.ajouteSomme(euro2);

        Assert.assertEquals(10, (int) porteMonnaie1.getContenu().get("EUR"));
    }

    @Test
    public void testToString() {
        SommeArgent euro1 = new SommeArgent(5, "EUR");
        porteMonnaie1.ajouteSomme(euro1);

        Assert.assertEquals("Porte-Monnaie: EUR : 5", porteMonnaie1.toString());
    }

    @Test
    public void testEquals() {
        SommeArgent euro1 = new SommeArgent(5, "EUR");
        SommeArgent euro2 = new SommeArgent(5, "EUR");

        porteMonnaie1.ajouteSomme(euro1);
        porteMonnaie2.ajouteSomme(euro2);

        Assert.assertTrue(porteMonnaie1.equals(porteMonnaie2));
    }

    @Test
    public void testEqualsDifferentContent() {
        SommeArgent euro1 = new SommeArgent(5, "EUR");
        SommeArgent dollar1 = new SommeArgent(10, "USD");

        porteMonnaie1.ajouteSomme(euro1);
        porteMonnaie2.ajouteSomme(dollar1);

        Assert.assertFalse(porteMonnaie1.equals(porteMonnaie2));
    }
}
