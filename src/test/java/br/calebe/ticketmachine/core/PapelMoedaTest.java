package br.calebe.ticketmachine.core;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

class PapelMoedaTest {

    @Test
    void testConstructor() {
        PapelMoeda papelMoeda = new PapelMoeda(10, 5);
        assertEquals(10, papelMoeda.getValor());
        assertEquals(5, papelMoeda.getQuantidade());
    }
}
