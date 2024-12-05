package junit.monprojet;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SommeArgentTest {
    private SommeArgent m12CHF;
    private SommeArgent m14CHF;
    private SommeArgent m14USD;
    private int count=0;

    @Before
    public void setUp() {
        count++;
        m12CHF = new SommeArgent(12, "CHF");
        m14CHF = new SommeArgent(14, "CHF");
        m14USD = new SommeArgent(14, "USD");
    }

    @Test
    public void testAddition() throws UniteDistincteException {
        SommeArgent expected = new SommeArgent(26, "CHF");
        SommeArgent result = m12CHF.add(m14CHF);

        Assert.assertTrue(expected.equals(result));
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(!m12CHF.equals(null)); 
        Assert.assertEquals(m12CHF, m12CHF); 
        Assert.assertEquals(m12CHF, new SommeArgent(12, "CHF")); 
        Assert.assertTrue(!m12CHF.equals(m14CHF)); 
        Assert.assertTrue(!m14USD.equals(m14CHF)); 
    }

    @Test(expected = UniteDistincteException.class)
    public void testAdditionWithDifferentCurrencies() throws UniteDistincteException {
        SommeArgent m10USD = new SommeArgent(10, "USD");

        m12CHF.add(m10USD); // Should throw an exception
    }

    @After
    public void tearDown() {
        
        System.out.println("Passage APRES exécution d'une méthode de test" + count);
    }
}
