package br.calebe.ticketmachine.core;
import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import org.junit.Test;
import static org.junit.Assertions.*;


public class TicketMachineTest {

    @Test
    public void testConstructor() {
        TicketMachine machine = new TicketMachine(50);
        assertEquals(0, machine.getSaldo());
    }

    @Test
    public void testInserirValido() throws PapelMoedaInvalidaException, PapelMoedaInvalidaException {
        TicketMachine machine = new TicketMachine(50);
        machine.inserir(10);
        assertEquals(10, machine.getSaldo());
    }

    @Test
    public void testInserirInvalido() {
        TicketMachine machine = new TicketMachine(50);
        assertThrows(PapelMoedaInvalidaException.class, () -> {
            machine.inserir(3); // Valor inválido
        });
    }

    @Test
    public void testImprimirSaldoSuficiente() throws SaldoInsuficienteException, PapelMoedaInvalidaException, SaldoInsuficienteException {
        TicketMachine machine = new TicketMachine(50);
        machine.inserir(50);
        assertNotNull(machine.imprimir());
    }

    @Test
    public void testImprimirSaldoInsuficiente() {
        TicketMachine machine = new TicketMachine(50);
        assertThrows(SaldoInsuficienteException.class, () -> {
            machine.imprimir();
        });
    }
}