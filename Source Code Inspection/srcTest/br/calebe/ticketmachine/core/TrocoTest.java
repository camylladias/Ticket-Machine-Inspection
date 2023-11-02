package br.calebe.ticketmachine.core;
import org.junit.Test;
import static org.junit.Assertions.*;


import java.util.Iterator;

public class TrocoTest {

    @Test
    public void testConstructor() {
        Troco troco = new Troco(72); // Exemplo de valor
        assertNotNull(troco.getIterator());
    }
}