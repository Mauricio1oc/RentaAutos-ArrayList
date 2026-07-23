package datos;

import java.util.ArrayList;
import logica.Cliente;

public class ClienteStore {

    private ArrayList<Cliente> listaClientes;

    public ClienteStore() {
        listaClientes = new ArrayList<>();
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public boolean cedulaExiste(int cedula, int indiceIgnorado) {

        for (int i = 0; i < listaClientes.size(); i++) {

            Cliente cliente = listaClientes.get(i);

            if (i != indiceIgnorado
                    && cliente.getCedula() == cedula) {

                return true;
            }
        }

        return false;
    }

    public boolean insertar(Cliente cliente) {

        if (cliente == null) {
            return false;
        }

        if (cedulaExiste(cliente.getCedula(), -1)) {
            return false;
        }

        listaClientes.add(cliente);
        return true;
    }

    public boolean editar(int indice, Cliente cliente) {

        if (cliente == null) {
            return false;
        }

        if (indice < 0 || indice >= listaClientes.size()) {
            return false;
        }

        if (cedulaExiste(cliente.getCedula(), indice)) {
            return false;
        }

        listaClientes.set(indice, cliente);
        return true;
    }

    public boolean eliminar(int indice) {

        if (indice < 0 || indice >= listaClientes.size()) {
            return false;
        }

        listaClientes.remove(indice);
        return true;
    }

    public Cliente buscarPorCedula(int cedula) {

        for (Cliente cliente : listaClientes) {

            if (cliente.getCedula() == cedula) {
                return cliente;
            }
        }

        return null;
    }

    public int buscarIndicePorCedula(int cedula) {

        for (int i = 0; i < listaClientes.size(); i++) {

            if (listaClientes.get(i).getCedula() == cedula) {
                return i;
            }
        }

        return -1;
    }

    public ArrayList<Cliente> buscar(String texto) {

        ArrayList<Cliente> resultados = new ArrayList<>();

        if (texto == null || texto.trim().isEmpty()) {
            resultados.addAll(listaClientes);
            return resultados;
        }

        String filtro = texto.trim().toLowerCase();

        for (Cliente cliente : listaClientes) {

            String cedula = String.valueOf(cliente.getCedula());
            String nombre = cliente.getNombre().toLowerCase();
            String telefono = cliente.getTelefono().toLowerCase();
            String direccion = cliente.getDireccion().toLowerCase();

            if (cedula.contains(filtro)
                    || nombre.contains(filtro)
                    || telefono.contains(filtro)
                    || direccion.contains(filtro)) {

                resultados.add(cliente);
            }
        }

        return resultados;
    }

    public int cantidadClientes() {
        return listaClientes.size();
    }
}
