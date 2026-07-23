/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.time.LocalDate;

/**
 *
 * @author jonat
 */
public class Vehiculo {
    private String placa;
    private String marca;
    private String modelo;
    private String transmision;
    private int cilindraje;
    private LocalDate fechaCompra;

    public Vehiculo(String placa, String marca, String modelo, String transmision, int cilindraje, LocalDate fechaCompra) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.transmision = transmision;
        this.cilindraje = cilindraje;
        this.fechaCompra = fechaCompra;
    }
    
    public Vehiculo() {
        this.placa = "";
        this.marca = "";
        this.modelo = "";
        this.transmision = "";
        this.cilindraje = 0;
        this.fechaCompra = null;
    }  

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    @Override
    public String toString() {
        return placa + " - " + marca + " - " + modelo;
    }
    
}
