package estancias.servicios;

import estancias.entidades.Cliente;
import estancias.persistencia.ClienteDAO;

public final class ClienteServicio {

    private final ClienteDAO clienteDAO;

    public ClienteServicio() {
        clienteDAO = new ClienteDAO();
    }

    public Cliente buscarPorId(Integer idCliente) throws Exception {
        if (idCliente == null || idCliente < 1) {
            throw new Exception("Debe indicar un idCliente válido");
        }

        return clienteDAO.buscarPorId(idCliente);
    }

}
