package estancias.servicios;

import estancias.entidades.Estancia;
import estancias.persistencia.EstanciaDAO;
import java.util.Collection;

public class EstanciaServicio {

    private final EstanciaDAO estanciaDAO;

    public EstanciaServicio() {
        estanciaDAO = new EstanciaDAO();
    }

    public Estancia buscarPorId(Integer idEstancia) throws Exception {
        if (idEstancia == null || idEstancia < 1) {
            throw new Exception("Debe indicar un idEstancia válido");
        }

        return estanciaDAO.buscarPorId(idEstancia);
    }

    public Collection<Estancia> listarAquellosQueAlquilaronUnaCasa() throws Exception {
        return estanciaDAO.listarAquellosQueAlquilaronUnaCasa();
    }

}
