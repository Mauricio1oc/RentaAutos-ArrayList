package logica;

import java.time.LocalDate;

public class Reserva {

    private int numReserva;
    private LocalDate fechaReserva;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private int cantDias;
    private double precioDia;
    private double impuesto;
    private double total;

    public Reserva() {
        this.numReserva = 0;
        this.fechaReserva = null;
        this.cliente = null;
        this.vehiculo = null;
        this.cantDias = 0;
        this.precioDia = 0;
        this.impuesto = 0;
        this.total = 0;
    }

    public Reserva(int numReserva, LocalDate fechaReserva,
            Cliente cliente, Vehiculo vehiculo,
            int cantDias, double precioDia,
            double impuesto, double total) {

        this.numReserva = numReserva;
        this.fechaReserva = fechaReserva;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.cantDias = cantDias;
        this.precioDia = precioDia;
        this.impuesto = impuesto;
        this.total = total;
    }

    public int getNumReserva() {
        return numReserva;
    }

    public void setNumReserva(int numReserva) {
        this.numReserva = numReserva;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public int getCantDias() {
        return cantDias;
    }

    public void setCantDias(int cantDias) {
        this.cantDias = cantDias;
    }

    public double getPrecioDia() {
        return precioDia;
    }

    public void setPrecioDia(double precioDia) {
        this.precioDia = precioDia;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double calcularSubtotal() {
        return cantDias * precioDia;
    }

    public double calcularImpuesto() {
        return calcularSubtotal() * 0.13;
    }

    public double calcularTotal() {
        return calcularSubtotal() + calcularImpuesto();
    }

    @Override
    public String toString() {
        return "Reserva #" + numReserva;
    }
}