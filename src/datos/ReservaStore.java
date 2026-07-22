package datos;

import java.util.ArrayList;
import logica.Reserva;

public class ReservaStore {

    private ArrayList<Reserva> listaReservas;
    private int siguienteNumero;

    public ReservaStore() {
        listaReservas = new ArrayList<>();
        siguienteNumero = 1;
    }

    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public int obtenerSiguienteNumero() {
        return siguienteNumero;
    }

    public boolean insertar(Reserva reserva) {

        if (reserva == null) {
            return false;
        }

        reserva.setNumReserva(siguienteNumero);
        siguienteNumero++;

        reserva.setImpuesto(reserva.calcularImpuesto());
        reserva.setTotal(reserva.calcularTotal());

        return listaReservas.add(reserva);
    }

    public boolean editar(int indice, Reserva reserva) {

        if (indice < 0 || indice >= listaReservas.size()
                || reserva == null) {
            return false;
        }

        int numeroActual = listaReservas.get(indice).getNumReserva();

        reserva.setNumReserva(numeroActual);
        reserva.setImpuesto(reserva.calcularImpuesto());
        reserva.setTotal(reserva.calcularTotal());

        listaReservas.set(indice, reserva);
        return true;
    }

    public boolean eliminar(int indice) {

        if (indice < 0 || indice >= listaReservas.size()) {
            return false;
        }

        listaReservas.remove(indice);
        return true;
    }

    public Reserva buscarPorNumero(int numero) {

        for (Reserva reserva : listaReservas) {
            if (reserva.getNumReserva() == numero) {
                return reserva;
            }
        }

        return null;
    }

    public int cantidadReservas() {
        return listaReservas.size();
    }
}