package estancias.principal;

import estancias.entidades.Casa;
import estancias.entidades.Cliente;
import estancias.entidades.Familia;
import estancias.servicios.CasaServicio;
import estancias.servicios.ClienteServicio;
import estancias.servicios.FamiliaServicio;
import java.sql.Date;
import java.util.Collection;

public class EstanciaMain {

    public static void main(String[] args) {

        ClienteServicio clienteServicio = new ClienteServicio();

        try {
            Collection<Cliente> clientes = clienteServicio.listarClientesQueAlquilaron();

            visualizarLista(clientes);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void visualizarLista(Collection col) {
        col.forEach((ob) -> System.out.println(ob + "\n"));
    }

}
