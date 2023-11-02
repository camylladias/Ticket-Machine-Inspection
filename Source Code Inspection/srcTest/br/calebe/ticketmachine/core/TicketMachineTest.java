package br.calebe.ticketmachine.core;
import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import org.junit.Test;
import static org.junit.Assertions.*;


class TicketMachineTest {

    @Test
    void testConstructor() {
        TicketMachine machine = new TicketMachine(50);
        assertEquals(0, machine.getSaldo());
    }

    @Test
    void testInserirValido() throws PapelMoedaInvalidaException, PapelMoedaInvalidaException {
        TicketMachine machine = new TicketMachine(50);
        machine.inserir(10);
        assertEquals(10, machine.getSaldo());
    }

    @Test
    void testInserirInvalido() {
        TicketMachine machine = new TicketMachine(50);
        assertThrows(PapelMoedaInvalidaException.class, () -> {
            machine.inserir(3); // Valor inválido
        });
    }

    @Test
    void testImprimirSaldoSuficiente() throws SaldoInsuficienteException, PapelMoedaInvalidaException, SaldoInsuficienteException {
        TicketMachine machine = new TicketMachine(50);
        machine.inserir(50);
        assertNotNull(machine.imprimir());
    }

    @Test
    void testImprimirSaldoInsuficiente() {
        TicketMachine machine = new TicketMachine(50);
        assertThrows(SaldoInsuficienteException.class, () -> {
            machine.imprimir();
        });
    }
}