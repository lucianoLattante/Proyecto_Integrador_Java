package tests;

import integrador.Practica;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

public class EggTest {

    private Practica pr;

    public EggTest() {
        this.pr = new Practica();
    }

    @Test
    public void prisioneroDulceTest() {
        assertEquals(3, pr.prisioneroDulce(0, 10, 6));
        assertEquals(2, pr.prisioneroDulce(7, 4, 8));
        assertEquals(1, pr.prisioneroDulce(1, 5, 2));
        assertEquals(0, pr.prisioneroDulce(0, 10, 1));
        assertEquals(39, pr.prisioneroDulce(455, 1585, 500));
    }

    @Test
    public void prisioneroDulceWrapsAtTheEndOfTheCircle() {
        assertEquals(0, pr.prisioneroDulce(0, 7, 6));
        assertEquals(0, pr.prisioneroDulce(5, 2, 6));
        assertEquals(2, pr.prisioneroDulce(3, 6, 6));
        assertEquals(Integer.MAX_VALUE - 2,
                pr.prisioneroDulce(Integer.MAX_VALUE - 1, Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    @Test
    public void prisioneroDulceRejectsInvalidRounds() {
        invalida(-1, 1, 6);
        invalida(6, 1, 6);
        invalida(0, 0, 6);
        invalida(0, 1, 0);
    }

    private void invalida(int inicio, int caramelos, int ladrones) {
        try {
            pr.prisioneroDulce(inicio, caramelos, ladrones);
            org.junit.Assert.fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            // Invalid input has no final recipient.
        }
    }

    @Test
    public void mediasAmigasTest() {

        ArrayList<String> medias = new ArrayList(Arrays.asList(new String[]{"A", "B", "C", "D", "A", "C", "D", "A"}));
        ArrayList<String> expected = new ArrayList(Arrays.asList(new String[]{"A", "C", "D"}));
        assertEquals(expected, pr.mediasAmigas(medias));
        medias = new ArrayList(Arrays.asList(new String[]{"R", "R", "A", "A", "S", "S", "G", "H"}));
        expected = new ArrayList(Arrays.asList(new String[]{"A", "R", "S"}));
        assertEquals(expected, pr.mediasAmigas(medias));
        medias = new ArrayList(Arrays.asList(new String[]{"R", "E", "T", "A", "P", "S", "G", "H"}));
        expected = new ArrayList();
        assertEquals(expected, pr.mediasAmigas(medias));
    }

    @Test
    public void numeroCapicuaTest() {
        assertEquals(true, pr.numeroCapicua(123454321));
        assertEquals(true, pr.numeroCapicua(-123454321));
        assertEquals(true, pr.numeroCapicua(2));
        assertEquals(true, pr.numeroCapicua(0));
        assertEquals(false, pr.numeroCapicua(null));
        assertEquals(false, pr.numeroCapicua(231));
        assertEquals(false, pr.numeroCapicua(123));
        assertEquals(false, pr.numeroCapicua(Integer.MAX_VALUE));
    }
}
