/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import logica.Vehiculo;

/**
 *
 * @author jonat
 */
public class VehiculoStore {
    private Vehiculo vectVeh[];
    private int numReg;
    
    public VehiculoStore(int tam){
        this.numReg = 0;
        this.vectVeh = new Vehiculo[tam];
        for (int i = 0; i < vectVeh.length; i++) {
           this.vectVeh[i] = new Vehiculo();
        }
    }

    public Vehiculo[] getVectVeh() {
        return vectVeh;
    }

    public int getNumReg() {
        return numReg;
    }
    
    public boolean estaLleno(){
        return this.numReg == this.vectVeh.length;
    }
    
    public boolean insertarVehiculo(Vehiculo veh){
        if (veh != null && !estaLleno()){
            //Se inserta el objeto vehículo
            this.vectVeh[numReg] = veh;
            this.numReg ++;
            return true;
        }
        return false;
    }
    
    public void eliminarVehiculo(int index){
        
        for (int i = index; i < this.numReg-1; i++) {
            vectVeh[i] = vectVeh[i+1]; 
        }
        this.numReg --;
    }
    
    public void editarVehiculo(Vehiculo veh, int index){
        if (index >= 0 && index < numReg){
            vectVeh[index] = veh;
        }
    }
}
