import org.junit.Test;
import static org.junit.Assertions.*;
package br.calebe.ticketmachine.core;

import java.util.Iterator;

class TrocoTest {

    @Test
    void testConstructor() {
        Troco troco = new Troco(72); // Exemplo de valor
        assertNotNull(troco.getIterator());
    }
}