package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TicketMachineTest {

    @Test
    public void testConstructor() {
        TicketMachine machine = new TicketMachine(50);
        assertEquals(0, machine.getSaldo());
    }

    @Test(expected = PapelMoedaInvalidaException.class)
    public void testInserirInvalido() throws PapelMoedaInvalidaException {
        TicketMachine machine = new TicketMachine(50);
        machine.inserir(3);  // Valor inválido
    }

    @Test(expected = SaldoInsuficienteException.class)
    public void testImprimirSaldoInsuficiente() throws SaldoInsuficienteException {
        TicketMachine machine = new TicketMachine(50);
        machine.imprimir();
    }
}
