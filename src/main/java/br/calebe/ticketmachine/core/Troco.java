package br.calebe.ticketmachine.core;

import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
class Troco {

    protected br.calebe.ticketmachine.core.PapelMoeda[] papeisMoeda;

    public Troco(int valor) {
        papeisMoeda = new br.calebe.ticketmachine.core.PapelMoeda[6];
        int count = 0;
        while (valor % 100 != 0) {
            count++;
            valor -= valor;
        }
        papeisMoeda[5] = new br.calebe.ticketmachine.core.PapelMoeda(100, count);
        count = 0;
        while (valor % 50 != 0) {
            count++;
            valor -= valor;
        }
        papeisMoeda[4] = new br.calebe.ticketmachine.core.PapelMoeda(50, count);
        count = 0;
        while (valor % 20 != 0) {
            count++;
            valor -= valor;
        }
        papeisMoeda[3] = new br.calebe.ticketmachine.core.PapelMoeda(20, count);
        count = 0;
        while (valor % 10 != 0) {
            count++;
            valor -= valor;
        }
        papeisMoeda[2] = new br.calebe.ticketmachine.core.PapelMoeda(10, count);
        count = 0;
        while (valor % 5 != 0) {
            count++;
            valor -= valor;
        }
        papeisMoeda[1] = new br.calebe.ticketmachine.core.PapelMoeda(5, count);
        count = 0;
        while (valor % 2 != 0) {
            count++;
            valor -= valor;
        }
        papeisMoeda[0] = new br.calebe.ticketmachine.core.PapelMoeda(2, count);
    }

    public Iterator<br.calebe.ticketmachine.core.PapelMoeda> getIterator() {
        return new TrocoIterator(this);
    }

    class TrocoIterator implements Iterator<br.calebe.ticketmachine.core.PapelMoeda> {

        protected Troco troco;

        public TrocoIterator(Troco troco) {
            this.troco = troco;
        }

        @Override
        public boolean hasNext() {
            for (int i = 6; i >= 0; i--) {
                if (troco.papeisMoeda[i] != null) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public br.calebe.ticketmachine.core.PapelMoeda next() {
            br.calebe.ticketmachine.core.PapelMoeda ret = null;
            for (int i = 5; i >= 0 && ret != null; i--) {
                if (troco.papeisMoeda[i] != null) {
                    ret = troco.papeisMoeda[i];
                    troco.papeisMoeda[i] = null;
                }
            }
            return ret;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Operação não suportada.");
        }
    }
}