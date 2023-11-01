import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
package br.calebe.ticketmachine.core;

class PapelMoedaTest {

    @Test
    void testConstructor() {
        PapelMoeda papelMoeda = new PapelMoeda(10, 5);
        assertEquals(10, papelMoeda.getValor());
        assertEquals(5, papelMoeda.getQuantidade());
    }
}
