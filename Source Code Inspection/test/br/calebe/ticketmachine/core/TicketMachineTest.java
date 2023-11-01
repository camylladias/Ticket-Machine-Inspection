import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
package br.calebe.ticketmachine.core;

class TicketMachineTest {

    @Test
    void testConstructor() {
        TicketMachine machine = new TicketMachine(50);
        assertEquals(0, machine.getSaldo());
    }

    @Test
    void testInserirValido() throws PapelMoedaInvalidaException {
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
    void testImprimirSaldoSuficiente() throws SaldoInsuficienteException {
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
