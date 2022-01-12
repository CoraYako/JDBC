package estancias.servicios;

import estancias.entidades.Cliente;
import estancias.persistencia.ClienteDAO;
import java.util.Collection;

public final class ClienteServicio {

    private final ClienteDAO clienteDAO;
    
    public ClienteServicio() {
        clienteDAO = new ClienteDAO();
    }
    
    public Collection<Cliente> listarClientesQueAlquilaron() throws Exception {
        try {
            Collection<Cliente> clientes = clienteDAO.listarClientesQueAlquilaron();
            
            return clientes;
        } catch (Exception e) {
            throw e;
        }
    }
    
}
